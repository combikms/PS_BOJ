import sys

N = int(sys.stdin.readline())
tree = list(map(int, sys.stdin.readline().split()))

sum_tree = sum(tree)
if sum_tree % 3 != 0:
    sys.stdout.write("NO\n")
else:
    twos = 0
    for h in tree:
        twos += h // 2
    if sum_tree // 3 <= twos:
        sys.stdout.write("YES\n")
    else:  # 번복 기회가 부족하여 높이를 맞춰줄 수 없다.
        sys.stdout.write("NO\n")
