import sys

N, M = map(int, sys.stdin.readline().split())
road = []
rank = [1] * (N + 1)
parent = [i for i in range(N + 1)]
for _ in range(M):
    road.append(list(map(int, sys.stdin.readline().split())))
road.sort(key=lambda x: x[2])


def find(a):
    while a != parent[a]:
        a = parent[a]
    return parent[a]


def union(a, b):
    A, B = find(a), find(b)
    if A == B:
        return False

    if rank[A] > rank[B]:
        parent[B] = A
    elif rank[B] > rank[A]:
        parent[A] = B
    else:
        parent[B] = A
        rank[A] += 1

    return True


ans = 0
bridge_cost = -1
for r in road:
    if union(r[0], r[1]):
        ans += r[2]
        bridge_cost = max(bridge_cost, r[2])

ans -= bridge_cost
print(ans)
