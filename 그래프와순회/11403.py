import sys

# DFS 복잡도 200, 행렬 크기 100 * 100 = 10,000
# 일일이 다 DFS 돌리면 2,000,000  => 가능

N = int(sys.stdin.readline())
adj = []
for _ in range (N): adj.append(list(map(int, sys.stdin.readline().split())))

graph = [ [] for _ in range (N) ]
for R in range (N):
    for C in range (N):
        if adj[R][C] == 1:
            graph[R].append(C)            

def DFS(graph, start, end):
    visited = [False] * len(graph)
    stack = [start]

    while stack:
        cur = stack.pop()
        if not visited[cur]:
            visited[cur] = True
            for neighbor in graph[cur]:
                if neighbor == end:
                    return 1
                if not visited[neighbor]:
                    stack.append(neighbor)
    
    return 0

ans = [[0] * N for _ in range (N) ]
for R in range (N):
    for C in range (N):
        ans[R][C] = DFS(graph, R, C)
        sys.stdout.write(f"{ans[R][C]} ")
    sys.stdout.write('\n')