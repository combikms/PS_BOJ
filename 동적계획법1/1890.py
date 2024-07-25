import sys

N = int(sys.stdin.readline())
graph = []
for _ in range (N): graph.append(list(map(int, sys.stdin.readline().split())))

# dp[R][C]: (R, C)로 가는 방법의 개수

dp = [ [0] * N for _ in range (N) ]
dp[0][0] = 1
for r in range (N):
    for c in range (N):
        if r == c == N - 1:
            continue
        if 0 <= r + graph[r][c] < N:
            dp[r + graph[r][c]][c] += dp[r][c]
        if 0 <= c + graph[r][c] < N:
            dp[r][c + graph[r][c]] += dp[r][c]

sys.stdout.write(str(dp[N - 1][N - 1]) + '\n')