import sys
from collections import deque

T = int(sys.stdin.readline())
for _ in range (T):
    N = int(sys.stdin.readline())
    pillar = list(map(int, sys.stdin.readline().split()))
    pillar.sort()

    d = deque()
    dir = 0
    for i in range (N - 1, -1, -1):
        if dir == 0:
            d.append(pillar[i])
        else:
            d.appendleft(pillar[i])
        dir = 1 - dir
    
    maxd = 0
    for i in range (N):
        if i == N - 1:
            maxd = max(maxd, abs(d[0] - d[N - 1]))
        else:
            maxd = max(maxd, abs(d[i + 1] - d[i]))
    
    sys.stdout.write(str(maxd) + '\n')