N, M = map(int, input().split())

A = []
B = []
for _ in range (N):
    A.append(list(map(int, input().strip())))
for _ in range (N):
    B.append(list(map(int, input().strip())))

# 똑같아서 안 바꿈
if A == B:
    print(0)
    exit(0)

# 크기 작아서 못 바꿈
if N < 3 or M < 3:
    print(-1)
    exit(0)

# 3x3 부분 행렬 뒤집기
def Flip(A, row, col):    
    for i in range (3):
        for j in range (3):
            A[row + i][col + j] = 1 - A[row + i][col + j]

# 핵심 부분
ans = 0
for i in range(N - 2):
    for j in range(M - 2):
        if A[i][j] != B[i][j]:
            Flip(A, i, j)
            ans += 1

if A == B:
    print(ans)
else:
    print(-1)