import sys

M, N, L = map(int, sys.stdin.readline().split())
sp = list(map(int, sys.stdin.readline().split()))
sp.sort()
tg = []
for _ in range(N):
    tg.append(list(map(int, sys.stdin.readline().split())))

# 타겟을 하나씩 까본다. O(N)
# 그 타겟을 쏠 수 있는 사대의 x좌표 범위를 구한다.   >> O(1)
# 사대에 그 범위 내 좌표가 있는 지 이분 탐색한다.   >> O(logM)
# => O(NlogM)

ans = 0
for t in tg:
    if L < t[1]:
        continue

    minx = t[0] - (L - t[1])
    maxx = t[0] + (L - t[1])

    lsp = 0
    rsp = 0

    l = 0
    r = M - 1
    while l <= r:
        mid = (l + r) // 2
        if sp[mid] == minx:
            lsp = mid
            break
        elif sp[mid] > minx:
            r = mid - 1
            lsp = mid
        else:
            l = mid + 1
            lsp = l

    l = 0
    r = M - 1
    while l <= r:
        mid = (l + r) // 2
        if sp[mid] == maxx:
            rsp = mid
            break
        elif sp[mid] > maxx:
            r = mid - 1
            rsp = r
        else:
            l = mid + 1
            rsp = mid

    if lsp <= rsp:  # 범위 안에 사대가 잡혔다는 뜻
        ans += 1

print(ans)
