import sys

N, M, K = map(int, sys.stdin.readline().split())
fireball = []  # r, c, m, s, d
for _ in range(M):
    fireball.append(list(map(int, sys.stdin.readline().split())))

dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]

for f in fireball:
    f[0] -= 1
    f[1] -= 1


def mv():
    global fireball, N

    # 이동
    for f in fireball:
        f[0] = (f[0] + dr[f[4]] * f[3]) % N
        f[1] = (f[1] + dc[f[4]] * f[3]) % N

    # 배치
    graph = [[[] for _ in range(N)] for _ in range(N)]
    for i in range(len(fireball)):
        graph[fireball[i][0]][fireball[i][1]].append(i)

    # 합치고 나누기
    new_fireball = []
    for r in range(N):
        for c in range(N):
            if len(graph[r][c]) > 1:
                sum_m, sum_s = 0, 0
                dir_even = dir_odd = True
                for i in graph[r][c]:
                    if fireball[i][4] % 2 == 0:
                        dir_odd = False
                    else:
                        dir_even = False
                    sum_m += fireball[i][2]
                    sum_s += fireball[i][3]
                sum_m //= 5
                sum_s //= len(graph[r][c])
                for i in range(4):
                    if sum_m > 0:
                        if dir_even or dir_odd:
                            new_fireball.append([r, c, sum_m, sum_s, 2 * i])
                        else:
                            new_fireball.append([r, c, sum_m, sum_s, (2 * i) + 1])
            elif len(graph[r][c]) == 1:
                new_fireball.append(fireball[graph[r][c][0]])
    fireball = new_fireball


while K != 0:
    mv()
    K -= 1

ans = 0
for f in fireball:
    ans += f[2]

sys.stdout.write(str(ans) + "\n")
