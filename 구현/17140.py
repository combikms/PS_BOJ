# 아쉬운 점:
# - 트랜스포즈 연산을 함수로 따로 만들어놓았다면 보기 좋았을 듯
# - 좀 더 확장성이 좋은 코드를 작성할 여지가 많아보임
# - 순서가 좀 무지성인 것 같음

import sys
from collections import Counter

r, c, k = map(int, sys.stdin.readline().split())
arr = []
for _ in range(3):
    arr.append(list(map(int, sys.stdin.readline().split())))


def operate():
    global arr
    isC = False
    new_arr = []

    max_rlen = 0

    if len(arr) < len(arr[0]):
        isC = True
        arr_t = [[0] * len(arr) for _ in range(len(arr[0]))]
        for i in range(len(arr[0])):
            for j in range(len(arr)):
                arr_t[i][j] = arr[j][i]
        arr = arr_t

    for i in range(len(arr)):
        cnt = sorted(Counter(arr[i]).items(), key=lambda item: (item[1], item[0]))
        newr = []
        for t in cnt:
            if t[0] != 0:
                newr.append(t[0])
                newr.append(t[1])

        new_arr.append(newr)
        max_rlen = max(max_rlen, len(newr))

    for row in new_arr:
        row.extend([0] * (max_rlen - len(row)))

    arr = new_arr

    if isC:
        arr_t = [[0] * len(arr) for _ in range(len(arr[0]))]
        for i in range(len(arr[0])):
            for j in range(len(arr)):
                arr_t[i][j] = arr[j][i]
        arr = arr_t

    while len(arr) > 100:
        arr.pop()

    for row in arr:
        while len(row) > 100:
            row.pop()


ans = 0
while True:
    if r - 1 < len(arr) and c - 1 < len(arr[0]):
        if arr[r - 1][c - 1] == k:
            break

    operate()
    ans += 1

    if ans == 101:
        ans = -1
        break

sys.stdout.write(str(ans) + "\n")
