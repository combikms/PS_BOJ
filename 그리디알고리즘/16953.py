A, B = map(int, input().split())
count = 1

while True:
    if B == A:
        break

    if B < A:
        count = -1
        break

    if B % 10 == 1:
        B //= 10
    elif B % 2 == 0:
        B //= 2
    else:
        count = -1
        break

    count += 1

print(count)