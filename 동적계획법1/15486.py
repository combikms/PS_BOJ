import sys

N = int(sys.stdin.readline())
consult = [[0, 0]]
for _ in range (N):
    T, P = map(int, sys.stdin.readline().split())
    consult.append([T, P])

# 거꾸로 가보자 ( dp[i]: i일차까지 거슬러 올라가봤을 때 뽑아낸 최대 이익 )
dp = [0] * (N + 2)
for i in range (N, 0, -1):
    T, P = consult[i]    
    if i + T <= N + 1:
        dp[i] = max(dp[i + T] + P, dp[i + 1]) # 상담 한다, 상담 안 한다
    else: # 이 부분 없으면 1%에서 틀린다..
        dp[i] = dp[i + 1]

sys.stdout.write(str(dp[1]))