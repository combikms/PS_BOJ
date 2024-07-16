import sys

def nextDay(date):
    month = date // 100
    day = date % 100
    
    if month == 2:
        if day == 28:
            return 301
    elif month == 4 or month == 6 or month == 9 or month == 11:
        if day == 30:
            return date + 71
    else:
        if day == 31:
            return date + 70
    
    return date + 1

def prevDay(date):
    month = date // 100
    day = date % 100

    if date == 101:
        return 0
    
    if day == 1:    
        if month == 3:        
            return 228
        elif month == 5 or month == 7 or month == 10 or month == 12:        
            return (month - 1) * 100 + 30
        else:        
            return (month - 1) * 100 + 31
    
    return date - 1

N = int(sys.stdin.readline().strip())
flower = []
for _ in range (N):
    sm, sd, em, ed = map(int, sys.stdin.readline().split())
    flower.append([sm * 100 + sd, em * 100 + ed])

flower.sort()

# 유통기한 안에 있는 꽃들을 싸그리 긁어모은다.
# => 그 중에서 연장 가능한 꽃이 있다면 연장시킨다.
# => 없으면 0으로 만들고 끝낸다.

last_day = 228 # 이 날까지는 꽃이 피어있다.
latest = 0
ans = 0
i = 0

while i < N and last_day < 1130:
    while i < N:
        if flower[i][0] <= nextDay(last_day): # 긁어모으기
            latest = max(latest, prevDay(flower[i][1]))
            i += 1
        else:            
            break

    if latest > last_day: # 연장하기        
        last_day = latest
        ans += 1
    else: # 가망 없음
        ans = 0
        break

if last_day < 1130:
    ans = 0

sys.stdout.write(str(ans) + '\n')