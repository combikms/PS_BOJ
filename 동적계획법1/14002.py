import sys

N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))

dp = [1] * N
for i in range (N):
    for j in range (i):
        if A[j] < A[i]:
            dp[i] = max(dp[j] + 1, dp[i])
            
mi = 0
for i in range (N):
    if dp[mi] < dp[i]: mi = i

r_path = [A[mi]]
ci = mi
for i in range (mi, -1, -1):
    if dp[i] + 1 == dp[ci] and A[i] < A[ci]:
        r_path.append(A[i])
        ci = i

ml = dp[mi]
sys.stdout.write(str(ml) + '\n')
for i in range (ml - 1, -1, -1):
    sys.stdout.write(str(r_path[i]) + " ")
sys.stdout.write('\n')