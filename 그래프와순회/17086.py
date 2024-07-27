import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
graph = []
for _ in range (N): graph.append(list(map(int, sys.stdin.readline().split())))
dr = [1, -1, 0, 0, 1, 1, -1, -1]
dc = [0, 0, 1, -1, 1, -1, -1, 1]

def BFS(r, c):
    dist = [ [-1] * M for _ in range (N) ]
    dist[r][c] = 0
    q = deque([(r, c)])

    while q:
        cr, cc = q.popleft()
        for i in range (8):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if 0 <= nr < N and 0 <= nc < M:
                if graph[nr][nc] == 1:
                    return dist[cr][cc] + 1
                else:
                    if dist[nr][nc] == -1:
                        dist[nr][nc] = dist[cr][cc] + 1
                        q.append([nr, nc])
    
    return -1

ans = 0
for r in range (N):
    for c in range (M):
        if graph[r][c] == 0:
            ans = max(ans, BFS(r, c))

sys.stdout.write(str(ans) + '\n')