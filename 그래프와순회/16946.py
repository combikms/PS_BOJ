import sys
from collections import deque

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

N, M = map(int, sys.stdin.readline().split())
graph = []
for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().strip())))
components = [[0] * M for _ in range(N)]
id = [[-1] * M for _ in range(N)]

# 컴포넌트마다
# 유니크한 아이디, 크기 정보 저장


def bfs(r, c, ai):
    visited = set()
    visited.add((r, c))
    q = deque([(r, c)])
    c_size = 1

    while q:
        cr, cc = q.popleft()
        for i in range(4):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if 0 <= nr < N and 0 <= nc < M:
                if not (nr, nc) in visited and graph[nr][nc] == 0:
                    visited.add((nr, nc))
                    q.append([nr, nc])
                    c_size += 1

    for r, c in visited:
        components[r][c] = c_size
        id[r][c] = ai


ai = 0
for r in range(N):
    for c in range(M):
        if graph[r][c] == 0 and components[r][c] == 0:
            bfs(r, c, ai)
            ai += 1

ans = [[0] * M for _ in range(N)]
for r in range(N):
    for c in range(M):
        if graph[r][c] == 1:
            nums = set()
            cans = 0
            for i in range(4):
                nr = r + dr[i]
                nc = c + dc[i]
                if 0 <= nr < N and 0 <= nc < M:
                    num = id[nr][nc]
                    if not num in nums:
                        cans += components[nr][nc]
                        nums.add(num)
            ans[r][c] += cans + 1

for r in range(N):
    for c in range(M):
        sys.stdout.write(str(ans[r][c] % 10))
    sys.stdout.write("\n")
