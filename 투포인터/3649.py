import sys

while True:        
    x = sys.stdin.readline()
    if x == "": break
    x = int(x.strip())
    x *= 10000000
    n = int(sys.stdin.readline())     

    if n == 0:
        sys.stdout.write("danger\n")
        continue

    l = []
    for _ in range (n): l.append(int(sys.stdin.readline()))
    l.sort()

    if n == 1:
        sys.stdout.write("danger\n")
        continue

    # 투 포인터 알고리즘
    # 우선 리스트를 오름차순으로 쏘트한다.
    # i는 왼쪽에서 출발, j는 오른쪽에서 출발
    # i를 목표치를 넘어가는 순간까지 이동시킨다.
    # j를 서서히 내리면서 목표랑 겹칠때까지 이동시킨다.
    # 목표에 도달이 불가하면 답은 danger가 된다.

    i, j = 0, n - 1
    isDanger = True
    while i < j:
        if l[i] + l[j] == x:
            isDanger = False
            break
        elif l[i] + l[j] < x:
            i += 1
        else:
            j -= 1

    
    if isDanger:
        sys.stdout.write("danger\n")
    else:
        sys.stdout.write(f"yes {l[i]} {l[j]}\n")