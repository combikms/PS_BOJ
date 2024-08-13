import sys
from collections import deque
from itertools import combinations
from copy import deepcopy

N, M, D = map(int, sys.stdin.readline().split())
graph = deque([])
for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().split())))


def mvEnemy(board):
    board.appendleft([0] * M)
    board.pop()


def isOver(board):
    for r in range(N):
        for c in range(M):
            if board[r][c] != 0:
                return False
    return True


dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]


def bfs(board, ac):
    if board[N - 1][ac] == 1:
        return [N - 1, ac]

    dist = [[-1] * M for _ in range(N)]
    dist[N - 1][ac] = 1
    q = deque([(N - 1, ac)])

    t_pos = []
    t_dist = 5000

    while q:
        cr, cc = q.popleft()
        for i in range(4):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if 0 <= nr < N and 0 <= nc < M and dist[nr][nc] == -1:
                if dist[cr][cc] + 1 <= D:
                    if board[nr][nc] == 1:
                        if dist[cr][cc] + 1 < t_dist:
                            t_pos = [nr, nc]
                            t_dist = dist[cr][cc] + 1
                        elif dist[cr][cc] + 1 == t_dist and nc < t_pos[1]:
                            t_pos = [nr, nc]
                    dist[nr][nc] = dist[cr][cc] + 1
                    q.append([nr, nc])

    return t_pos

ans = 0
case = list(combinations([i for i in range(M)], 3))
for c in case:
    board = deepcopy(graph)
    killed = 0
    while not isOver(board):        
        e1, e2, e3 = bfs(board, c[0]), bfs(board, c[1]), bfs(board, c[2])
        for t in (e1, e2, e3):
            if t and board[t[0]][t[1]] == 1:
                board[t[0]][t[1]] = 0
                killed += 1        
        mvEnemy(board)
    ans = max(ans, killed)

print(ans)
