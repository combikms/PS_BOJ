import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
truth = list(map(int, sys.stdin.readline().split()))
party = [[]]
for _ in range(M):
    party.append(list(map(int, sys.stdin.readline().split())))

# 파티 번호는 51번부터, 사람 번호는 1번부터 사용하면 구분이 될 것 같다.

graph = [[] for _ in range(101)]
for i in range(1, M + 1):
    for j in range(1, 1 + party[i][0]):
        graph[50 + i].append(party[i][j])
        graph[party[i][j]].append(50 + i)

comeout = [False] * 101


def BFS(s):
    q = deque([s])
    comeout[s] = True

    while q:
        cur = q.popleft()
        for neighbor in graph[cur]:
            if not comeout[neighbor]:
                comeout[neighbor] = True
                q.append(neighbor)


for i in range(1, truth[0] + 1):
    BFS(truth[i])

ans = 0
for i in range(51, M + 51):
    if not comeout[i]:
        ans += 1

print(ans)
