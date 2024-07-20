import sys
import queue

N, M = map(int, sys.stdin.readline().split())
graph = [ [] for _ in range (N + 1)]
for _ in range (M):
    temp = list(map(int, sys.stdin.readline().split()))
    graph[temp[0]].append(temp[1])
    graph[temp[1]].append(temp[0])

def BFS(graph, start):
    q = queue.Queue()
    kevin = [-1] * (len(graph))
    kevin[0] = 0

    kevin[start] = 0
    q.put(start)

    while not q.empty():
        cur = q.get()
        for neighbor in graph[cur]:
            if kevin[neighbor] == -1:
                kevin[neighbor] = kevin[cur] + 1
                q.put(neighbor)
    
    return sum(kevin)

ans = 1
min_kevin = BFS(graph, 1)

for i in range (2, N + 1):
    kev = BFS(graph, i)
    if kev < min_kevin:
        ans = i
        min_kevin = kev

sys.stdout.write(str(ans) + '\n')