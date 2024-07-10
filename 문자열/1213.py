import sys
from collections import Counter

name = sys.stdin.readline().strip()
count = Counter(name)
mid = None
left = []

for char, freq in count.items():
    if freq % 2 == 1: # 홀수 빈도수가 나타난다면? (짝수 경우를 잘 생각해보자)
        if mid:
            sys.stdout.write("I'm Sorry Hansoo")
            exit(0)
        mid = char
    left.extend(char * (freq // 2)) # 짝수 빈도수를 갖는 건 반을 떼다가 왼쪽에 붙임

left.sort()
left = ''.join(left) # Stringify
right = left[::-1] # Reverse(left)

if mid: # 홀수 길이
    sys.stdout.write(left + mid + right)
else:
    sys.stdout.write(left + right)