import sys

T = int(sys.stdin.readline())
for _ in range (T):
    N = int(sys.stdin.readline())
    sticker = []
    for _ in range (2):
        sticker.append(list(map(int, sys.stdin.readline().split())))
    
    # dp[i][0], dp[i][1], dp[i][2]
    # => i열까지 고려할 때, 마지막 거 0행 고른 경우, 마지막 거 1행 고른 경우, 안 고른 경우
    # 즉, 궁금한 것은 max( dp[i][0], dp[i][1], dp[i][2] )
        

    dp = [ [0] * 3 for _ in range (N) ]
    dp[0][0] = sticker[0][0]
    dp[0][1] = sticker[1][0]

    for i in range (1, N):
        dp[i][0] = max(dp[i - 1][1], dp[i - 1][2]) + sticker[0][i]
        dp[i][1] = max(dp[i - 1][0], dp[i - 1][2]) + sticker[1][i]
        dp[i][2] = max( dp[i - 1][0], dp[i - 1][1], dp[i - 1][2])
    
    sys.stdout.write(str(max(dp[N - 1][0], dp[N - 1][1], dp[N - 1][2])) + "\n")