import sys
import queue

n = int(sys.stdin.readline())
a, b = map(int, sys.stdin.readline().split())

m = int(sys.stdin.readline())
graph = {i: [] for i in range(1, n + 1)}
for i in range(m):
    parent, child = map(int, sys.stdin.readline().split())
    graph[parent].append(child)
    graph[child].append(parent)

chon = [-1] * (n + 1)
def BFS(graph, chon, start):
    chon[start] = 0
    q = queue.Queue()
    q.put(start)
    
    while not q.empty():
        cur = q.get()
        for neighbor in graph[cur]:
            if chon[neighbor] == -1:
                chon[neighbor] = chon[cur] + 1
                q.put(neighbor)

BFS(graph, chon, a)
sys.stdout.write(str(chon[b]))