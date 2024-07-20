import sys

S = list(map(str, sys.stdin.readline().strip()))
P = list(map(str, sys.stdin.readline().strip()))

# P에서 다음 글자를 주목한다.
# S에서 그 글자가 나올때까지 순차 탐색한다.
# 나올때마다 P랑 서브스트링이 몇 글자나 겹치나 조사한다.
# 많이 겹치는 게 나올때마다 그 서브스트링의 길이를 갱신시킨다.
# 제일 많이 겹쳤던 서브스트링 기준으로 P에서 다음 글자로 스킵시킨다.

ans = 0
p_idx = 0
while p_idx < len(P):    
    max_sub_len = 0

    for s_idx in range(len(S)):
        if S[s_idx] == P[p_idx]:
            sub_len = 0
            for i in range (min(len(S) - s_idx, len(P) - p_idx)):
                if S[s_idx + i] == P[p_idx + i]:
                    sub_len += 1
                else:
                    break
            
            max_sub_len = max(max_sub_len, sub_len)
    
    p_idx += max_sub_len    
    ans += 1

sys.stdout.write(str(ans) + '\n')