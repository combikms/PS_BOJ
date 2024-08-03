import sys
from collections import deque

N = int(sys.stdin.readline())
scv = list(map(int, sys.stdin.readline().split()))
while len(scv) < 3:
    scv.append(0)
scv.sort(reverse=True)
hp = [
    [[-1] * 61 for _ in range(61)] for _ in range(61)
]  # 절약을 위해 내림차순 정렬된 상태만 ㄱㄱ
hit = [[9, 3, 1], [3, 9, 1], [9, 1, 3], [3, 1, 9], [1, 3, 9], [1, 9, 3]]

def BFS():
    q = deque([scv])
    hp[scv[0]][scv[1]][scv[2]] = 0

    while q:
        cur = q.popleft()        
        for i in range(6):
            if len(cur) == 2:
                if i > 1:
                    break
            elif len(cur) == 1:
                if i > 0:
                    break
            s1 = cur[0] - hit[i][0] if cur[0] > hit[i][0] else 0
            s2 = cur[1] - hit[i][1] if cur[1] > hit[i][1] else 0
            s3 = cur[2] - hit[i][2] if cur[2] > hit[i][2] else 0
            next = [s1, s2, s3]
            next.sort(reverse=True)            
            if hp[next[0]][next[1]][next[2]] == -1:
                hp[next[0]][next[1]][next[2]] = hp[cur[0]][cur[1]][cur[2]] + 1
                q.append(next)

            if s1 == 0 and s2 == 0 and s3 == 0:
                return hp[0][0][0]

print(BFS())