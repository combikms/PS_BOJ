import sys
import heapq

N = int(sys.stdin.readline())
task = []
for _ in range(N):
    num, start, end = map(int, sys.stdin.readline().split())
    task.append([start, end])
task.sort()

machine = [task[0][1]]
for i in range(1, N):
    earliest_end = heapq.heappop(machine)
    if earliest_end > task[i][0]:
        heapq.heappush(machine, earliest_end)
    heapq.heappush(machine, task[i][1])

sys.stdout.write(str(len(machine)) + "\n")
