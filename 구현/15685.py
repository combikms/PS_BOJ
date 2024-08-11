import sys

N = int(sys.stdin.readline())
curve = []
for _ in range(N):
    curve.append(list(map(int, sys.stdin.readline().split())))

# 평면벡터의 성분만 기록해다가 연장시키면 될 것 같다.
# 90도 돌리는 방법은?
# 1. 거꾸로 읽는데, x방향 성분은 -를 붙인다. 즉,
# 2. (0, y)는 (y, 0)으로, (x, 0)은 (0, -x)로 읽는다.

# ex)
# 0세대: (1, 0)
# 1세대: (1, 0), (0, -1)
# 2세대: (1, 0), (0, -1), (-1, 0), (0, -1)
# 3세대: (1, 0), (0, -1), (-1, 0), (0, -1), (-1, 0), (0, 1), (-1, 0), (0, -1)

sdir = [[1, 0], [0, -1], [-1, 0], [0, 1]]
graph = [[False] * 110 for _ in range(110)]


def incGen(c):
    temp = []
    for i in range(len(c) - 1, -1, -1):
        temp.append([c[i][1], -c[i][0]])
    c.extend(temp)


def draw(i):
    c = []
    c.append(sdir[curve[i][2]])

    for _ in range(curve[i][3]):
        incGen(c)

    cx, cy = curve[i][0], curve[i][1]
    graph[cy][cx] = True
    for next in c:
        cx += next[0]
        cy += next[1]
        graph[cy][cx] = True


for i in range(N):
    draw(i)


def count():
    rects = 0
    for r in range(1, len(graph)):
        for c in range(1, len(graph[0])):
            if (
                graph[r - 1][c]
                and graph[r - 1][c - 1]
                and graph[r][c - 1]
                and graph[r][c]
            ):
                rects += 1
    return rects


print(count())
