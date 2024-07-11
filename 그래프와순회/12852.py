import sys
import queue

X = int(sys.stdin.readline())
D = [[-1, -1] for _ in range (X + 1)]  # (이동 횟수, 직전 숫자)

def BFS(D, start):
    D[start][0] = 0    
    q = queue.Queue()
    q.put(start)

    while not q.empty():
        cur = q.get()
        if cur % 3 == 0 and D[cur // 3][0] == -1:
            D[cur // 3][0] = D[cur][0] + 1
            D[cur // 3][1] = cur
            q.put(cur // 3)
        if cur % 2 == 0 and D[cur // 2][0] == -1:
            D[cur // 2][0] = D[cur][0] + 1
            D[cur // 2][1] = cur
            q.put(cur // 2)
        if D[cur - 1][0] == -1:            
            D[cur - 1][0] = D[cur][0] + 1
            D[cur - 1][1] = cur
            q.put(cur - 1)

BFS(D, X)

def Path(D):
    path = []
    cur = 1
    while cur != X:
        path.append(cur)
        cur = D[cur][1]
    path.append(X)
    path.reverse()
    return path

path = ' '.join(str(num) for num in Path(D))
sys.stdout.write(str(D[1][0]) + "\n" + path)