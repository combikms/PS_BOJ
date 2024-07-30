import sys
from collections import deque

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]
graph = []
water_pos = []
hedge_pos = []

# 일단 물들에 대해 BFS를 다 돌림
# => 고슴도치는 물 이동경로의 최솟값보다 지 경로가 작아야만 이동이 가능하다는 조건으롤 탐색 ㄱㄱ

R, C = map(int, sys.stdin.readline().split())
for _ in range (R): graph.append(list(map(str, sys.stdin.readline().strip())))
water_dist = [ [10000] * C for _ in range (R) ]
for r in range(R):
    for c in range (C):
        if graph[r][c] == '*':
            water_pos.append([r, c])
        elif graph[r][c] == 'S':
            hedge_pos.extend([r, c])

def BFS_Water(r, c):
    q = deque([(r, c)])
    water_dist[r][c] = 0
    while q:
        cr, cc = q.popleft()
        for i in range (4):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if 0 <= nr < R and 0 <= nc < C:
                if graph[nr][nc] == '.':
                    if water_dist[nr][nc] > water_dist[cr][cc] + 1:
                        water_dist[nr][nc] = water_dist[cr][cc] + 1
                        q.append([nr, nc])

for r, c in water_pos: BFS_Water(r, c)

def BFS_Hedge():
    q = deque([(hedge_pos[0], hedge_pos[1])])
    hedge_dist = [ [-1] * C for _ in range (R) ]
    hedge_dist[hedge_pos[0]][hedge_pos[1]] = 0

    while q:
        cr, cc = q.popleft()
        for i in range (4):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if 0 <= nr < R and 0 <= nc < C:
                if graph[nr][nc] == '.':
                    if hedge_dist[nr][nc] == -1 and water_dist[nr][nc] > hedge_dist[cr][cc] + 1:
                        hedge_dist[nr][nc] = hedge_dist[cr][cc] + 1
                        q.append([nr, nc])
                elif graph[nr][nc] == 'D':
                    return str(hedge_dist[cr][cc] + 1) + '\n'
    
    return "KAKTUS\n"

sys.stdout.write(BFS_Hedge())