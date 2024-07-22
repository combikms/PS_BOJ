import sys

N = int(sys.stdin.readline())
parent = list(map(int, sys.stdin.readline().split()))

graph = [ [] for _ in range (N) ]
for child in range (N):
    if parent[child] != -1:
        graph[parent[child]].append(child)

root = 0
for i in range (len(parent)):
    if parent[i] == -1:
        root = i
        break

rm = int(sys.stdin.readline())
for i in range(len(graph[parent[rm]])):
    if graph[parent[rm]][i] == rm:
        graph[parent[rm]].pop(i)
        break

if rm == root:
    sys.stdout.write('0\n')
    exit(0)

def DFS(graph, root):
    visited = [False] * len(graph)
    stack = [root]
    leaf = 0    

    while stack:
        cur = stack.pop()
        if not visited[cur]:
            visited[cur] = True
            if graph[cur]:
                for neighbor in graph[cur]:                    
                    if not visited[neighbor]:
                        stack.append(neighbor)
            else:
                leaf += 1

    return leaf

sys.stdout.write(str(DFS(graph, root)) + '\n')