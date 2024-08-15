import sys
from collections import Counter

T = int(sys.stdin.readline())
n = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
B = list(map(int, sys.stdin.readline().split()))

# 모든 부배열에 대한 합 미리 구해놓기
# => 누적합 필수. N^2 + M^2

# 이분탐색으로 각 부배열에 맞는 짝 찾을라면 정렬해야겠네
# N^2logN^2 + M^2logM^2

As = [A[0]]
for i in range(1, n):
    As.append(As[i - 1] + A[i])

Bs = [B[0]]
for i in range(1, m):
    Bs.append(Bs[i - 1] + B[i])

ABoo = [As[i] for i in range(n)]
for i in range(n - 1):
    for j in range(i + 1, n):
        ABoo.append(As[j] - As[i])

BBoo = [Bs[i] for i in range(m)]
for i in range(m - 1):
    for j in range(i + 1, m):
        BBoo.append(Bs[j] - Bs[i])

ABoo.sort()
BBoo.sort()
cnt = Counter(BBoo)

ans = 0
for case in ABoo:
    l = 0
    r = len(BBoo) - 1
    while l <= r:
        mid = (l + r) // 2
        if case + BBoo[mid] < T:
            l = mid + 1
        elif case + BBoo[mid] > T:
            r = mid - 1
        else:
            ans += cnt[BBoo[mid]]
            break

print(ans)
