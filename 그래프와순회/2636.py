import sys
from collections import deque

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

H, W = map(int, sys.stdin.readline().split())
graph = []
for _ in range(H):
    graph.append(list(map(int, sys.stdin.readline().split())))


def BFS():
    visited = [[False] * W for _ in range(H)]
    q = deque([(0, 0)])
    cheeses = 0

    while q:
        cr, cc = q.popleft()
        for i in range(4):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if 0 <= nr < H and 0 <= nc < W and not visited[nr][nc]:
                if graph[nr][nc] == 1:
                    cheeses += 1
                    graph[nr][nc] = 0
                    visited[nr][nc] = True
                else:
                    visited[nr][nc] = True
                    q.append([nr, nc])

    return cheeses


time = 0
ans = 0
while True:
    melted = BFS()
    if melted == 0:
        break
    else:
        time += 1
        ans = melted

sys.stdout.write(f"{time}\n{ans}\n")
