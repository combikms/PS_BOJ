import sys
import copy
import queue

# 먼저 불부터 BFS 다 돌린다.
# 그 다음에 사람 기준 BFS 돌린다.
# => 그 과정에서 가장 빠른 탈출구가 나타날 시 거기를 불이랑 비교해본다.
# => 불보다 빠르면 성공, 불이 더 빠르면 실패

# 불이랑 상근이랑 다른 그래프 써야 할 것 같다

def BFS(graph, x, y, isFire):
    q = queue.Queue()
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    visited = [ [False] * len(graph[0]) for _ in range (len(graph)) ]

    visited[y][x] = True
    graph[y][x] = 0
    q.put([x, y])    

    while not q.empty():
        cx, cy = q.get()
        for i in range (4):
            nx = cx + dx[i]
            ny = cy + dy[i]

            if 0 <= nx < len(graph[0]) and 0 <= ny < len(graph):
                if isFire:
                    if graph[ny][nx] != '#' and graph[ny][nx] != '*' and not visited[ny][nx]:
                        if graph[ny][nx] == '.' or graph[ny][nx] == '@':
                            graph[ny][nx] = graph[cy][cx] + 1     
                        else:                        
                            graph[ny][nx] = min(graph[ny][nx], graph[cy][cx] + 1)

                        visited[ny][nx] = True
                        q.put([nx, ny])
                else:
                    if graph[ny][nx] == '.':
                        graph[ny][nx] = graph[cy][cx] + 1
                        visited[ny][nx] = True
                        q.put([nx, ny])
            else:
                if not isFire: # 상근이가 탈출구 발견함
                    return cx, cy
    
    return -1, -1

                

T = int(sys.stdin.readline())
for _ in range (T):
    w, h = map(int, sys.stdin.readline().split())
    fire_graph = []
    for _ in range (h):
        fire_graph.append(list(map(str, sys.stdin.readline().strip())))
    sang_graph = copy.deepcopy(fire_graph)
    
    fire_pos = []
    sang_pos = []

    for y in range (h):
        for x in range (w):
            if fire_graph[y][x] == '*':
                fire_pos.append([x, y])
            elif fire_graph[y][x] == '@':
                sang_pos.extend([x, y])
    
    for f in fire_pos:
        BFS(fire_graph, f[0], f[1], True)
        
    ex, ey = BFS(sang_graph, sang_pos[0], sang_pos[1], False)

    if ex == -1:
        sys.stdout.write("IMPOSSIBLE\n")
    else:
        if not isinstance(fire_graph[ey][ex], (int, float)):
            sys.stdout.write(str(sang_graph[ey][ex] + 1) + '\n')
        elif sang_graph[ey][ex] < fire_graph[ey][ex]:
            sys.stdout.write(str(sang_graph[ey][ex] + 1) + '\n')
        else:
            sys.stdout.write("IMPOSSIBLE\n")