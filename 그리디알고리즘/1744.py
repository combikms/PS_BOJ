import sys
import heapq

N = int(sys.stdin.readline())

plus = [] # 맥스 힙
zero = []
one = []
minus = [] # 민 힙

def max_push(q, a):
    heapq.heappush(q, -a)

def max_pop(q):
    return -heapq.heappop(q)

for _ in range (N):
    input = int(sys.stdin.readline())
    if input > 1:
        max_push(plus, input)
    elif input == 1:
        one.append(input)
    elif input == 0:
        zero.append(input)
    else:
        heapq.heappush(minus, input)

ans = 0
if one:
    ans += sum(one)

# 양수부
while len(plus) > 1:
    A = max_pop(plus)
    B = max_pop(plus)    
    ans += A * B    
if plus:
    ans -= plus[0]

# 음수부
while len(minus) > 1:
    A = heapq.heappop(minus)
    B = heapq.heappop(minus)
    ans += A * B

if minus:
    if not zero:
        ans += minus[0]

sys.stdout.write(str(ans))