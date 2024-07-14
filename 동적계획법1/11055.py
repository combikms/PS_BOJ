import sys

N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))

# dp[i]: i를 마지막으로 하는 LIS의 합

dp = [ A[i] for i in range (N) ]
for i in range (N):
    for j in range (i):
        if A[j] < A[i]:
            dp[i] = max(dp[i], dp[j] + A[i])

sys.stdout.write(str(max(dp)))