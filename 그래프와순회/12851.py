import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())

if N == K:
    sys.stdout.write('0\n1\n')
    sys.exit()

dist = [-1] * (300000)
dist[N] = 0
q = deque([N])

while q:
    cur = q.popleft()    
    for next in (cur - 1, cur + 1, 2 * cur):        
        if 0 <= next < (300000) and dist[next] == -1:
                dist[next] = dist[cur] + 1                
                q.append(next)

t = dist[K]
m = 0

q.append(K)
while q:
    cur = q.popleft()
    prev = [cur - 1, cur + 1]
    if cur % 2 == 0 and cur != 0: prev.append(cur // 2)
    for next in prev:
        if 0 <= next < (300000) and dist[next] == dist[cur] - 1 and dist[next] != -1:
            if next == N:
                m += 1
                break
            q.append(next)

sys.stdout.write(f"{t}\n{m}\n")

# 10 9 18 17
# 4 8 16 17