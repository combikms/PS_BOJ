import sys

R, C, T = map(int, sys.stdin.readline().split())
graph = []
for _ in range(R):
    graph.append(list(map(int, sys.stdin.readline().split())))

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

gongchung = []
for r in range(R):
    if graph[r][0] == -1:
        gongchung.append(r)


def spread():
    memory = []  # [  [ [먼지 좌표], [방향], 확산량, 깎임 정보 ]  여러 개  ]
    for r in range(R):
        for c in range(C):
            if graph[r][c] > 0:
                temp = [[r, c], [], graph[r][c] // 5, 0]
                for i in range(4):
                    nr = r + dr[i]
                    nc = c + dc[i]
                    if 0 <= nr < R and 0 <= nc < C and graph[nr][nc] != -1:
                        temp[1].append(i)
                        temp[3] += graph[r][c] // 5
                memory.append(temp)

    for m in memory:
        graph[m[0][0]][m[0][1]] -= m[3]
        for i in m[1]:
            graph[m[0][0] + dr[i]][m[0][1] + dc[i]] += m[2]


def mvdirt():
    for r in range(gongchung[0] - 1, 0, -1):
        graph[r][0] = graph[r - 1][0]
    for c in range(0, C - 1):
        graph[0][c] = graph[0][c + 1]
    for r in range(0, gongchung[0]):
        graph[r][C - 1] = graph[r + 1][C - 1]
    for c in range(C - 1, 1, -1):
        graph[gongchung[0]][c] = graph[gongchung[0]][c - 1]
    graph[gongchung[0]][1] = 0

    for r in range(gongchung[1] + 1, R - 1):
        graph[r][0] = graph[r + 1][0]
    for c in range(0, C - 1):
        graph[R - 1][c] = graph[R - 1][c + 1]
    for r in range(R - 1, gongchung[1], -1):
        graph[r][C - 1] = graph[r - 1][C - 1]
    for c in range(C - 1, 1, -1):
        graph[gongchung[1]][c] = graph[gongchung[1]][c - 1]
    graph[gongchung[1]][1] = 0


while T != 0:
    spread()
    mvdirt()
    T -= 1

ans = 2
for row in graph:
    ans += sum(row)

sys.stdout.write(str(ans) + "\n")
