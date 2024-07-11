import sys

N = int(sys.stdin.readline()) # 센서
K = int(sys.stdin.readline()) # 수신기

Sensor = list(map(int, sys.stdin.readline().split()))
Sensor.sort()

if N == 1 or N <= K:
    sys.stdout.write("0")
    exit(0)

gap = []
for i in range(1, N):
    gap.append(Sensor[i] - Sensor[i - 1])
gap.sort(reverse=True)

sys.stdout.write(str(sum(gap[K - 1:])))