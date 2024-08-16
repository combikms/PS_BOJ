import sys

N = int(sys.stdin.readline())
house = []
for _ in range(N):
    R, G, B = map(int, sys.stdin.readline().split())
    house.append([R, G, B])

dp0 = [[0, 0, 0] for _ in range(N)]
dp1 = [[0, 0, 0] for _ in range(N)]
dp2 = [[0, 0, 0] for _ in range(N)]
dp0[0][0], dp0[0][1], dp0[0][2] = house[0][0], float("inf"), float("inf")
dp1[0][0], dp1[0][1], dp1[0][2] = float("inf"), house[0][1], float("inf")
dp2[0][0], dp2[0][1], dp2[0][2] = float("inf"), float("inf"), house[0][2]

for i in range(1, N - 1):
    for dp in (dp0, dp1, dp2):
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + house[i][0]
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + house[i][1]
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + house[i][2]

dp0[N - 1][0] = float("inf")
dp0[N - 1][1] = min(dp0[N - 2][0], dp0[N - 2][2]) + house[N - 1][1]
dp0[N - 1][2] = min(dp0[N - 2][0], dp0[N - 2][1]) + house[N - 1][2]

dp1[N - 1][0] = min(dp1[N - 2][1], dp1[N - 2][2]) + house[N - 1][0]
dp1[N - 1][1] = float("inf")
dp1[N - 1][2] = min(dp1[N - 2][0], dp1[N - 2][1]) + house[N - 1][2]

dp2[N - 1][0] = min(dp2[N - 2][1], dp2[N - 2][2]) + house[N - 1][0]
dp2[N - 1][1] = min(dp2[N - 2][0], dp2[N - 2][2]) + house[N - 1][1]
dp2[N - 1][2] = float("inf")


ans = float("inf")
for dp in (dp0, dp1, dp2):
    for i in range(3):
        ans = min(dp[N - 1][i], ans)

print(ans)
