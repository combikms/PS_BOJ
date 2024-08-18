import sys
from functools import cmp_to_key
from collections import deque

def cmp(a, b):
    if a + b > b + a:
        return -1
    elif a + b > b + a:
        return 1
    else:
        return 0
    
N = int(sys.stdin.readline())
num = list(map(str, sys.stdin.readline().split()))
num.sort(key=cmp_to_key(cmp))

ans = deque(num)
while ans[0] == '0':
    if len(ans) == 1:
        break
    ans.popleft()

print(''.join(ans))