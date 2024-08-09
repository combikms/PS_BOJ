import sys

N = int(sys.stdin.readline())
town = []
for _ in range(N):
    town.append(list(map(int, sys.stdin.readline().split())))
town.sort()

temp = 0
for i in range(1, N):
    temp += town[i][1]

people = [[0, temp]]
for i in range(1, N):
    people.append([people[i - 1][0] + town[i - 1][1], people[i - 1][1] - town[i][1]])

cur = 0
while people[cur][0] < people[cur][1]:
    cur += 1

if cur == 0:
    print(town[0][0])
else:
    cost_cur = 0
    cost_prev = 0
    for i in range(N):
        cost_cur += abs(town[cur][0] - town[i][0]) * town[i][1]
        cost_prev += abs(town[cur - 1][0] - town[i][0]) * town[i][1]

    ans = town[cur][0] if cost_cur < cost_prev else town[cur - 1][0]
    print(ans)


# 일단 마을들 사이에 짓기는 해야 함
# 떨어진 거리 * 사는 사람 수   => 중요한 지표가 될 듯

# 한 칸 이동시킬때마다 비용은 이렇게 변동함
# => -1: (지오른쪽 사는 사람들 총합 - 지왼쪽 사는 사람들 총합)
# => +1: (지 왼쪽 사는 사람들 총합 - 지 오른쪽 사는 사람들 총합)
# => 그럼 왼쪽 오른쪽 합이 비등비등한 곳이 제일 좋겠다.

# 그냥 사람 많은 쪽으로 계속 이동하면 되지 않을까 싶
