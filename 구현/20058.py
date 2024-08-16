import sys
from collections import deque

N, Q = map(int, sys.stdin.readline().split())
size = 2**N
A = []
for _ in range(size):
    A.append(list(map(int, sys.stdin.readline().split())))

magic = list(map(int, sys.stdin.readline().split()))


def rotate(L):
    for r in range(0, size, 2**L):
        for c in range(0, size, 2**L):
            new_grid = []
            for nc in range(c, c + (2**L)):
                new_row = []
                for nr in range(r + (2**L) - 1, r - 1, -1):
                    new_row.append(A[nr][nc])
                new_grid.append(new_row)
            for nr in range(r, r + (2**L)):
                for nc in range(c, c + (2**L)):
                    A[nr][nc] = new_grid[nr - r][nc - c]


dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]


def melt():
    danger_block = []
    for r in range(size):
        for c in range(size):
            if A[r][c] != 0:
                neighbors = 0
                for i in range(4):
                    nr = r + dr[i]
                    nc = c + dc[i]
                    if 0 <= nr < size and 0 <= nc < size:
                        if A[nr][nc] != 0:
                            neighbors += 1
                if neighbors < 3:
                    danger_block.append([r, c])

    for b in danger_block:
        A[b[0]][b[1]] -= 1


for L in magic:
    rotate(L)
    melt()

ans1 = sum(sum(row) for row in A)
visited = [[False] * size for _ in range(size)]


def bfs(r, c):
    cnt = 1
    visited[r][c] = True
    q = deque([(r, c)])

    while q:
        cr, cc = q.popleft()
        for i in range(4):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if 0 <= nr < size and 0 <= nc < size:
                if A[nr][nc] != 0 and not visited[nr][nc]:
                    cnt += 1
                    visited[nr][nc] = True
                    q.append([nr, nc])

    return cnt


ans2 = 0
for r in range(size):
    for c in range(size):
        if not visited[r][c] and A[r][c] != 0:
            ans2 = max(ans2, bfs(r, c))

sys.stdout.write(f"{ans1}\n{ans2}\n")
