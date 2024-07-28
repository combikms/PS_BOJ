import sys
from collections import deque

N, L, R = map(int, sys.stdin.readline().split())
graph = []
for _ in range (N): graph.append(list(map(int, sys.stdin.readline().split())))
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

def BFS(r, c):    
    union = [[r, c]]
    q = deque([(r, c)])
    visited[r][c] = True
    sum_population = graph[r][c]
    result = 0

    while q:
        cr, cc = q.popleft()
        for i in range (4):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if 0 <= nr < N and 0 <= nc < N:
                if not visited[nr][nc] and L <= abs(graph[nr][nc] - graph[cr][cc]) <= R:
                    result = 1
                    visited[nr][nc] = True
                    sum_population += graph[nr][nc]
                    union.append([nr, nc])
                    q.append([nr, nc])
    
    population_per_region = sum_population // len(union)
    for pos in union: graph[pos[0]][pos[1]] = population_per_region

    return result

days = 0
while True:    
    visited = [ [False] * N for _ in range (N) ]
    isChanged = False
    for r in range (N):
        for c in range (N):
            if not visited[r][c]:
                result = BFS(r, c)
                if result == 1: isChanged = True
    
    if not isChanged: break
    days += 1

sys.stdout.write(str(days) + '\n')