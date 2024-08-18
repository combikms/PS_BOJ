import sys

N = int(sys.stdin.readline().strip())
A = []
B = []
for _ in range(N):
    input_ = list(map(int, sys.stdin.readline().strip().split()))
    A.append(input_[:-1])
    B.append(input_[-1])


def gauusian():
    for i in range(N - 1):
        for j in range(i + 1, N):
            factor = A[j][i] / A[i][i]
            for k in range(i, N):
                A[j][k] -= factor * A[i][k]
            B[j] -= factor * B[i]


def backSubstitution():
    X = [0] * (N)
    for i in range(N - 1, -1, -1):
        X[i] = B[i] / A[i][i]
        for j in range(N):
            B[j] -= X[i] * A[j][i]
            A[j][i] = 0
    return X


gauusian()
ans = backSubstitution()
for s in ans:
    sys.stdout.write(str("{:.0f}".format(s)) + ' ')
sys.stdout.write('\n')