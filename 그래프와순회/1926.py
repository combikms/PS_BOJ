import sys
import queue

n, m = map(int, sys.stdin.readline().split()) # 세로, 가로
paper = []
for i in range(n):
    paper.append(list(map(int, sys.stdin.readline().split())))
visited = [[False for _ in range(m)] for _ in range (n)]

def BFS(paper, visited, x, y):      
    dx = [1, -1, 0, 0]    
    dy = [0, 0, 1, -1]    

    visited[y][x] = True
    surface = 1
    q = queue.Queue()
    q.put([x,y])

    while not q.empty():
        x, y = q.get()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= len(paper[0]) or ny >= len(paper): # 이동 못 함
                continue            
            
            if paper[ny][nx] == 1 and not visited[ny][nx]:
                visited[ny][nx] = True
                surface += 1
                q.put([nx, ny])
    
    return surface

components = 0
max_surface = 0
for y in range(n):
    for x in range(m):
        if paper[y][x] == 1 and not visited[y][x]:
            components += 1
            max_surface = max(max_surface, BFS(paper, visited, x, y))

sys.stdout.write(str(components) + "\n" + str(max_surface))