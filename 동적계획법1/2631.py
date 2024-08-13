import sys

N = int(sys.stdin.readline())
o = []
for _ in range(N):
    o.append(int(sys.stdin.readline()))

# LIS를 알아낸다음, 나머지 요소들을 LIS 사이사이에 끼워맞추기
# => 즉, N - LIS길이가 답

dp = [1] * N
for i in range(N):
    for j in range(i):
        if o[j] < o[i]:
            dp[i] = max(dp[i], dp[j] + 1)
print(N - max(dp))