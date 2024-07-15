import sys
import queue

N = int(sys.stdin.readline())
graph = []
for _ in range (N):
    graph.append(list(map(int, sys.stdin.readline().split())))

max_rain = max(max(row) for row in graph)

def BFS(graph, visited, x, y, rain):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    visited[y][x] = True
    q = queue.Queue()
    q.put([x, y])

    while not q.empty():
        x, y = q.get()
        for i in range (4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < len(graph[0]) and 0 <= ny < len(graph):
                if not visited[ny][nx] and graph[ny][nx] > rain:
                    visited[ny][nx] = True
                    q.put([nx, ny])

max_components = 1
for rain in range(1, max_rain):    

    visited = [ [False] * N for _ in range (N) ]
    components = 0

    for y in range (N):
        for x in range (N):
            if not visited[y][x] and graph[y][x] > rain:                
                BFS(graph, visited, x, y, rain)
                components += 1
    
    max_components = max(max_components, components)

sys.stdout.write(str(max_components))