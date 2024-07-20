import sys
import itertools

N = int(sys.stdin.readline())
W = []
for _ in range (N): W.append(list(map(int, sys.stdin.readline().split())))

cities = [ i for i in range(1, N)]
path = list(itertools.permutations(cities, N - 1))

min_cost = 10000000
for case in path:
    isinValid = False
    if W[0][case[0]] == 0 or W[case[N - 2]][0] == 0: continue

    cost = W[0][case[0]]
    for i in range (N - 2):
        if W[case[i]][case[i + 1]] == 0:
            isinValid = True
            break
        cost += W[case[i]][case[i + 1]]
    
    if isinValid: continue
    cost += W[case[N - 2]][0]
    min_cost = min(min_cost, cost)   
    
sys.stdout.write(str(min_cost) + '\n')