import sys

dr = [0, 0, 0, -1, 1]
dc = [0, 1, -1, 0, 0]
dice = [0, 0, 0, 0, 0, 0]  # 하늘, 북, 동, 서, 남, 바닥

#  <초기>    <동>      <서>     <북>       <남>
#   2        2        2        1         6
# 4 1 3    6 4 1    1 3 6    4 5 3     4 2 3
#   5        5        5        6         1
#   6        3        4        2         5


N, M, x, y, K = map(int, sys.stdin.readline().split())
graph = []
for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().split())))

order = list(map(int, sys.stdin.readline().split()))
cr, cc = x, y


def rdOrder(d):
    global cr, cc, dice
    nr = cr + dr[d]
    nc = cc + dc[d]

    if 0 <= nr < N and 0 <= nc < M:
        cr, cc = nr, nc
        if d == 1:  # 421653
            dice = [dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]]
        elif d == 2:  # 326154
            dice = [dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]]
        elif d == 3:  # 513462
            dice = [dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]]
        else:  # 263415
            dice = [dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]]

        if graph[cr][cc] == 0:
            graph[cr][cc] = dice[5]
        else:
            dice[5] = graph[cr][cc]
            graph[cr][cc] = 0

        sys.stdout.write(str(dice[0]) + "\n")


for o in order:
    rdOrder(o)
