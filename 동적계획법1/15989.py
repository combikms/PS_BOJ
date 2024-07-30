import sys

T = int(sys.stdin.readline())
for _ in range (T):
    N = int(sys.stdin.readline())    
    dp = [0] * (N + 1)
    dp[0] = 1
    for j in (1, 2, 3):
        for i in range (N + 1):        
            if i + j <= N: dp[i + j] += dp[i]
    sys.stdout.write(str(dp[N]) + '\n')