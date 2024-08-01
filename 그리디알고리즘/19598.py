import sys
import heapq

N = int(sys.stdin.readline())
task = []
for _ in range(N):
    task.append(list(map(int, sys.stdin.readline().split())))
task.sort()

machine = [task[0][1]]  # 가장 빨리 끝나는 놈부터 저장

for i in range(1, N):
    earliest = heapq.heappop(machine)
    if task[i][0] < earliest:
        heapq.heappush(machine, earliest)
    heapq.heappush(machine, task[i][1])

sys.stdout.write(str(len(machine)) + "\n")
