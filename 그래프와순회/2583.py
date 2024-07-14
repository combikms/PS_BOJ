import sys
import queue

M, N, K = map(int, sys.stdin.readline().split())    # h, w, 직사각형 수
graph = [[0] * N for _ in range (M)]
for i in range (K):
    sx, sy, ex, ey = map(int, sys.stdin.readline().split())
    for y in range (sy, ey):
        for x in range (sx, ex):
            graph[y][x] = 1

visited = [[False] * N for _ in range (M)]

def BFS(graph, visited, x, y):    
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    visited[y][x] = True
    q = queue.Queue()
    q.put([x, y])
    surface = 1

    while not q.empty():
        x, y = q.get()
        for i in range (4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < len(graph[0]) and 0 <= ny < len(graph):
                if not visited[ny][nx] and graph[ny][nx] == 0:
                    visited[ny][nx] = True
                    q.put([nx, ny])
                    surface += 1
    
    return surface

components = 0
S = []
for y in range (M):
    for x in range (N):
        if not visited[y][x] and graph[y][x] == 0:
            components += 1
            S.append(BFS(graph, visited, x, y))
S.sort()
ans = ' '.join(str(s) for s in S)

sys.stdout.write(str(components) + "\n" + ans)