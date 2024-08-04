import sys

N = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))

# N <= 2000
# 정렬 O(NlogN)
# 아니면 투포인터를 쓰는데 l = 0, r = N - 1로 정해두고,
# 지 자신이 나타나면 스킵하는 방식 어떰?

num.sort()
goods = 0
for i in range(N):
    l = 0
    r = N - 1
    while l < r:
        if num[l] + num[r] == num[i]:
            if l != i and r != i:
                goods += 1
                break
            else:
                if l == i:
                    l += 1
                elif r == i:
                    r -= 1
        elif num[l] + num[r] < num[i]:
            l += 1
        else:
            r -= 1

sys.stdout.write(str(goods) + "\n")
