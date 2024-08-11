import sys
from collections import deque

K = int(sys.stdin.readline())
W, H = map(int, sys.stdin.readline().split())

graph = []
for _ in range(H):
    graph.append(list(map(int, sys.stdin.readline().split())))

dr = [1, -1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2]
dc = [0, 0, 1, -1, 1, 2, 2, 1, -1, -2, -2, -1]

# dist[r][c][k]: (r, c)로 가는데 사기 능력을 k번 쓴 경우 최소 이동 거리
dist = [[[float("inf")] * (K + 1) for _ in range(W)] for _ in range(H)]


def minCheck(nu, pos):
    md = float("inf")
    for i in range(nu + 1):
        md = min(md, pos[i])
    return md


def bfs():
    q = deque([(0, 0, 0)])
    dist[0][0][0] = 0

    while q:
        cr, cc, cu = q.popleft()
        for i in range(12):
            nr = cr + dr[i]
            nc = cc + dc[i]
            nu = cu if i < 4 else cu + 1

            if 0 <= nr < H and 0 <= nc < W and 0 <= nu <= K:
                if graph[nr][nc] == 0:
                    if minCheck(nu, dist[nr][nc]) > dist[cr][cc][cu] + 1:
                        dist[nr][nc][nu] = dist[cr][cc][cu] + 1
                        q.append([nr, nc, nu])


bfs()

ans = min(dist[H - 1][W - 1])
if ans == float("inf"):
    print(-1)
else:
    print(ans)
