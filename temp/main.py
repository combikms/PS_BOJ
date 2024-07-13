import sys

T, W = map(int, sys.stdin.readline().split())
drop = []
for _ in range (T):
    drop.append(int(sys.stdin.readline()))

# dp[t][w][p] = 시점 t에 이동을 w번 했고, 위치는 p인 상황에서 받아먹은 최대 자두 수
dp = [[[0] * (W + 1) for _ in range(3)] for _ in range(T + 1)]
for t in range (1, T + 1):
    for w in range (W + 1):
        for p in range (1, 3):
            dp[t][w][p] = dp[t - 1][w][p] + (1 if drop[t - 1] == p else 0) # 그대로 있기

            if w > 0:
                other = 2 if p == 1 else 1 # 다른 쪽 나무 번호
                dp[t][w][p] = max(dp[t][w][p], dp[t - 1][w - 1][other] + (1 if drop[t - 1] == p else 0))
