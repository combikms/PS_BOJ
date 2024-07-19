import sys

N, M = map(int, sys.stdin.readline().split())
r, c, d = map(int, sys.stdin.readline().split())
graph = []
for y in range (N):
    graph.append(list(map(int, sys.stdin.readline().split())))

def DFS(graph, r, c, d):
    dr = [-1, 0, 1, 0]    
    dc = [0, 1, 0, -1]    
    cleans = 0

    while True:
        if graph[r][c] == 0: # 청소하지 않은 빈 칸인 경우 청소
            graph[r][c] = 2
            cleans += 1

        cleaned = False
        for _ in range(4):
            d = (d - 1) % 4
            nr, nc = r + dr[d], c + dc[d]
            if graph[nr][nc] == 0: # 청소 가능한 칸이 있는 경우 전진
                r, c = nr, nc
                cleaned = True
                break

        if not cleaned: # 4방향 모두 청소할 곳이 없는 경우
            nr, nc = r - dr[d], c - dc[d]
            if graph[nr][nc] == 1: # 후진하려는 칸이 벽인 경우 작동 중지
                return cleans
            else:
                r, c = nr, nc  # 후진 가능한 경우 후진

sys.stdout.write(str(DFS(graph, r, c, d)) + '\n')