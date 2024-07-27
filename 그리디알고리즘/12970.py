import sys

N, K = map(int, sys.stdin.readline().split())

s = [1] * N
ans = '-1'
for i in range (N - 1, -1, -1):
    if s[i] == 1:
        s[i] = 0
        score = 0
        for j in range (N - 1, -1, -1):
            if s[j] == 0:
                score += sum(s[:j])
        if score > K:
            s[i] = 1
        elif score == K:
            ans = ''
            for k in s:
                if k == 1: ans = ans + 'A'
                else: ans = ans + 'B'
            break

sys.stdout.write(ans + '\n')