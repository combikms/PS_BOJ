import sys
import math

N, K = map(int, sys.stdin.readline().split())
bottle = []
while N >= 1:
    compiled = 2 ** int(math.log2(N))
    bottle.append(compiled)
    N -= compiled

ans = 0
while len(bottle) > K:    
    ans += bottle[len(bottle) - 1]
    bottle[len(bottle) - 1] = 2 * bottle[len(bottle) - 1]
    bottle.sort(reverse=True)
    while len(bottle) > K:
        if bottle[len(bottle) - 1] == bottle[len(bottle) - 2]:
            bottle.pop()
            bottle[len(bottle) - 1] *= 2
        else:
            break

sys.stdout.write(str(ans) + '\n')