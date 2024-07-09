import sys

T = int(sys.stdin.readline())
for _ in range(T):
    N = int(sys.stdin.readline())
    prices = list(map(int, sys.stdin.readline().split()))
    
    max_price = prices[-1]
    profit = 0    
    
    for i in range(N - 2, -1, -1):
        if prices[i] > max_price:
            max_price = prices[i]
        else:
            profit += max_price - prices[i]
    
    sys.stdout.write(str(profit) + "\n")