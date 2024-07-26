import sys
from collections import deque

N = int(sys.stdin.readline())
r1, c1, r2, c2 = map(int, sys.stdin.readline().split())

dr = [-2, -2, 0, 0, 2, 2]
dc = [-1, 1, -2, 2, -1, 1]

dist = [ [-1] * N for _ in range (N) ]
dist[r1][c1] = 0
q = deque([(r1, c1)])

while q:
    cr, cc = q.popleft()
    for i in range (6):
        nr = cr + dr[i]
        nc = cc + dc[i]
        if 0 <= nr < N and 0 <= nc < N:
            if dist[nr][nc] == -1:
                dist[nr][nc] = dist[cr][cc] + 1
                q.append([nr, nc])

sys.stdout.write(str(dist[r2][c2]) + '\n')