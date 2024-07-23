import sys

N, M = map(int, sys.stdin.readline().split())
graph = []
for _ in range (N): graph.append(list(map(int, sys.stdin.readline().split())))

dp = [[0] * M for _ in range (N)]
dp[0][0] = graph[0][0]
for R in range (N):
    for C in range (M):
        if 0 <= C - 1 < M:
            dp[R][C] = max(dp[R][C], dp[R][C - 1] + graph[R][C])
        if 0 <= R - 1 < N:
            dp[R][C] = max(dp[R][C], dp[R - 1][C] + graph[R][C])
        if 0 <= C - 1 < M and 0 <= R - 1 < N:
            dp[R][C] = max(dp[R][C], dp[R - 1][C - 1] + graph[R][C])

sys.stdout.write(str(dp[N - 1][M - 1]) + '\n')