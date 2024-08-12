import sys
from collections import deque

N = int(sys.stdin.readline())
graph = []
for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().split())))

lv = 2
exp = 0
t = 0
cp = []

for r in range(N):
    for c in range(N):
        if graph[r][c] == 9:
            cp = [r, c]


def mv(d):
    global cp
    temp = cp
    cp = [d[0], d[1]]
    graph[temp[0]][temp[1]] = 0


dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]


def bfs():
    global lv, cp
    item = []
    q = deque([(cp[0], cp[1])])
    dist = [[-1] * N for _ in range(N)]
    dist[cp[0]][cp[1]] = 0

    while q:
        cr, cc = q.popleft()
        for i in range(4):
            nr = cr + dr[i]
            nc = cc + dc[i]

            if 0 <= nr < N and 0 <= nc < N and dist[nr][nc] == -1:
                if graph[nr][nc] <= lv:
                    if 0 < graph[nr][nc] < lv:
                        item.append([dist[cr][cc] + 1, [nr, nc]])
                    dist[nr][nc] = dist[cr][cc] + 1
                    q.append([nr, nc])

    item.sort()
    return item


while True:
    item = bfs()
    if not item:
        break
    else:
        mv(item[0][1])
        t += item[0][0]
        exp += 1

        if exp == lv:
            lv += 1
            exp = 0

print(t)
