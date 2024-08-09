import sys

R, C = map(int, sys.stdin.readline().split())
graph = []
for _ in range(R):
    graph.append(list(map(int, sys.stdin.readline().split())))

cctv = []
for r in range(R):
    for c in range(C):
        if 1 <= graph[r][c] <= 5:
            cctv.append([graph[r][c], r, c, 0])

visible = [[False] * C for _ in range(R)]
ans = float("inf")

# 1: ↑ → ↓ ←
# 2: ↔ ↕
# 3: ㄴ r ㄱ J
# 4: (안 보는 방향이) ↓ ← ↑ →


def view_onedir(i, d, v):
    if d == "UP":
        for r in range(cctv[i][1] - 1, -1, -1):
            if graph[r][cctv[i][2]] == 6:
                break
            visible[r][cctv[i][2]] = v
    elif d == "DOWN":
        for r in range(cctv[i][1] + 1, R):
            if graph[r][cctv[i][2]] == 6:
                break
            visible[r][cctv[i][2]] = v
    elif d == "RIGHT":
        for c in range(cctv[i][2] + 1, C):
            if graph[cctv[i][1]][c] == 6:
                break
            visible[cctv[i][1]][c] = v
    elif d == "LEFT":
        for c in range(cctv[i][2] - 1, -1, -1):
            if graph[cctv[i][1]][c] == 6:
                break
            visible[cctv[i][1]][c] = v


def view_all(i, v):
    if cctv[i][0] == 1:
        if cctv[i][3] == 0:
            view_onedir(i, "UP", v)
        elif cctv[i][3] == 1:
            view_onedir(i, "RIGHT", v)
        elif cctv[i][3] == 2:
            view_onedir(i, "DOWN", v)
        elif cctv[i][3] == 3:
            view_onedir(i, "LEFT", v)

    elif cctv[i][0] == 2:
        if cctv[i][3] == 0:
            view_onedir(i, "LEFT", v)
            view_onedir(i, "RIGHT", v)
        elif cctv[i][3] == 1:
            view_onedir(i, "UP", v)
            view_onedir(i, "DOWN", v)

    elif cctv[i][0] == 3:
        if cctv[i][3] == 0:
            view_onedir(i, "UP", v)
            view_onedir(i, "RIGHT", v)
        elif cctv[i][3] == 1:
            view_onedir(i, "RIGHT", v)
            view_onedir(i, "DOWN", v)
        elif cctv[i][3] == 2:
            view_onedir(i, "DOWN", v)
            view_onedir(i, "LEFT", v)
        elif cctv[i][3] == 3:
            view_onedir(i, "LEFT", v)
            view_onedir(i, "UP", v)

    elif cctv[i][0] == 4:
        if cctv[i][3] == 0:
            view_onedir(i, "LEFT", v)
            view_onedir(i, "UP", v)
            view_onedir(i, "RIGHT", v)
        elif cctv[i][3] == 1:
            view_onedir(i, "UP", v)
            view_onedir(i, "RIGHT", v)
            view_onedir(i, "DOWN", v)
        elif cctv[i][3] == 2:
            view_onedir(i, "LEFT", v)
            view_onedir(i, "DOWN", v)
            view_onedir(i, "RIGHT", v)
        elif cctv[i][3] == 3:
            view_onedir(i, "DOWN", v)
            view_onedir(i, "LEFT", v)
            view_onedir(i, "UP", v)

    elif cctv[i][0] == 5:
        view_onedir(i, "RIGHT", v)
        view_onedir(i, "DOWN", v)
        view_onedir(i, "LEFT", v)
        view_onedir(i, "UP", v)


def count():
    invisible = 0
    for r in range(R):
        for c in range(C):
            if not visible[r][c] and graph[r][c] == 0:
                invisible += 1
    return invisible


def watch(i):
    global ans, visible
    if i < len(cctv) - 1:
        dir = []
        if cctv[i + 1][0] == 2:
            dir = [0, 1]
        elif cctv[i + 1][0] == 5:
            dir = [0]
        else:
            dir = [0, 1, 2, 3]

        for d in dir:
            cctv[i + 1][3] = dir[d]
            watch(i + 1)
    else:
        for i in range(len(cctv)):
            view_all(i, True)

        ans = min(ans, count())
        visible = [[False] * C for _ in range(R)]


watch(-1)
print(ans)
