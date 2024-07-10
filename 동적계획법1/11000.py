import sys
import heapq

# 작업 스케줄링 문제:
# 시작 시간 기준으로 정렬한다.
# 앞에서부터 하나씩 뽑는데...
#   1. 넣을 수 있는 기계가 있으면 넣는다.
#   2. 넣을 수 있는 기계가 없으면 기계를 하나 추가한다.

N = int(sys.stdin.readline())
lecture = []

for _ in range(N):
    start, end = map(int, sys.stdin.readline().split())
    lecture.append((start, end))

lecture.sort()

room = []  # 최소 종료 시간 기준 민힙
for start, end in lecture:
    if room and room[0] <= start:
        heapq.heappop(room) # 강의 새로 배정
    heapq.heappush(room, end)

sys.stdout.write(str(len(room)))