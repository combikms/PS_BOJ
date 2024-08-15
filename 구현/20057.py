import sys

N = int(sys.stdin.readline())
A = []
for _ in range(N):
    A.append(list(map(int, sys.stdin.readline().split())))

ans = 0
cr, cc = N // 2, N // 2
size = 1
d = 0

dr = [0, 1, 0, -1]
dc = [-1, 0, 1, 0]


def fly(p, prop):
    global ans, cr, cc
    flyed = (A[cr][cc] * prop) // 100
    if 0 <= p[0] < N and 0 <= p[1] < N:
        A[p[0]][p[1]] += flyed
    else:
        ans += flyed
    return flyed


def mvWind():
    global ans, cr, cc, d
    cr += dr[d]
    cc += dc[d]

    s1 = [
        [cr - dr[d] + dr[(d + 1) % 4], cc - dc[d] + dc[(d + 1) % 4]],
        [cr - dr[d] + dr[(d + 3) % 4], cc - dc[d] + dc[(d + 3) % 4]],
    ]
    s2 = [
        [cr + 2 * dr[(d + 1) % 4], cc + 2 * dc[(d + 1) % 4]],
        [cr + 2 * dr[(d + 3) % 4], cc + 2 * dc[(d + 3) % 4]],
    ]
    s5 = [
        [cr + 2 * dr[d], cc + 2 * dc[d]],
    ]
    s7 = [
        [cr + dr[(d + 1) % 4], cc + dc[(d + 1) % 4]],
        [cr + dr[(d + 3) % 4], cc + dc[(d + 3) % 4]],
    ]
    s10 = [
        [cr + dr[d] + dr[(d + 1) % 4], cc + dc[d] + dc[(d + 1) % 4]],
        [cr + dr[d] + dr[(d + 3) % 4], cc + dc[d] + dc[(d + 3) % 4]],
    ]

    flyed = 0
    for i in range(2):
        flyed += fly(s1[i], 1)
        flyed += fly(s2[i], 2)
        if i == 0:
            flyed += fly(s5[i], 5)
        flyed += fly(s7[i], 7)
        flyed += fly(s10[i], 10)

    ar, ac = cr + dr[d], cc + dc[d]
    if 0 <= ar < N and 0 <= ac < N:
        A[ar][ac] += A[cr][cc] - flyed
    else:
        ans += A[cr][cc] - flyed

    A[cr][cc] = 0


def tornado():
    global cr, cc, size, d
    while size < N:
        for _ in range(size):
            mvWind()
        d = (d + 1) % 4
        for _ in range(size):
            mvWind()
        d = (d + 1) % 4
        size += 1
    for _ in range(N - 1):
        mvWind()


tornado()
print(ans)
