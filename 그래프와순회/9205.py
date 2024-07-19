import sys

def DFS(graph):
    visited = [False] * len(graph)
    stack = [0]

    while stack:
        cur = stack.pop()
        if not visited[cur]:
            visited[cur] = True
            for i in range (len(graph)):
                if not visited[i]:
                    dist = abs(graph[i][0] - graph[cur][0]) + abs(graph[i][1] - graph[cur][1])
                    if dist <= 1000:
                        if i == len(graph) - 1:
                            return "happy"
                        else:
                            stack.append(i)
    
    return "sad"

T = int(sys.stdin.readline())
for _ in range (T):
    N = int(sys.stdin.readline())
    graph = []
    graph.append(list(map(int, sys.stdin.readline().split()))) # 집 추가    
    for _ in range (N):
        graph.append(list(map(int, sys.stdin.readline().split()))) # 편의점 추가
    graph.append(list(map(int, sys.stdin.readline().split()))) # 목적지 추가

    sys.stdout.write(DFS(graph) + '\n')