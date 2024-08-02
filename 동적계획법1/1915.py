import sys

H, W = map(int, sys.stdin.readline().split())
dp = []
for _ in range(H):
    dp.append(list(map(int, sys.stdin.readline().strip())))

ans = 0
for r in range(H):
    for c in range(W):
        if r == 0 or c == 0:
            ans = max(ans, dp[r][c] ** 2)
        elif dp[r][c] == 1:
            dp[r][c] = min(dp[r - 1][c], dp[r][c - 1], dp[r - 1][c - 1]) + 1
            ans = max(ans, dp[r][c] ** 2)

sys.stdout.write(str(ans) + "\n")