import sys

N, K = map(int, sys.stdin.readline().split())
student = list(map(int, sys.stdin.readline().split()))
gap = [ student[i + 1] - student[i] for i in range (N - 1)]
gap.sort(reverse=True)
for i in range (K - 1): gap[i] = 0
sys.stdout.write(str(sum(gap)) + '\n')