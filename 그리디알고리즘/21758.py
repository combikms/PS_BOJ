import sys

N = int(sys.stdin.readline())
graph = list(map(int, sys.stdin.readline().split()))
s_graph = [graph[0]]
for i in range(1, N):
    s_graph.append(s_graph[i - 1] + graph[i])

# -> ->
# 꿀통까지 다 싹쓸고 시작점만 빼진다.
# 무조건 맨 오른쪽에 꿀통을 둬야 한다.
# 맨 왼쪽에 무조건 벌 한마리 둬야 한다.
# 나머지 벌 하나는 순차탐색 ㄱㄱ ( O(N)이라 괜찮음 )
# sum(graph[1:]) - graph[i] + sum(graph[i + 1:]))

# -> <-
# 어떻게 하든 최댓값은 sum(graph) + max(graph[1:-1]) - graph[0] - graph[-1]

# <- <-
# 첫 번째 방법이랑 방향만 반대임
# sum(graph[:-1]) - graph[i] + sum(graph[:i])

a1 = 0
for i in range(1, N - 1):
    a1 = max(a1, (s_graph[N - 1] - graph[0]) - graph[i] + s_graph[N - 1] - s_graph[i])

a2 = s_graph[N - 1] + max(graph[1 : (N - 1)]) - graph[0] - graph[N - 1]
a3 = 0
for i in range(N - 2, 0, -1):    
    a3 = max(a3, s_graph[N - 1] - graph[N - 1] - graph[i] + s_graph[i - 1])

sys.stdout.write(str(max(a1, a2, a3)) + "\n")
