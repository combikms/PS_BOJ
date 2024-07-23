import sys
import queue

def BFS(graph, visited, x, y):
    dx = [1, -1, 0, 0, 1, 1, -1, -1]
    dy = [0, 0, 1, -1, 1, -1, 1, -1]
    q = queue.Queue()

    visited[y][x] = True
    q.put([x, y])

    while not q.empty():
        cx, cy = q.get()
        for i in range (8):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < len(graph[0]) and 0 <= ny < len(graph):
                if graph[ny][nx] == 1 and not visited[ny][nx]:
                    visited[ny][nx] = True
                    q.put([nx, ny])

while True:   
    w, h = map(int, sys.stdin.readline().split())
    if w == 0 and h == 0: break
    graph = []
    for _ in range (h): graph.append(list(map(int, sys.stdin.readline().split())))
    visited = [ [False] * w for _ in range (h) ]    

    ans = 0
    for y in range (h):
        for x in range (w):
            if graph[y][x] == 1 and not visited[y][x]:
                ans += 1
                BFS(graph, visited, x, y)
    
    sys.stdout.write(str(ans) + '\n')