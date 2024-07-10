import sys
import queue

N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
moves = [-1] * N
visited = [False] * N

def BFS(A, visited, moves):
    visited[0] = True
    moves[0] = 0
    q = queue.Queue()
    q.put(0)

    while not q.empty():
        cur = q.get()        

        if A[cur] == 0:
            continue        

        for i in range (1, A[cur] + 1):            
            next = cur + i            
            if next < N and not visited[next]:
                visited[next] = True
                moves[next] = moves[cur] + 1
                q.put(next)

BFS(A, visited, moves)
sys.stdout.write(str(moves[N - 1]))