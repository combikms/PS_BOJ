import sys
import heapq

def Dijkstra(graph, start):    
    D = {node: float('inf') for node in graph}
    D[start] = 0
    pq = [(0, start)]

    while pq:
        cur_cost, cur_v = heapq.heappop(pq)   # 이동하기
                
        # 이미 최단 경로가 계산된 것은 스킵
        if cur_cost > D[cur_v]:
            continue

        for neighbor, w in graph[cur_v].items():
            next_cost = cur_cost + w

            if next_cost < D[neighbor]:
                D[neighbor] = next_cost
                heapq.heappush(pq, (next_cost, neighbor))

    return D

N, M, X = map(int,sys.stdin.readline().split())
graph = {i: {} for i in range(1, N + 1)}

for _ in range(M):
    start, end, t = map(int, sys.stdin.readline().split())
    graph[start][end] = t

friends_to_x = [0] * (N + 1)
x_to_friends = Dijkstra(graph, X)

for i in range(1, N + 1):
    temp = Dijkstra(graph, i)
    friends_to_x[i] = temp[X]

max_cost = 0
for i in range(1, N + 1):
    if i != X:
        max_cost = max(max_cost, friends_to_x[i] + x_to_friends[i])

sys.stdout.write(str(max_cost))