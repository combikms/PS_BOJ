import sys

S = sys.stdin.readline().strip()
T = sys.stdin.readline().strip()
visited = set()

def DFS():    
    stack = [T]
    while stack:
        cur = stack.pop()        
        if cur == S:
            return '1'
        if not cur in visited and len(cur) > len(S):
            visited.add(cur)
            s1 = cur[:-1]
            s2 = cur[::-1][:-1]
            if cur[0] == 'A' and cur[-1] == 'A':
                if not s1 in visited: stack.append(s1)
            elif cur[0] == 'B' and cur[-1] == 'B':
                if not s2 in visited: stack.append(s2)
            elif cur[0] == 'B' and cur[-1] == 'A':
                if not s1 in visited: stack.append(s1) 
                if not s2 in visited: stack.append(s2)

    return '0'

sys.stdout.write(DFS() + '\n')