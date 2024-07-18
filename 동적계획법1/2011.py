import sys

num = [0]
num.extend(list(map(int, sys.stdin.readline().strip())))

# dp[i] = i자리까지 고려했을 때, 가능한 경우의 수
# dp[i][0] = 뒤에서 앞에꺼 안 합쳤을 때
# dp[i][1] = 뒤에서 앞에꺼 합쳤을 때

# dp[i][1] = dp[i - 2][0] + dp[i - 2][1] (합쳤다!)
# dp[i][0] = dp[i - 1][0] + dp[i - 1][1] (안 합쳤다!)

dp = [ [0] * 2 for _ in range ((len(num))) ]
dp[0][1] = 1

for i in range (1, len(num)):    
    if num[i] == 0: # 현재가 0이면 앞에랑 합쳐야 한다.
        if not (num[i - 1] == 1 or num[i - 1] == 2):
            sys.stdout.write('0\n')
            exit(0)
        else:
            dp[i][1] = dp[i - 2][0] + dp[i - 2][1]
            continue
    if i < len(num) - 1:
        if num[i + 1] == 0: # 뒤에가 0이면 합치지 말고 냅둬야 한다.            
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1]
            continue
    if num[i - 1] == 0: # 앞에가 0이면 합치지 말아야 한다.
        dp[i][0] = dp[i - 1][0] + dp[i - 1][1]
        continue
    if num[i - 1] * 10 + num[i] > 26:
        dp[i][0] = dp[i - 1][0] + dp[i - 1][1]        
    else:
        dp[i][1] = dp[i - 2][0] + dp[i - 2][1]
        dp[i][0] = dp[i - 1][0] + dp[i - 1][1]

sys.stdout.write(str((dp[len(num) - 1][0] + dp[len(num) - 1][1]) % 1000000) + '\n')