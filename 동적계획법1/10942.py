import sys

N = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))

# 각 자리마다 어디를 끝으로 맺어야 펠린드롬이 되는지를 선 저장?
# 중간 기준으로 양쪽으로 뻗어나가는 게 나을 듯

dp = [[False] * N for _ in range(N)]
for i in range(N):
    dp[i][i] = True

for m in range(N * 2):
    if m < N:
        l = m - 1
        r = m + 1
    else:
        l = m - N
        r = m - N + 1

    while 0 <= l <= m % N and m % N < r < N:
        if num[l] == num[r] and (dp[l + 1][r - 1] == True or r - l == 1):
            dp[l][r] = True
        l -= 1
        r += 1

M = int(sys.stdin.readline())
for _ in range(M):
    s, e = map(int, sys.stdin.readline().split())
    if dp[s - 1][e - 1]:
        sys.stdout.write("1" + "\n")
    else:
        sys.stdout.write("0" + "\n")
