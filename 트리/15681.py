import sys

sys.setrecursionlimit(10**6)

N, R, Q = map(int, sys.stdin.readline().split())
tree = [[] for _ in range(N + 1)]
for _ in range(N - 1):
    fn, sn = map(int, sys.stdin.readline().split())
    tree[fn].append(sn)
    tree[sn].append(fn)

child = [-1] * (N + 1)


def dfs(node):
    child[node] = 1
    if not tree[node]:
        return 1
    for neighbor in tree[node]:
        if child[neighbor] == -1:
            child[node] += dfs(neighbor)

    return child[node]


dfs(R)
for _ in range(Q):
    node_num = int(sys.stdin.readline())
    sys.stdout.write(str(child[node_num]) + "\n")
