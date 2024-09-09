import sys

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
parent = [i for i in range(N + 1)]
rank = [1] * (N + 1)
line = []

for _ in range(M):
    line.append(list(map(int, sys.stdin.readline().split())))

line.sort(key=lambda x: x[2])


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
    elif rank[B] >= rank[A]:
        parent[A] = B
    else:
        parent[B] = A
        rank[A] += 1

    return True


ans = 0
for l in line:
    if union(l[0], l[1]):
        ans += l[2]

print(ans)