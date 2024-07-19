import sys

# 로봇 청소기는 다음과 같이 작동한다.

# 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
# 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
#   1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
#   2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
# 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
#   1. 반시계 방향으로 90도 회전한다.
#   2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
#   3. 1번으로 돌아간다.

#   0
# 3   1
#   2
# 방향 전환: dir = (dir - 1) % 4

N, M = map(int, sys.stdin.readline().split())
r, c, d = map(int, sys.stdin.readline().split())
graph = []
for y in range (N):
    graph.append(list(map(int, sys.stdin.readline().split())))

def DFS(graph, x, y, d):
    dx = [0, 1, 0, -1]
    dy = [-1, 0, 1, 0]    
    cleans = 0

    while True:
        if graph[y][x] == 0: # 지금 있는 곳이 빈 칸이면, 청소한다.
            graph[y][x] = 2 
            cleans += 1

        isDirty = False          # 주변 먼지 검사
        for i in range (4):
            nx, ny = x + dx[i], y + dy[i]
            if graph[ny][nx] == 0:
                isDirty = True
                break

        if isDirty:
            for _ in range (4):        
                d = (d - 1) % 4     # 회전한다.
                nx = x + dx[d]
                ny = y + dy[d]
                
                if graph[ny][nx] == 0: # 그 쪽이 먼지로 가는 방향이면
                    x, y = nx, ny   # 이동한다.                    
                    break               
        else:
            nx = x - dx[d] # 후진방향
            ny = y - dy[d]

            if graph[ny][nx] == 1:
                return cleans       # 뒤에 벽이 있으면 그만한다.
            else:
                x, y = nx, ny       # 벽이 아니라면 후진한다.

sys.stdout.write(str(DFS(graph, r, c, d)) + '\n')

for row in graph:
    print(row)