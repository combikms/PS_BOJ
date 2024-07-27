import sys

girls, boys, intern = map(int, sys.stdin.readline().split())

teams = 0
for _ in range (min(girls // 2, boys)):
    teams += 1
    
if teams < boys:
    intern -= boys - teams
    boys -= boys - teams
if teams * 2 < girls:
    intern -= girls - (teams * 2)
    girls -= girls - (teams * 2)

while intern > 0:
    teams -= 1
    intern -= 3

sys.stdout.write(str(teams) + '\n')