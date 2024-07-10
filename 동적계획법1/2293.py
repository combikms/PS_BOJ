import sys

n, k = map(int, sys.stdin.readline().split())
coin = []
for i in range (n):
    input = int(sys.stdin.readline())
    coin.append(input)

# dp[i]: i원을 만들 수 있는 경우의 수

dp = [0] * (k + 1)
dp[0] = 1

for value in coin:
    for i in range(value, k + 1):
        dp[i] += dp[i - value]

sys.stdout.write(str(dp[k]))