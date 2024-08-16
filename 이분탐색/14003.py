# 괜히 플레 문제가 아니다.. O(NlogN) 안에 해결해야함

import sys

N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))

dp = [1] * N
for i in range(N):
    for j in range(i):
        if A[j] < A[i]:
            dp[i] = max(dp[i], dp[j] + 1)

ans1 = max(dp)
ans2 = []
ci = -1
cv = -1
for i in range(N - 1, -1, -1):
    if dp[i] == ans1:
        ans2.append(A[i])
        ci = i
        cv = A[i]
        break

for i in range(ci, -1, -1):
    if dp[ci] - 1 == dp[i] and A[i] < A[ci]:
        ans2.append(A[i])
        ci = i
        cv = A[i]

sys.stdout.write(str(ans1) + "\n")
for i in range(len(ans2) - 1, -1, -1):
    sys.stdout.write(str(ans2[i]) + " ")
sys.stdout.write("\n")
