import sys
from collections import deque

C, R = map(int, sys.stdin.readline().split())
graph = []
for _ in range(R):
    graph.append(list(map(int, sys.stdin.readline().strip())))

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

# dist[r][c]: r, c까지 가는데, 벽을 뿌신 최소 횟수
dist = [[float("inf")] * C for _ in range(R)]


def BFS():
    dist[0][0] = 0
    q = deque([(0, 0)])

    while q:
        cr, cc = q.popleft()
        for i in range(4):
            nr = cr + dr[i]
            nc = cc + dc[i]

            if 0 <= nr < R and 0 <= nc < C:
                if graph[nr][nc] == 0 and dist[cr][cc] < dist[nr][nc]:
                    dist[nr][nc] = dist[cr][cc]
                    q.append([nr, nc])
                elif graph[nr][nc] == 1 and dist[cr][cc] + 1 < dist[nr][nc]:
                    dist[nr][nc] = dist[cr][cc] + 1
                    q.append([nr, nc])


BFS()
sys.stdout.write(str(dist[R - 1][C - 1]) + "\n")
