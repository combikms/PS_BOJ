import sys

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())

vip = [False] * (N + 1)
for i in range (M):
    vip[int(sys.stdin.readline())] = True

# dp[i][0]: i번 좌석까지 고려할 때, i가 제자리에 앉은 경우
# dp[i][1]: i번 좌석까지 고려할 때, i가 제자리에 지 왼쪽에 앉은 경우 => i-1번째랑 바꾼 경우

# 궁금한 것은 바로 dp[i][0] + dp[i][1] 이다!

# dp[i][0] = dp[i - 1][0] + dp[i - 1][1]
# dp[i][1] = dp[i - 2][0] + dp[i - 2][1]  
#   => vip[i]인 경우엔 고려하지 않는다.
#   => i - 1번째가 vip여도 고려하지 않는다.

dp = [ [0] * 2 for _ in range (N + 1)]
dp[0][0] = 1
dp[1][0] = 1

for i in range (2, N + 1):
    dp[i][0] = dp[i - 1][0] + dp[i - 1][1]
    if not vip[i] and not vip[i - 1]:
        dp[i][1] = dp[i - 2][0] + dp[i - 2][1]

sys.stdout.write(str(dp[N][0] + dp[N][1]))