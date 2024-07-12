import sys

N = int(sys.stdin.readline())
if N == 1:
    sys.stdout.write("10")
    exit(0)

# dp[i][j] = i자리고, 첫 자리가 j인 것의 오르막 수
# i자리 오르막 개수는 dp[i][0] ~ dp[i][9]의 총합
# dp[1][0] ~ dp[i][9] = 1
# dp[2][0] = dp[1][0] + ... + dp[1][9] = 10
# dp[2][1] = dp[1][1] + ... + dp[1][9] = 9
# dp[2][2] = dp[1][2] + ... + dp[1][9] = 8
# ...
# dp[3][1] = dp[2][1] + ... + dp[2][9]
# dp[3][2] = dp[2][2] + ... + dp[2][9]

dp = [ [0 for _ in range (10)] for _ in range (N + 1) ]
dp[1] = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
for i in range (2, N + 1):
    for j in range (10):
        for k in range (j, 10):
            dp[i][j] += dp[i - 1][k]

ans = 0
for i in range(10):
    ans += dp[N][i]

ans %= 10007
sys.stdout.write(str(ans))