import sys

N, L = map(int, sys.stdin.readline().split())
map_ = []
for _ in range(N):
    map_.append(list(map(int, sys.stdin.readline().split())))

for c in range(N):
    col = []
    for r in range(N):
        col.append(map_[r][c])
    map_.append(col)


def isValid(road):
    length = 1
    for i in range(1, N):
        if abs(road[i - 1] - road[i]) > 1:
            return False
        elif road[i - 1] == road[i]:
            length += 1
        elif road[i - 1] + 1 == road[i]:
            if length >= L:
                length = 1
            else:
                return False
        elif road[i - 1] == road[i] + 1:
            if i + L - 1 >= N:
                return False
            for j in range(i, i + L):
                if road[j] != road[i]:
                    return False
            length = -L + 1

    return True


ans = 0
for road in map_:
    if isValid(road):
        ans += 1

print(ans)