import sys
from copy import deepcopy
from itertools import combinations
from collections import deque

N, M = map(int, sys.stdin.readline().split())
graph = []
for _ in range (N): graph.append(list(map(int, sys.stdin.readline().split())))
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

blank_pos = []
for r in range (N):
    for c in range (M):
        if graph[r][c] == 0:
            blank_pos.append([r, c])

case = list(combinations(blank_pos, 3))
ans = 0
for c in case:
    temp = deepcopy(graph)
    visited = [ [False] * M for _ in range (N) ]
    for w in c: # 벽 설치        
        temp[w[0]][w[1]] = 1

    for r in range (N): # 바이러스 찾아서 BFS
        for c in range (M):
            if temp[r][c] == 2 and not visited[r][c]:
                q = deque([(r, c)])
                visited[r][c] = True
                while q:
                    cr, cc = q.popleft()
                    for d in range (4):
                        nr = cr + dr[d]
                        nc = cc + dc[d]
                        if 0 <= nr < N and 0 <= nc < M and not visited[nr][nc] and temp[nr][nc] == 0:
                            temp[nr][nc] = 2
                            visited[nr][nc] = True
                            q.append([nr, nc])
     
    s = 0
    for r in range (N): # 안전 영역의 크기
        for c in range (M):
            if temp[r][c] == 0:
                s += 1
    
    ans = max(ans, s)

sys.stdout.write(str(ans) + '\n')