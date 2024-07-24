import sys

N, K = map(int, sys.stdin.readline().split())

# dp[i][k]: i를 k개 숫자의 합으로 분해하는 방법의 수

dp = [[0] * (K) for _ in range (N + 1)]
for n in dp:
    n[0] = 1

for i in range (0, N + 1):
    for j in range ((N + 1) - i):
        for k in range (K - 1):
            dp[i + j][k + 1] += dp[i][k]

sys.stdout.write(str(dp[N][K - 1] % 1000000000) + '\n')