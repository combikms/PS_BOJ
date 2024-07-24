import sys
from collections import deque

R, C = map(int, sys.stdin.readline().split())
graph = []
for _ in range(R):
    graph.append(list(map(str, sys.stdin.readline().strip())))

dist = [[-1] * C for _ in range (R)]

def BFS(x, y):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    dist[y][x] = 0           
    q = deque([(x, y)])

    max_dist = 0
    
    while q:
        cx, cy = q.popleft()
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < len(graph[0]) and 0 <= ny < len(graph):
                if graph[ny][nx] == 'L' and dist[ny][nx] == -1:
                    dist[ny][nx] = dist[cy][cx] + 1
                    max_dist = max(max_dist, dist[ny][nx])
                    q.append([nx, ny])

    return max_dist

ans = 0
for y in range(R):
    for x in range(C):
        if graph[y][x] == 'L':
            ans = max(ans, BFS(x, y))
            dist = [[-1] * C for _ in range (R)]

sys.stdout.write(str(ans) + '\n')