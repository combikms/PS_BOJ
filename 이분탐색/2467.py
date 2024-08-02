import sys

N = int(sys.stdin.readline())
liq = list(map(int, sys.stdin.readline().split()))

al = liq[0]
ar = liq[N - 1]

for i in range(N - 1):
    l = i + 1
    r = N - 1

    while l <= r:
        mid = (l + r) // 2
        if liq[i] + liq[mid] > 0:
            r = mid - 1
        else:
            l = mid + 1

        if abs(liq[i] + liq[mid]) < abs(al + ar):
            al = liq[i]
            ar = liq[mid]

sys.stdout.write(f"{al} {ar}\n")
