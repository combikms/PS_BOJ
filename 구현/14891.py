# 하드코딩 가독성 실화냐

import sys

# <입력 형식>
# 각 톱니바퀴의 극성이 12시부터 시계방향으로 주어진다. => 원형 큐면 좋을 듯
# N, S = 0, 1
# 3, -1은 3번 톱니바퀴를 반시계로 돌렸단 뜻이다.

# 3번 톱니와 7번 톱니만 주목하면 될 것 같다.
# 톱니[0][2] <-> 톱니[1][6], 톱니[1][2] <-> 톱니[2][6], 톱니[2][2] <-> 톱니[3][6]

def Rotate(gear, dir):
    if dir == 1:  # 시계
        temp = gear[7]
        for i in range (7, 0, -1):
            gear[i] = gear[i - 1]
        gear[0] = temp
    else:  # 반시계
        temp = gear[0]
        for i in range (7):
            gear[i] = gear[i + 1]
        gear[7] = temp

gear = []
for _ in range (4):
    gear.append(list(map(int, sys.stdin.readline().strip())))

K = int(sys.stdin.readline())
for _ in range (K):
    num, dir = map(int, sys.stdin.readline().split())
    if num == 1:
        if gear[0][2] != gear[1][6]:
            if gear[1][2] != gear[2][6]:
                if gear[2][2] != gear[3][6]:
                    Rotate(gear[3], -dir)
                Rotate(gear[2], dir)
            Rotate(gear[1], -dir)
        Rotate(gear[0], dir)
    elif num == 2:
        if gear[1][6] != gear[0][2]:
            Rotate(gear[0], -dir)        
        if gear[1][2] != gear[2][6]:
            if gear[2][2] != gear[3][6]:
                Rotate(gear[3], dir)
            Rotate(gear[2], -dir)
        Rotate(gear[1], dir)
    elif num == 3:
        if gear[2][6] != gear[1][2]:
            if gear[1][6] != gear[0][2]:
                Rotate(gear[0], dir)
            Rotate(gear[1], -dir)
        if gear[2][2] != gear[3][6]:
            Rotate(gear[3], -dir)
        Rotate(gear[2], dir)
    else:
        if gear[2][2] != gear[3][6]:
            if gear[1][2] != gear[2][6]:
                if gear[0][2] != gear[1][6]:
                    Rotate(gear[0], -dir)
                Rotate(gear[1], dir)
            Rotate(gear[2], -dir)
        Rotate(gear[3], dir)
    
score = 1 * gear[0][0] + 2 * gear[1][0] + 4 * gear[2][0] + 8 * gear[3][0]
sys.stdout.write(str(score) + '\n')