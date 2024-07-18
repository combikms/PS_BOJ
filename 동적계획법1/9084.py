import sys

T = int(sys.stdin.readline())
for _ in range (T):
    N = int(sys.stdin.readline())
    coin = list(map(int, sys.stdin.readline().split()))
    M = int(sys.stdin.readline())

    dp = [0] * (M + 1)
    dp[0] = 1
    for val in coin:
        for i in range (val, M + 1):  # val부터 시작하니까 중복이 안 되는 거라고?      
            dp[i] += dp[i - val] # 현재 주목중인 value만 쳐다본다?
    
    sys.stdout.write(str(dp[-1]) + '\n' )