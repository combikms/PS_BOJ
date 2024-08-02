import sys

N = int(sys.stdin.readline())
req = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())

l = 0
r = max(req)

if sum(req) <= M:
    sys.stdout.write(str(r) + "\n")
    sys.exit()

ans = 0
while l <= r:
    mid = (l + r) // 2

    aligned = 0
    for bg in req:
        if bg < mid:
            aligned += bg
        else:
            aligned += mid

    if aligned <= M:  # 예산이 좀 남거나 딱 맞았다.
        l = mid + 1
        ans = mid    
    else:  # 예산이 부족하다.
        r = mid - 1

sys.stdout.write(str(ans) + "\n")