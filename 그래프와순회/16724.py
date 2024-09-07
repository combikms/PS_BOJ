import sys

N, M = map(int, sys.stdin.readline().split())
graph = []
for _ in range(N):
    graph.append(list(map(str, sys.stdin.readline().strip())))

id = [[-1] * M for _ in range(N)]
visitedId = set()


def tour(r, c, idNum):
    id[r][c] = idNum
    cr, cc = r, c
    while True:
        ndir = graph[cr][cc]
        nr, nc = cr, cc
        if ndir == "U":
            nr += -1
        elif ndir == "D":
            nr += 1
        elif ndir == "L":
            nc += -1
        elif ndir == "R":
            nc += 1

        if id[nr][nc] == -1:
            id[nr][nc] = idNum
            cr, cc = nr, nc
        else:
            if id[nr][nc] in visitedId:
                visitedId.add(idNum)
                return 0
            else:
                visitedId.add(idNum)
                return 1


ans = 0
idNum = 0
for r in range(N):
    for c in range(M):
        if id[r][c] == -1:
            ans += tour(r, c, idNum)
            idNum += 1

print(ans)
