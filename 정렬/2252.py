import sys
from functools import cmp_to_key

N, M = map(int, sys.stdin.readline().split())
student = [i for i in range(1, N + 1)]
order = [-1] * (N + 1)
for _ in range(M):
    front, back = map(int, sys.stdin.readline().split())
    order[front] = back


def cmp(a, b):
    if order[a] == b:
        return -1
    elif order[b] == a:
        return 1
    else:
        return 0


student.sort(key=cmp_to_key(cmp))
ans = " ".join(map(str, student))

print(student)
print(order)
print(ans)
