import sys

T = 0
while True:
    T += 1

    N = int(sys.stdin.readline())
    if N == 0: break

    graph = []
    for _ in range (N): graph.append(list(map(int, sys.stdin.readline().split())))

    # dp[i][k]: i번째까지 고려, 마지막에 k번째 거 선택

    dp = [ [0] * 3 for _ in range (N) ]
    dp[0] = [0, graph[0][1], graph[0][1] + graph[0][2]]    

    dp[1][0] = graph[0][1] + graph[1][0]
    dp[1][1] = min(dp[1][0], graph[0][1], dp[0][2]) + graph[1][1]
    dp[1][2] = min(dp[1][1], graph[0][1], dp[0][2]) + graph[1][2]


    for i in range (2, N):
        dp[i][0] = min(dp[i - 1][0], dp[i - 1][1]) + graph[i][0]
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]) + graph[i][1]
        dp[i][2] = min(dp[i - 1][1], dp[i - 1][2]) + graph[i][2]
        dp[i][1] = min(dp[i][1], dp[i][0] + graph[i][1])
        dp[i][2] = min(dp[i][2], dp[i][1] + graph[i][2])    
    
    sys.stdout.write(f"{T}. {dp[N - 1][1]}\n")