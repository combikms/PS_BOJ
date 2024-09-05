import sys
import heapq

N, L = map(int, sys.stdin.readline().split())
A = list(map(int, sys.stdin.readline().split()))

buff = []

for i in range(N):
    heapq.heappush(buff, (A[i], i))

    while buff[0][1] <= i - L:
        heapq.heappop(buff)

    sys.stdout.write(str(buff[0][0]) + " ")
sys.stdout.write("\n")
