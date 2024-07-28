import sys

H, W = map(int, sys.stdin.readline().split())
graph = []
for _ in range (H): graph.append(list(map(int, sys.stdin.readline().split())))

# 자기 기준 좌, 우, 북서 방향으로 얼마나 확장시킬지 살펴본다.
# dp[r][c] = min(dp[r - 1][c], dp[r][c - 1], dp[r - 1][c - 1]) + 1
# => 벽이나 장애물 같은 건 0이다.

# 1 1 1 * 1 1
# 1 2 2 * * 1
# 1 2 * 1 1 1
# 1 * 1 1 2 2
# * 1 1 2 2 3
# 1 1 2 2 3 3

dp = [ [0] * W for _ in range (H) ]
ans = 0
for r in range (H):
    for c in range (W):
        if r > 0 and c > 0:
            if graph[r][c] == 0:
                dp[r][c] = min(dp[r - 1][c], dp[r][c - 1], dp[r - 1][c - 1]) + 1
                ans = max(ans, dp[r][c])
        else:
            if graph[r][c] == 0:
                dp[r][c] = 1
                ans = max(ans, dp[r][c])

sys.stdout.write(str(ans) + '\n')