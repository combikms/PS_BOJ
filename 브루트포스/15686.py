import sys
import itertools

# 치킨집의 수가 많지 않으므로 브루트포스 해도 될 것 같다.

N, M = map(int, sys.stdin.readline().split())
graph = []
for _ in range (N): graph.append(list(map(int, sys.stdin.readline().split())))

house = []
store = []
for R in range (N):
    for C in range (N):
        if graph[R][C] == 1:
            house.append([R, C])
        elif graph[R][C] == 2:
            store.append([R, C])

survived_store = list(itertools.combinations(store, M))

ans = 999999
for case in survived_store:
    city_dist = 0
    for h in house:
        house_dist = 999999
        for s in case:
            house_dist = min(house_dist, abs(h[0] - s[0]) + abs(h[1] - s[1]))
        city_dist += house_dist
    ans = min(ans, city_dist)

sys.stdout.write(str(ans) + '\n')