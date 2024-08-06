import sys
import heapq

# A, B, C
# (A + B) + ((A + B) + C)
# (A + C) + ((A + C) + B)
# => 허프만 알고리즘 느낌이...

N = int(sys.stdin.readline())
card = []
for _ in range(N):
    heapq.heappush(card, int(sys.stdin.readline()))

ans = 0
while len(card) > 1:
    a = heapq.heappop(card)
    b = heapq.heappop(card)
    ans += a + b
    heapq.heappush(card, a + b)

sys.stdout.write(str(ans) + "\n")
