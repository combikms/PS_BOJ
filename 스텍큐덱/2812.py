import sys

N, K = map(int, sys.stdin.readline().split())
num = list(map(str, sys.stdin.readline().strip()))
stack = []

for n in num:
    while K > 0 and stack and stack[-1] < n:
        stack.pop()
        K -= 1
    stack.append(n)

while K > 0:
    stack.pop()
    K -= 1

print("".join(stack))
