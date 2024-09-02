import sys
from collections import deque

N, M, K = map(int, sys.stdin.readline().split())
board = []
for _ in range(N):
    board.append(list(map(int, sys.stdin.readline().split())))

r, c, d = 0, 0, 0
dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]  # 동, 남, 서, 북 (clockwise)
dice = [1, 2, 3, 4, 5, 6]  # 위, 북, 동, 서, 남, 바닥


def mvDice():
    global r, c, d, dice
    if not (0 <= r + dr[d] < N and 0 <= c + dc[d] < M):
        d = (d + 2) % 4

    if d == 0:
        dice = [dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]]
    elif d == 1:
        dice = [dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]]
    elif d == 2:
        dice = [dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]]
    else:
        dice = [dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]]

    r += dr[d]
    c += dc[d]


def getScore():  # BFS
    visited = [[False] * M for _ in range(N)]
    visited[r][c] = True
    num = board[r][c]
    count = 1
    q = deque([(r, c)])

    while q:
        cr, cc = q.popleft()
        for i in range(4):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if 0 <= nr < N and 0 <= nc < M:
                if not visited[nr][nc] and board[nr][nc] == num:
                    count += 1
                    visited[nr][nc] = True
                    q.append([nr, nc])

    return num * count


def chDir():
    global r, c, d, dice
    A, B = dice[5], board[r][c]
    if A > B:
        d = (d + 1) % 4
    elif A < B:
        d = (d - 1) % 4


ans = 0
for _ in range(K):
    mvDice()
    ans += getScore()
    chDir()

print(ans)
