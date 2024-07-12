import sys

N = int(sys.stdin.readline())
line = []
for i in range(N):
    line.append(list(map(int, sys.stdin.readline().split())))

line.sort() # O(nlogn)
ans = line[0][1] - line[0][0]
max_end = line[0][1]
for i in range (N - 1):
    cur_end, next_start, next_end = line[i][1], line[i + 1][0], line[i + 1][1]
    max_end = max(max_end, cur_end)        
    if next_start < max_end:
        if max_end < next_end:
            ans += next_end - max_end
    else:
        ans += next_end - next_start        

sys.stdout.write(str(ans))