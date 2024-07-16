import sys
import queue

def BFS(graph, x, y, z):
    dx = [1, -1, 0, 0, 0, 0]
    dy = [0, 0, 1, -1, 0, 0]
    dz = [0, 0, 0, 0, 1, -1]

    q = queue.Queue()   
    graph[z][y][x] = 0
    q.put([x, y, z])

    while not q.empty():
        cx, cy, cz = q.get()
        for i in range(6):
            nx = cx + dx[i]
            ny = cy + dy[i]
            nz = cz + dz[i]

            if 0 <= nx < len(graph[0][0]) and 0 <= ny < len(graph[0]) and 0 <= nz < len(graph):
                if graph[nz][ny][nx] == 'E':
                    return graph[cz][cy][cx] + 1
                
                if graph[nz][ny][nx] == '.':
                    graph[nz][ny][nx] = graph[cz][cy][cx] + 1
                    q.put([nx, ny, nz])

    return -1

while True:
    L, R, C = map(int, sys.stdin.readline().split())
    if L == 0 and R == 0 and C == 0: break

    graph = []
    for _ in range (L):
        floor = []
        for _ in range (R):
            floor.append(list(map(str, sys.stdin.readline().strip())))            
        graph.append(floor)
        sys.stdin.readline()    
    
    for z in range (L):
        for y in range (R):
            for x in range (C):
                if graph[z][y][x] == 'S':
                    ans = BFS(graph, x, y, z)               
    
    if ans == -1:
        sys.stdout.write("Trapped!\n")
    else:
        sys.stdout.write(f"Escaped in {ans} minute(s).\n")
