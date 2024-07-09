import sys

# dp[N] = N번 물건이 LIS의 "마지막" 원소라고 가정할 때의 LIS 길이

N = int(sys.stdin.readline())
box = list(map(int, sys.stdin.readline().split()))

dp = [1] * N
for i in range(N):
    for j in range (i):
        if box[j] < box[i]:
            dp[i] = max(dp[i], dp[j] + 1)

sys.stdout.write(str(max(dp)))