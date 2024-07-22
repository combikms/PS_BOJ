import sys

N = int(sys.stdin.readline())
crane = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
box = list(map(int, sys.stdin.readline().split()))

crane.sort() # NlogN
box.sort() # MlogM

if crane[N - 1] < box[M - 1]:
    sys.stdout.write('-1\n')
    exit(0)

# 무거운 것부터 하나씩 크레인에 할당하면서 pop하면 될 것 같다.

ans = 0
while box:  # M * N * M = M^2 * N
    for c in range (N - 1, -1, -1):
        if box:
            for b in range (len(box) - 1, -1, -1):
                if crane[c] >= box[b]:
                    box.pop(b)
                    break
        else:
            break
    ans += 1

sys.stdout.write(str(ans) + '\n')