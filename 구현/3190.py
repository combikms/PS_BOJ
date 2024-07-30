import sys
from collections import deque

N = int(sys.stdin.readline())
K = int(sys.stdin.readline())
apple = []
for _ in range (K): apple.append(list(map(int, sys.stdin.readline().split())))
L = int(sys.stdin.readline())
action = deque([])
for _ in range (L): action.append(list(map(str, sys.stdin.readline().split())))

board = [ [0] * N for _ in range (N) ]
for pos in apple: board[pos[0] - 1][pos[1] - 1] = 2
snake = deque([(0, 0)])
board[0][0] = 1

dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]

t = 0
d = 0
next_time, next_action = action.popleft()

while True:
    nr = snake[-1][0] + dr[d]
    nc = snake[-1][1] + dc[d]

    if not (0 <= nr < N and 0 <= nc < N) or board[nr][nc] == 1: break  # Game Over
    else:  # 이동하기
        if board[nr][nc] != 2:
            tail = snake.popleft()
            board[tail[0]][tail[1]] = 0
        snake.append([nr, nc])
        board[nr][nc] = 1

    t += 1

    if int(next_time) == t:
        d = (d + 1) % 4 if next_action == 'D' else (d - 1) % 4
        if action: next_time, next_action = action.popleft()

sys.stdout.write(str(t + 1) + '\n')