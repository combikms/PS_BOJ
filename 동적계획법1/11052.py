import sys

N = int(sys.stdin.readline())
P = [0]
temp = list(map(int, sys.stdin.readline().split()))
P.extend(temp)

# dp[i]: i개를 가장 비싸게 샀을 때 금액
# dp[i + p1], dp[i + p2], dp[i + p3], ... 점차 갱신?

dp = [i for i in P]

for i in range (N):
    for j in range(N - i + 1):
        dp[i + j] = max(dp[i + j], dp[i] + P[j])

sys.stdout.write(str(dp[N]) + '\n')