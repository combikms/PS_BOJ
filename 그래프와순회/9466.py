import sys

T = int(sys.stdin.readline())
for _ in range(T):
    n = int(sys.stdin.readline())
    lover = [0] + list(map(int, sys.stdin.readline().split()))

    insa = [False] * (n + 1)
    visited = [False] * (n + 1)

    def isTeam(start):
        cycle = []
        cur = start

        while not visited[cur]:
            visited[cur] = True
            cycle.append(cur)
            cur = lover[cur]

        if cur in cycle:
            for i in range(cycle.index(cur), len(cycle)):
                insa[cycle[i]] = True

    for i in range(1, n + 1):
        if not visited[i]:
            isTeam(i)

    sys.stdout.write(str(n - sum(insa)) + "\n")
