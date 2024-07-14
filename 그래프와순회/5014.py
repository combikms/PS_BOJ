import sys
import queue

F, S, G, U, D = map(int, sys.stdin.readline().split())
graph = [-1] * (F + 1) # graph[i]: i층까지 가는 최단 거리

graph[S] = 0
q = queue.Queue()
q.put(S)

dir = [U, -D]

while not q.empty():
    cur = q.get()
    for i in dir:
        next = cur + i
        if 0 < next <= F and graph[next] == -1:
            graph[next] = graph[cur] + 1
            q.put(next)

ans = str(graph[G]) if graph[G] != -1 else "use the stairs"
sys.stdout.write(ans)