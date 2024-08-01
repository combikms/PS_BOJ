import sys

N = int(sys.stdin.readline())
mat = []
for _ in range(N):
    mat.append(list(map(int, sys.stdin.readline().split())))

# dp[i][j]: i번째 ~ j번째까지 최적 곱셈 횟수
# (ABC)D, (AB)(CD), A(BCD)
# dp[i][k]
# => 중간에 k를 끼워박아넣어서 괄호의 위치에 따른 값을 계속 갱신해줘야 할 듯
# => O(N ^ 2)
# => 답은 dp[0][N - 1]

dp = [[2147483647] * N for _ in range(N)]
for i in range(N):
    dp[i][i] = 0
for size in range(1, N):  # 괄호의 최대 크기
    for i in range(N - size):
        for k in range(i, i + size):
            dp[i][i + size] = min(
                dp[i][i + size],
                dp[i][k]
                + dp[k + 1][i + size]
                + mat[i][0] * mat[k][1] * mat[i + size][1],
            )

sys.stdout.write(str(dp[0][N - 1]) + "\n")