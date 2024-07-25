import sys

A = list(sys.stdin.readline().strip())
B = list(sys.stdin.readline().strip())

# 접근법 자체를 좀 다르게 해야 할 것 같다.
# dp[i][j]: 각각의 LCS에서, A의 i번째가 마지막 글자, B의 j번째가 마지막 글자라고 가정했을 때

dp = [ [0] * len(B) for _ in range (len(A)) ]
ans = 0
for i in range (len(A)):
    for j in range (len(B)):
        if A[i] == B[j]:                    
                dp[i][j] = 1 if i == 0 or j == 0 else dp[i - 1][j - 1] + 1
                ans = max(ans, dp[i][j])

sys.stdout.write(str(ans) + '\n')