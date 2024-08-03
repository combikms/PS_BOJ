import sys
from collections import deque

# 하나씩 BFS 돌려서 방문 노드 4개 이상이면 다 터뜨리고 ans++. ('.'으로 바꿈)
# 공중에 떠있는 것들 떨어뜨린다.
# => BFS 아무것도 못 할 때까지 반복

graph = []
for _ in range(12):
    graph.append(list(map(str, sys.stdin.readline().strip())))

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]


def BFS(r, c, color):
    visited = [[False] * 6 for _ in range(12)]
    visited[r][c] = True
    q = deque([(r, c)])
    blocks = [[r, c]]
    while q:
        cr, cc = q.popleft()
        for i in range(4):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if 0 <= nr < 12 and 0 <= nc < 6:
                if graph[nr][nc] == color and not visited[nr][nc]:
                    visited[nr][nc] = True
                    q.append([nr, nc])
                    blocks.append([nr, nc])

    if len(blocks) >= 4:
        for b in blocks:
            graph[b[0]][b[1]] = "."
        return 1

    return 0


ans = 0
while True:
    isPopped = False
    for r in range(12):
        for c in range(6):
            if graph[r][c] != ".":
                if BFS(r, c, graph[r][c]) == 1:
                    isPopped = True

    if not isPopped:
        break
    else:
        ans += 1
        for c in range(6):
            cur_col = [graph[i][c] for i in range(12)]
            dropped = []
            for b in cur_col:
                if b != ".":
                    dropped.append(b)
            result = ["."] * (12 - len(dropped))
            result.extend(dropped)
            for i in range(12):
                graph[i][c] = result[i]

print(ans)
