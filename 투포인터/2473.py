import sys

N = int(sys.stdin.readline())
liq = list(map(int, sys.stdin.readline().split()))
liq.sort()

ans = [float("inf"), float("inf"), float("inf")]


def update(l, m, r):
    global ans
    if abs(liq[l] + liq[m] + liq[r]) < abs(sum(ans)):
        ans = [liq[l], liq[m], liq[r]]


for m in range(1, N - 1):
    l = 0
    r = N - 1
    update(l, m, r)

    while True:
        sum_ = liq[l] + liq[m] + liq[r]
        if sum_ < 0:
            if l + 1 == m:
                break
            l += 1
            update(l, m, r)
        elif sum_ > 0:
            if r - 1 == m:
                break
            r -= 1
            update(l, m, r)
        else:
            break

    if liq[l] + liq[m] + liq[r] == 0:
        ans = [liq[l], liq[m], liq[r]]
        break
    update(l, m, r)

print(f"{ans[0]} {ans[1]} {ans[2]}")
