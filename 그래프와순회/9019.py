import sys
from collections import deque

def D(num):
    return (2 * num) % 10000

def S(num):
    return (num - 1) % 10000

def L(num):
    return (num % 1000) * 10 + (num // 1000)

def R(num):
    return (num % 10) * 1000 + (num // 10)

T = int(sys.stdin.readline())
for _ in range (T):
    A, B = map(int, sys.stdin.readline().split())
    visited = [False] * 10000
    q = deque([(A, '')])

    while q:
        cur, path = q.popleft()
        d, s, l, r = D(cur), S(cur), L(cur), R(cur)
        if not visited[d]:
            visited[d] = True
            if d == B:
                sys.stdout.write(path + 'D' + '\n')
                break
            q.append((d, path + 'D'))
        if not visited[s]:
            visited[s] = True        
            if s == B:
                sys.stdout.write(path + 'S' + '\n')
                break    
            q.append((s, path + 'S'))
        if not visited[l]:
            visited[l] = True            
            if l == B:
                sys.stdout.write(path + 'L' + '\n')
                break
            q.append((l, path + 'L'))
        if not visited[r]:
            visited[r] = True            
            if r == B:
                sys.stdout.write(path + 'R' + '\n')
                break
            q.append((r, path + 'R'))