import sys

T = int(sys.stdin.readline())
gear = []
for _ in range (T): gear.append(list(map(int, sys.stdin.readline().strip())))

def Rotate(num, dir, pos):    
    if num != 0 and (pos == 0 or pos == -1):
        if gear[num][6] != gear[num - 1][2]:
            Rotate(num - 1, -dir, -1)
    if num != T - 1 and (pos == 0 or pos == 1):
        if gear[num][2] != gear[num + 1][6]:
            Rotate(num + 1, -dir, 1)
    
    if dir == 1: # 시계
        temp = gear[num][7]
        for i in range (7, 0, -1): gear[num][i] = gear[num][i - 1]
        gear[num][0] = temp
    else: # 반시계
        temp = gear[num][0]
        for i in range (7): gear[num][i] = gear[num][i + 1]
        gear[num][7] = temp

K = int(sys.stdin.readline())
for _ in range (K):
    num, dir = map(int, sys.stdin.readline().split())
    Rotate(num - 1, dir, 0)

ans = 0
for row in gear:
    if row[0] == 1: ans += 1
sys.stdout.write(str(ans) + '\n')