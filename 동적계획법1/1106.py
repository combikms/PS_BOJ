import sys

C, N = map(int, sys.stdin.readline().split())
promotion = [[0, 0]]
for _ in range(N):
    promotion.append(list(map(int, sys.stdin.readline().split())))

# dp[i][j]: i번 홍보까지 고려했을 때, j명 끌어들이기 위한 최소 비용
# => 답: dp[N-1][C]

dp = [[float("inf")] * (C + 1) for _ in range(N + 1)]
for i in range(N + 1):
    dp[i][0] = 0

for i in range(1, N + 1):  # 홍보 하나씩 까보기
    for j in range(0, C + 1, promotion[i][1]):
        for k in range(1, promotion[i][1] + 1):  # 돈 간격
            if j + k < C + 1:
                dp[i][j + k] = min(dp[i - 1][j + k], dp[i][j] + promotion[i][0])

    for row in dp:
        print(row)


print(dp[N][C])
