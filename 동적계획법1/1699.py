import sys
import math

# dp[i] = 그 수의 최소 항
# dp[1] = 1
# dp[i + 1], dp[i + 4], dp[i + 9] ... 갱신

N = int(sys.stdin.readline())

dp = [float('inf')] * (N + 1)
dp[0] = 0

for i in range (N + 1):
    for j in range (1, math.floor(N ** 0.5) + 1):
        next = i + j ** 2
        if next > N:
            break
        dp[next] = min(dp[next], dp[i] + 1)

sys.stdout.write(str(dp[N]))