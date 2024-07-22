import sys

N = int(sys.stdin.readline())
graph = []
for _ in range (N): graph.append(list(map(int, sys.stdin.readline().split())))

# 상태 표기법
# dp[R][C][k]: 한쪽 끝이 (R, C)를 가리키는데, 방향을 어케 보고 있는 지 (k: 가로, 세로, 대각)

dp = [ [[0] * 3 for _ in range (N) ] for _ in range (N) ]
dp[0][1][0] = 1

for R in range (N):
    for C in range (N):
        if graph[R][C] != 1:            
            if 0 <= C - 2 < N and graph[R][C - 1] == 0 and graph[R][C - 2] == 0: # 가로 1
                dp[R][C][0] += dp[R][C - 1][0]
            if 0 <= R - 1 < N and 0 <= C - 2 < N and graph[R][C - 1] == 0 and graph[R - 1][C - 2] == 0:  # 대각 1
                dp[R][C][0] += dp[R][C - 1][2]
            
            if 0 <= R - 2 < N and graph[R - 1][C] == 0 and graph[R - 2][C] == 0:  # 세로 1
                dp[R][C][1] += dp[R - 1][C][1]
            if 0 <= C - 1 < N and 0 <= R - 2 < N and graph[R - 1][C] == 0 and graph[R - 2][C - 1] == 0: # 대각 2
                dp[R][C][1] += dp[R - 1][C][2]
            
            if graph[R - 1][C] == 0 and graph[R][C - 1] == 0:
                if 0 <= R - 1 < N and 0 <= C - 2 < N and graph[R - 1][C - 1] == 0 and graph[R - 1][C - 2] == 0: # 가로 2                
                    dp[R][C][2] += dp[R - 1][C - 1][0]
                if 0 <= C - 1 < N and 0 <= R - 2 < N and graph[R - 1][C - 1] == 0 and graph[R - 2][C - 1] == 0: # 세로 2
                    dp[R][C][2] += dp[R - 1][C - 1][1]
                if 0 <= C - 2 < N and 0 <= R - 2 < N and graph[R - 1][C - 1] == 0 and graph[R - 2][C - 2] == 0: # 대각 3
                    dp[R][C][2] += dp[R - 1][C - 1][2]

sys.stdout.write(str(sum(dp[N - 1][N - 1])) + '\n')