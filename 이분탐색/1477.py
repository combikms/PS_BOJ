import sys
import math

N, M, L = map(int, sys.stdin.readline().split())
rest = list(map(int, sys.stdin.readline().split()))
rest.sort()

if N == 0:
    gap = [L]
else:
    gap = [rest[0], L - rest[N - 1]]
    for i in range(N - 1):
        gap.append(rest[i + 1] - rest[i])

# 답을 정해놓고 그게 되는 지 알아보면서 점점 좁혀나가기
ans = 0
l = 0
r = L
while l <= r:
    mid = (l + r) // 2
    cuts = 0

    if mid != 0:
        for g in gap:
            cuts += math.ceil(g / mid) - 1
    else:
        cuts = float("inf")

    if cuts <= M:
        ans = mid
        r = mid - 1
    else:
        l = mid + 1

print(ans)
