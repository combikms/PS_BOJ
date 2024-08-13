import sys

N, K = map(int, sys.stdin.readline().split())
task = []
for _ in range(N):
    start, end = map(int, sys.stdin.readline().split())
    task.append([end, start])
task.sort()

machine = [0] * K
ans = 0
for t in task:
    for i in range(K - 1, -1, -1):
        if machine[i] < t[1]:
            ans += 1
            machine[i] = t[0]
            machine.sort()
            break    

print(ans)
