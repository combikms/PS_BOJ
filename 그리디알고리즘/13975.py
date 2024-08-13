import sys
import heapq

T = int(sys.stdin.readline())
for _ in range(T):
    K = int(sys.stdin.readline())
    file_ = list(map(int, sys.stdin.readline().split()))
    heapq.heapify(file_)
    ans = 0
    while len(file_) > 1:
        a = heapq.heappop(file_)
        b = heapq.heappop(file_)
        ans += a + b
        heapq.heappush(file_, a + b)
    print(ans)
