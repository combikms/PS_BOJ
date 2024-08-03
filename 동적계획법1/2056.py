import sys

# dp[i]: i번 작업의 끝나는 시각 (선행 과정까지 다 고려해서)
# 1번 작업은 우선 그냥 배치한다
# n번 작업의 선행 작업들 중, 가장 늦게 끝나는 애가 끝나는 직후에다가 n번 작업을 배치한다.
# 선행 작업이 없으면 그냥 처음부터 해버린다.

N = int(sys.stdin.readline())
task = [[0, []]]
for _ in range(N):
    task_input = list(map(int, sys.stdin.readline().split()))
    task.append([task_input[0], task_input[2:]])

dp = [0] * (N + 1)
for i in range(1, N + 1):
    latest = 0
    for t in task[i][1]:
        latest = max(latest, dp[t])
    dp[i] = latest + task[i][0]

sys.stdout.write(str(max(dp)) + '\n')