import queue
import sys

N, M = map(int, sys.stdin.readline().split())
graph = {i: [] for i in range(1, N + 1)}

for i in range (M):
    start, end = map(int, sys.stdin.readline().split())
    graph[start].append(end)
    graph[end].append(start)

def BFS(graph, visited, start):    
    visited[start] = True
    q = queue.Queue()
    q.put(start)

    while not q.empty():
        cur = q.get()        
        for neighbor in graph[cur]:
            if not visited[neighbor]:
                visited[neighbor] = True                
                q.put(neighbor)

visited = [False] * (N + 1)
count = 0
for i in range (1, N + 1):
    if not visited[i]:
        BFS(graph, visited, i)
        count += 1

sys.stdout.write(str(count))