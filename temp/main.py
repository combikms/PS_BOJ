import sys
import queue

N, M = map(int, sys.stdin.readline().split())
graph = []
for _ in range (N):
    graph.append(list(map(int,sys.stdin.readline().split())))

# 그래프 최대 크기: 90,000
# 각 높이들의 최대치: 10 => 순회 많이 해도 될 듯

# 바다 BFS 과정에서 빙산을 좀 녹이고 본다.
# 바다 BFS 끝나고 나면 Connected Component 수 체크 => 2 이상이면 흐른 시간 출력 및 종료

def BFS_Ocean(graph, visited, x, y): # 일단은 바다용으로 생각
    q = queue.Queue()    
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    visited[y][x] = True
    q.put([x, y])

    while not q.empty():
        cx, cy = q.get()
        for i in range (4):
            nx = cx + dx[i]
            ny = cy + dy[i]

            if 0 <= nx < len(graph[0]) and 0 <= ny < len(graph):
                if graph[ny][nx] != 0: # 지나가던 길에 육지가 있으면 녹인다
                    visited[ny][nx] = True
                    graph[ny][nx] -= 1
                else: # 바다면 방문한다.
                    if not visited[ny][nx]:
                        visited[ny][nx] = True
                        q.put([nx, ny])

def BFS_Island(graph, visited, x, y):
    q = queue.Queue()
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    visited[y][x] = True
    q.put([x, y])

    while not q.empty():
        cx, cy = q.get()
        for i in range (4):
            nx = cx + dx[i]
            ny = cy + dy[i]

            if 0 <= nx < len(graph[0]) and 0 <= ny < len(graph):
                if not visited[ny][nx] and graph[ny][nx] != 0:
                    visited[ny][nx] = True
                    q.put([nx, ny])

ans = 0
while True: # 최대 10번
    # 섬 개수 체크 O(810,000)
    components = 0    
    visited_island = [ [False] * len(graph[0]) for _ in range (len(graph)) ]
    for y in range (N): 
        for x in range (M):
            if graph[y][x] != 0:
                if not visited_island[y][x]:
                    BFS_Island(graph, visited_island, x, y)                    
                    components += 1
        
    if components >= 2:
        break
    elif components == 0:
        ans = 0
        break

    # 녹이기 O(810,000)
    visited_ocean = [ [False] * len(graph[0]) for _ in range (len(graph)) ]
    for y in range (N): 
        for x in range (M):            
            if graph[y][x] == 0:
                if not visited_ocean[y][x]:
                    BFS_Ocean(graph, visited_ocean, x, y)
        
    ans += 1    

sys.stdout.write(str(ans) + '\n')