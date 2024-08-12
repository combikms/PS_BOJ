import sys
import heapq

N, M, K = map(int, sys.stdin.readline().split())
A = []
for _ in range(N):
    A.append(list(map(int, sys.stdin.readline().split())))

yb = [[5] * (N) for _ in range(N)]
tree = []

for _ in range(M):
    temp = list(map(int, sys.stdin.readline().split()))
    heapq.heappush(tree, [temp[0] - 1, temp[1] - 1, temp[2]])

dr = [1, -1, 0, 0, 1, 1, -1, -1]
dc = [0, 0, 1, -1, 1, -1, 1, -1]


def Sewol():
    global tree
    live_tree = []
    dead_tree = []

    # Spring
    while tree:
        t = heapq.heappop(tree)
        if yb[t[0]][t[1]] >= t[2]:
            yb[t[0]][t[1]] -= t[2]
            t[2] += 1
            heapq.heappush(live_tree, t)
        else:
            dead_tree.append(t)
    tree = live_tree

    # Summer
    while dead_tree:
        t = dead_tree.pop()
        yb[t[0]][t[1]] += t[2] // 2

    # Fall
    new_tree = []
    for t in tree:
        cr, cc = t[0], t[1]
        if t[2] % 5 == 0:
            for i in range(8):
                nr = cr + dr[i]
                nc = cc + dc[i]
                if 0 <= nr < N and 0 <= nc < N:
                    new_tree.append([nr, nc, 1])
    while new_tree:
        heapq.heappush(tree, new_tree.pop())

    # Winter
    for r in range(N):
        for c in range(N):
            yb[r][c] += A[r][c]


for _ in range(K):
    Sewol()

print(len(tree))
