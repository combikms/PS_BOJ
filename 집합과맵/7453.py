import sys
from collections import Counter

N = int(sys.stdin.readline())
A, B, C, D = [], [], [], []
for _ in range(N):
    a, b, c, d = map(int, sys.stdin.readline().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)

AB = Counter()
for a in A:
    for b in B:
        AB[a + b] += 1

ans = 0
for c in C:
    for d in D:
        ans += AB[-(c + d)]

print(ans)
