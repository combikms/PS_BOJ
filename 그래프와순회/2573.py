import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
graph = []
for _ in range (N):
    graph.append(list(map(int,sys.stdin.readline().split())))

def BFS(graph, visited, x, y, t):    
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    visited[y][x] = t
    q = deque([(x, y)])

    while q:
        cx, cy = q.popleft()        
        for i in range (4):
            nx = cx + dx[i]
            ny = cy + dy[i]          

            if 0 <= nx < len(graph[0]) and 0 <= ny < len(graph):
                if visited[ny][nx] != t:
                    if graph[ny][nx] > 0: # 육지니까 다음에 방문할 준비
                        visited[ny][nx] = t
                        q.append([nx, ny])
                    else: # 바다니까 녹이기
                        if graph[cy][cx] > 0:
                            graph[cy][cx] -= 1

ans = 0
visited = [ [-1] * M for _ in range (N) ] # 90,000
while True: # 최대 10번 => 1,800,000
    # 섬 개수 체크 (90,000)
    components = 0        
    for y in range (N): 
        for x in range (M):
            if graph[y][x] > 0:
                if visited[y][x] != ans:
                    components += 1
                    if components == 2:
                        break                    
                    BFS(graph, visited, x, y, ans)
        if components == 2:
            break

    if components == 2:
        break

    if components == 0:
        ans = 0
        break
    
    ans += 1

sys.stdout.write(str(ans) + '\n')