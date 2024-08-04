import sys
import heapq

N = int(sys.stdin.readline())
h = list(map(int, sys.stdin.readline().split()))
for i in range(len(h)):
    h[i] = -h[i]
heapq.heapify(h)


def push(a):
    heapq.heappush(h, -a)


def pop():
    return -heapq.heappop(h)


# 앞에 있는 두 놈 끄집어다가 2, 1로 키울 수 있는 만큼 키우기

while len(h) >= 2:    

    temp = sorted(h)
    print(temp)
    
    t1 = pop()
    if t1 == 1:
        break
        
    t2 = pop()
    cnt = min(t1 // 2, t2)

    t1 -= 2 * cnt
    t2 -= cnt

    if t1 > 0:
        push(t1)
    if t2 > 0:
        push(t2)

if h:
    if pop() % 3 == 0:
        sys.stdout.write("YES\n")
    else:
        sys.stdout.write("NO\n")
else:
    sys.stdout.write("YES\n")

# 1 1 1 1 1 1