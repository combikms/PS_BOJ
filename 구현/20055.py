import sys

N, K = map(int, sys.stdin.readline().split())
A = list(map(int, sys.stdin.readline().split()))
robot = [False] * len(A)
zeros = 0

def Rotate(A):
    temp = A[len(A) - 1]
    for i in range (len(A) - 1, -1, -1): A[i] = A[i - 1]
    A[0] = temp

stages = 0
while True:
    stages += 1

    Rotate(A) # 1. 컨베이어 벨트의 회전
    Rotate(robot)
    if robot[N - 1]: robot[N - 1] = False

    for i in range (N - 2, -1, -1): # 2. 로봇의 이동
        if robot[i] and A[i + 1] > 0 and not robot[i + 1]:
            robot[i + 1] = True
            robot[i] = False
            A[i + 1] -= 1
            if A[i + 1] == 0: zeros += 1
    if robot[N - 1]: robot[N - 1] = False

    if A[0] > 0: # 3. 로봇 올릴 수 있으면 올리기
        robot[0] = True
        A[0] -= 1
        if A[0] == 0: zeros += 1

    if zeros >= K: break # 4. 종료 여부 결정

sys.stdout.write(str(stages) + '\n')