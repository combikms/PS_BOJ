import sys

board = []
for _ in range(9):
    board.append(list(map(int, sys.stdin.readline().strip())))


def is_valid(r, c, num):
    for i in range(9):
        if board[r][i] == num or board[i][c] == num:
            return False

    square_r = 3 * (r // 3)
    square_c = 3 * (c // 3)

    for i in range(square_r, square_r + 3):
        for j in range(square_c, square_c + 3):
            if board[i][j] == num:
                return False

    return True


def dfs():
    for r in range(9):
        for c in range(9):
            if board[r][c] == 0:
                for num in range(1, 10):
                    if is_valid(r, c, num):
                        board[r][c] = num
                        if dfs():
                            return True
                        board[r][c] = 0
                return False
    return True


if dfs():
    for row in board:
        sys.stdout.write("".join(map(str, row)) + "\n")
