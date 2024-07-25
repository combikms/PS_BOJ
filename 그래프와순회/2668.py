import sys

N = int(sys.stdin.readline())
A = [i for i in range (N + 1)]
B = [0]
for _ in range (N): B.append(int(sys.stdin.readline()))

# 꼬꼬무 탐색법
# B가 가리키는 값을 A에서 찾고 또 거기서의 B값을 A에서 찾고... 
# => 다시 제 자리로 돌아올 때까지 한다.
# => 만약 제 자리로 돌아오지 않고, 중간 경유지에 들어가게 되면 그건 실패한 집합이다.

def DFS(start):
    stack = [ start ]    
    visited = [False] * len(A)
    result = []
    while True:
        cur = stack.pop()
        result.append(cur)
        if not visited[cur]:
            visited[cur] = True
            next = B[cur]
            if not visited[next]:
                stack.append(next)
            else:
                if next == start: return result
                else: return 0

numbers = set()
for i in range (1, N + 1):
    temp = DFS(i)
    if temp != 0:
        for num in temp:
            numbers.add(num)

ans = sorted(numbers)
sys.stdout.write(str(len(ans)) + '\n')
for num in ans:
    sys.stdout.write(str(num) + '\n')