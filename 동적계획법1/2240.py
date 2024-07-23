import sys

T, W = map(int, sys.stdin.readline().split())
plum = [0]
for _ in range (T): plum.append(int(sys.stdin.readline()))

# dp[t][w][k]: t초까지 고려, w번 이동, k에 위치 (1번 나무 or 2번 나무)
dp = [ [[0] * 3 for _ in range (W + 1) ] for _ in range (T + 1) ]

for t in range (1, T + 1):
    for w in range (W + 1):
        for k in range (1, 3):
            if (w % 2) + 1 == plum[t] == k: # 그 위치에 가만히 있었다, 다른 데서 이동해서 글로 왔다.                
                if w > 0:
                    dp[t][w][k] = max(dp[t - 1][w][k] + 1, dp[t - 1][w - 1][3 - k] + 1)
                else:
                    dp[t][w][k] = dp[t - 1][w][k] + 1
            else: # 자두를 못 먹는다.
                dp[t][w][k] = dp[t - 1][w][k]

ans = 0
for t in dp:
    for w in t:
        ans = max(ans, max(w))

sys.stdout.write(str(ans) + '\n')