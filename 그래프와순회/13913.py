import sys
from collections import deque

def BFS(start, dest):
    max = 100000
    cost = [-1] * (max + 1)
    prev = [-1] * (max + 1)
    queue = deque([start])
    cost[start] = 0
    prev[start] = None
    
    while queue:
        cur = queue.popleft()        
        for next in (cur - 1, cur + 1, cur * 2):
            if 0 <= next <= max and cost[next] == -1:
                cost[next] = cost[cur] + 1
                prev[next] = cur
                queue.append(next)
                if next == dest:
                    return cost[next], prev
    
    return -1, prev

def Makepath(dest, prev):
    path = []
    step = dest
    while step is not None:
        path.append(step)
        step = prev[step]
    path.reverse()
    return path


#################################################################


N, K = map(int, sys.stdin.readline().split())
if N == K: 
    sys.stdout.write("0" + "\n" + str(K))
    exit(0)
    
cost, prev = BFS(N, K)
path = Makepath(K, prev)
sys.stdout.write(str(cost) + "\n")
sys.stdout.write(' '.join(map(str, path)) + "\n")