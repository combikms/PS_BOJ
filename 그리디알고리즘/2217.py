import sys

N = int(sys.stdin.readline())
rope = []
for i in range (N):
    rope.append(int(sys.stdin.readline()))

if N == 1:
    ans = rope[0]
else:
    rope.sort()
    parallels = 1
    ans = rope[N - 1]    
    for i in range (N - 2, -1, -1):
        parallels += 1
        ans = max(rope[i] * parallels, ans)

sys.stdout.write(str(ans))