import sys
import heapq

n, m = map(int, sys.stdin.readline().split())
a = list(map(int, sys.stdin.readline().split()))
heapq.heapify(a)

for i in range(m):
    x = heapq.heappop(a)
    y = heapq.heappop(a)
    for _ in range (2):
        heapq.heappush(a, x + y)

sys.stdout.write(str(sum(a)))