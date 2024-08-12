import sys
import heapq

N, M, K = map(int, sys.stdin.readline().split())
A = []
for _ in range(N):
    A.append(list(map(int, sys.stdin.readline().split())))

yb = [[5] * N for _ in range(N)]
tree = [[[] for _ in range(N)] for _ in range(N)]

for _ in range(M):
    r, c, age = map(int, sys.stdin.readline().split())
    tree[r - 1][c - 1].append(age)

dr = [1, -1, 0, 0, 1, 1, -1, -1]
dc = [0, 0, 1, -1, 1, -1, 1, -1]


def Sewol():
    global tree

    # Spring and Summer
    for r in range(N):
        for c in range(N):
            if tree[r][c]:
                tree[r][c].sort()
                live_tree = []
                new_yb = 0
                for t in tree[r][c]:
                    if yb[r][c] >= t:
                        yb[r][c] -= t
                        live_tree.append(t + 1)
                    else:
                        new_yb += t // 2
                yb[r][c] += new_yb
                tree[r][c] = live_tree

    # Fall
    new_tree = []
    for r in range(N):
        for c in range(N):
            for t in tree[r][c]:
                if t % 5 == 0:
                    for i in range(8):
                        nr = r + dr[i]
                        nc = c + dc[i]
                        if 0 <= nr < N and 0 <= nc < N:
                            new_tree.append([nr, nc])
    for nt in new_tree:
        tree[nt[0]][nt[1]].append(1)

    # Winter
    for r in range(N):
        for c in range(N):
            yb[r][c] += A[r][c]


for _ in range(K):
    Sewol()

ans = 0
for r in range(N):
    for c in range(N):
        ans += len(tree[r][c])

print(ans)
