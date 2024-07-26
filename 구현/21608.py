import sys

N = int(sys.stdin.readline())
preference = []
for _ in range (N * N): preference.append(list(map(int, sys.stdin.readline().split())))
graph = [ [0] * N for _ in range (N) ]
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

for student in preference: # 400
    pos = [N - 1, N - 1]
    max_friends = 0
    max_blanks = 0
    for r in range (N): # 20
        for c in range (N): # 20
            if graph[r][c] == 0:
                cur_friends = 0
                cur_blanks = 0
                for d in range (4): # 4
                    nr = r + dr[d]
                    nc = c + dc[d]
                    if 0 <= nr < N and 0 <= nc < N:
                        if graph[nr][nc] in student[1:]: cur_friends += 1
                        elif graph[nr][nc] == 0: cur_blanks += 1
                
                if max_friends < cur_friends:
                    max_friends = cur_friends
                    pos = [r, c]
                    max_blanks = cur_blanks
                elif max_friends == cur_friends:
                    if max_blanks < cur_blanks:
                        max_blanks = cur_blanks
                        pos = [r, c]
                    elif max_blanks == cur_blanks:
                        if pos[0] > r:
                            pos = [r, c]
                        elif pos[0] == r:
                            if pos[1] > c:
                                pos = [r, c]

    graph[pos[0]][pos[1]] = student[0]

ans = 0
for r in range (N):
    for c in range (N):
        idx = 0
        for i in range (N * N):
            if preference[i][0] == graph[r][c]:
                idx = i
                break
        
        friends = 0
        for d in range (4):
            nr = r + dr[d]
            nc = c + dc[d]
            if 0 <= nr < N and 0 <= nc < N:
                if graph[nr][nc] in preference[idx][1:]:
                    friends += 1

        score = 0 if friends == 0 else 10 ** (friends - 1)
        ans += score

sys.stdout.write(str(ans) + '\n')