import sys

N, K = map(int, sys.stdin.readline().split())
A = [9 * (10 ** i) for i in range (100) ]

# # N 까지의 수 길이
l = 0
d = 0
while N > 0:
    max_size = 9 * (10 ** d)
    if N > max_size:
        l += max_size * (d + 1)
        N -= max_size
    else:
        l += N * (d + 1)
        break
    d += 1

if l < K:
    sys.stdout.write('-1\n')
    sys.exit()

i = 0
while K > A[i] * (i + 1):
    K -= A[i] * (i + 1)
    i += 1

# 이제 그 숫자는 i + 1글자로 이루어진 숫자가 시작되는 지점 기준으로 K번째 위치의 값이라는 것을 알았음

cur = (10 ** i) + (K - 1) // (i + 1)
K -= (cur - (10 ** i)) * (i + 1)

# 이제 그 숫자는 cur 이라는 숫자의 K번째 글자라는 것을 알았음

ans = str(cur)[K - 1]
sys.stdout.write(ans + '\n')