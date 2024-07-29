import sys
from copy import deepcopy

N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().strip()))
B = list(map(int, sys.stdin.readline().strip()))

def Solve(method):
    result = deepcopy(A)
    cnt = 0
    if method == 0:
        result[0], result[1] = 1 - result[0], 1 - result[1]
        cnt += 1    
    for i in range (1, N):
        if result[i - 1] != B[i - 1]:
            result[i - 1] = 1 - result[i - 1]
            result[i] = 1 - result[i]
            if i < N - 1: result[i + 1] = 1 - result[i + 1]
            cnt += 1
    
    if result == B: return cnt
    else: return -1

r1 = Solve(0)
r2 = Solve(1)

if A == B: sys.stdout.write('0\n')
elif r1 != -1 and r2 != -1:
    sys.stdout.write(str(min(r1, r2)) + '\n')
elif r1 * r2 < 0:
    sys.stdout.write(str(max(r1, r2)) + '\n')
else:
    sys.stdout.write('-1\n')