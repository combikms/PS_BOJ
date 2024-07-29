import sys

N = int(sys.stdin.readline())
row = list(map(int, sys.stdin.readline().split()))
min_ = [num for num in row]
max_ = [num for num in row]

for i in range (N - 1):
    a, b, c = map(int, sys.stdin.readline().split())

    m1 = a + min(min_[:2])
    m2 = b + min(min_)
    m3 = c + min(min_[1:])
    min_ = [m1, m2, m3]

    m1 = a + max(max_[:2])
    m2 = b + max(max_)
    m3 = c + max(max_[1:])
    max_ = [m1, m2, m3]

sys.stdout.write(str(max(max_)) + ' ')
sys.stdout.write(str(min(min_)) + '\n')