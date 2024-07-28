import sys

H, W = map(int, sys.stdin.readline().split())
hist = list(map(int, sys.stdin.readline().split()))

ans = 0
for l in range (max(hist), -1, -1):
    block = []
    for i in range (W):        
        if hist[i] >= l:
            block.append(i)
    for i in range (len(block) - 1):
        ans += block[i + 1] - block[i] - 1

sys.stdout.write(str(ans) + '\n')