import sys

N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
S = int(sys.stdin.readline())

# 지금 남아있는 S의 한도 내에서 뒤에 있는 놈들중 맥스 값 찾는다.
# 그 안에 있는 애중 제일 큰 애를 맨 앞으로 보내버리고
# S를 그 거리만큼 감소시키면 되자너. 천잰데?
# 만약에 그 거리내에 현재보다 더 최대인 게 안 나왔으면, S를 한 칸 올려버리고 다시 해.

for i in range (N):
    max_num = A[i]
    max_idx = i
    last = min(i + S + 1, N)
    for j in range (i, last):
        if max_num < A[j]:
            max_num = A[j]
            max_idx = j

    A.pop(max_idx)
    A.insert(i, max_num)
    S -= max_idx - i

for data in A:
    sys.stdout.write(str(data) + " ")