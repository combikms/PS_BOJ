import sys
from collections import deque

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

H, W = map(int, sys.stdin.readline().split())
graph = []
for _ in range(H):
    graph.append(list(map(int, sys.stdin.readline().split())))


def BFS():
    visited = [[0] * W for _ in range(H)]
    q = deque([(0, 0)])
    visited[0][0] = 1
    isCheesy = False

    while q:
        cr, cc = q.popleft()
        for i in range(4):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if 0 <= nr < H and 0 <= nc < W:
                if graph[nr][nc] == 0 and visited[nr][nc] == 0:
                    visited[nr][nc] = 1
                    q.append([nr, nc])
                elif graph[nr][nc] == 1:
                    isCheesy = True
                    if visited[nr][nc] == 0:
                        visited[nr][nc] = 1
                    elif visited[nr][nc] == 1:
                        visited[nr][nc] = 2
                        graph[nr][nc] = 0

    return isCheesy


t = 0
while BFS():
    t += 1

sys.stdout.write(str(t) + "\n")
