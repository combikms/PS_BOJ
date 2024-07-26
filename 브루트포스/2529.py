import sys
from itertools import permutations

k = int(sys.stdin.readline())
A = list(map(str, sys.stdin.readline().split()))
number = [i for i in range (10)]
case = list(permutations(number, k + 1))

max_num = 0
min_num = 9999999999
for c in case:
    for i in range (k):
        isValid = True
        if A[i] == '<':
            if c[i] > c[i + 1]: 
                isValid = False
                break
        elif A[i] == '>':
            if c[i] < c[i + 1]:
                isValid = False
                break
    if isValid:
        cur_num = 0
        for i in range (k, -1, -1):
            cur_num += c[i] * (10 ** (k - i))
        max_num = max(max_num, cur_num)
        min_num = min(min_num, cur_num)

min_num = str(min_num)
if len(min_num) < k + 1: min_num = '0' + min_num
sys.stdout.write(str(max_num) + '\n' + min_num + '\n')