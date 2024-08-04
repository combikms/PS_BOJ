import sys

N = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))

# N <= 2000
# 정렬 O(NlogN)
# 모든 조합을 다 까보고, 리스트에 존재하는지 BS로 찾아본다. O(N^2)
# => 주의사항: 지 자신은 들어가면 안 됨

num.sort()
visited = [False] * N
goods = 0
for i in range(N):
    for j in range(i + 1, N):
        l = 0
        r = N - 1
        while l <= r:
            mid = (l + r) // 2
            if num[mid] < num[i] + num[j]:
                l = mid + 1
            elif num[mid] > num[i] + num[j]:
                r = mid - 1
            else:
                if mid != i and mid != j:  # 지 자신이 포함되는 경우는 무효하다.
                    if not visited[mid]:
                        visited[mid] = True
                        goods += 1
                else:  # 그 옆에 또 있나 찾아본다.
                    if mid < N - 1 and num[mid + 1] == num[i] + num[j]:
                        if not visited[mid + 1]:
                            visited[mid + 1] = True
                            goods += 1
                    if mid > 0 and num[mid - 1] == num[i] + num[j]:
                        if not visited[mid - 1]:
                            visited[mid - 1] = True
                            goods += 1
                break

print(goods)
