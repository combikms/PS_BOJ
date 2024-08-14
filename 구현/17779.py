import sys
from collections import deque

N = int(sys.stdin.readline())
A = []
for _ in range(N):
    A.append(list(map(int, sys.stdin.readline().split())))

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]


def draw(x, y, d1, d2):
    section = [[0] * N for _ in range(N)]
    for i in range(d1 + 1):
        for j in range(d2 + 1):
            section[x + i + j][y - i + j] = 5

    for i in range(d1):
        for j in range(d2):
            section[x + 1 + i + j][y - i + j] = 5

    for r in range(N):
        if r < x + d1:
            for c in range(y + 1):
                if section[r][c] == 5:
                    break
                section[r][c] = 1
        else:
            for c in range(y - d1 + d2):
                if section[r][c] == 5:
                    break
                section[r][c] = 3

    for r in range(N):
        if r <= x + d2:
            for c in range(N - 1, y, -1):
                if section[r][c] == 5:
                    break
                section[r][c] = 2
        else:
            for c in range(N - 1, y - d1 + d2 - 1, -1):
                if section[r][c] == 5:
                    break
                section[r][c] = 4

    return section


def countPop(r, c, num, visited, section):
    pop = A[r][c]
    visited[r][c] = True
    q = deque([(r, c)])

    while q:
        cr, cc = q.popleft()
        for i in range(4):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if 0 <= nr < N and 0 <= nc < N and not visited[nr][nc]:
                if section[nr][nc] == num:
                    visited[nr][nc] = True
                    pop += A[nr][nc]
                    q.append([nr, nc])

    return pop


ans = float("inf")
for x in range(N):
    for y in range(N):
        for d1 in range(1, min(y + 1, N - x)):
            for d2 in range(1, min(N - (x + d1), N - y)):
                section = draw(x, y, d1, d2)
                visited = [[False] * N for _ in range(N)]
                sec_pop = [0, 0, 0, 0, 0]
                for r in range(N):
                    for c in range(N):
                        if not visited[r][c]:
                            sec_pop[section[r][c] - 1] = countPop(
                                r, c, section[r][c], visited, section
                            )
                ans = min(ans, max(sec_pop) - min(sec_pop))

print(ans)
