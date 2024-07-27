import sys

N = int(sys.stdin.readline())
f = list(map(int, sys.stdin.readline().split()))

# dp[i][k]: i번 원소까지 써서 k를 만드는 방법의 수
# => 답: dp[N - 2][f[N - 1]]

dp = [ [0] * 21 for _ in range (N - 1) ]
dp[0][f[0]] = 1
for i in range (1, N - 1):
    for j in range (21):
        prev = [ j - f[i], j + f[i] ]
        for k in prev:
            if 0 <= k <= 20:
                dp[i][j] += dp[i - 1][k]

sys.stdout.write(str(dp[N - 2][f[N - 1]]) + '\n')