# 반례:
# **********
# **********
# **********
# **********
# ##########
# ........@#
# ##########
# **********
# **********
# **********
# **********

import sys
import queue

def BFS(graph, x, y):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    visited = [ [-1 for _ in range(len(graph[0]))] for _ in range (len(graph))]

    visited[y][x] = 0
    q = queue.Queue()
    q.put([x, y])  
    
    while not q.empty():
        x, y = q.get()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= len(graph[0]) or ny >= len(graph):
                return visited[y][x] + 1

            if graph[ny][nx] == '.' or graph[ny][nx] == '@' or graph[ny][nx] == '*':
                if visited[ny][nx] == -1:
                    q.put([nx, ny])
                    visited[ny][nx] = visited[y][x] + 1
    
    return -1  # 건물이 막혀 있음

T = int(sys.stdin.readline())
for _ in range(T):
    w, h = map(int, sys.stdin.readline().split())
    graph = []
    fire_pos = []
    sang_pos = []
    for y in range(h):
        graph.append(list(map(str, sys.stdin.readline().strip())))
        for x in range (w):
            if graph[y][x] == '@':
                sang_pos = [x, y]
            elif graph[y][x] == '*':
                fire_pos.append([x, y])
        
    isBlocked = False
    min_fire = 2000000
    min_sang = 2000000

    # ~ 불의 모험 ~
    for pos in fire_pos:
        dist = BFS(graph, pos[0], pos[1])
        if dist == -1:
            isBlocked = True
        else:
            min_fire = min(min_fire, dist)

    # ~ 상근이의 모험 ~
    dist = BFS(graph, sang_pos[0], sang_pos[1])
    if dist == -1:
        isBlocked = True
    else:
        min_sang = min(min_sang, dist)
    
    if isBlocked:
        sys.stdout.write("IMPOSSIBLE\n")
    else:
        if min_sang < min_fire:
            sys.stdout.write(str(min_sang))
        else:
            sys.stdout.write("IMPOSSIBLE\n")