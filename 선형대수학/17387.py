# 조건 분기가 너무 많은 듯;

import sys


def yunBang(A, B):
    A = [float(a) for a in A]
    B = [float(b) for b in B]

    dete = A[0] * A[3] - A[1] * A[2]

    if dete == 0:
        return None

    X = []
    X.append((B[0] * A[3] - B[1] * A[1]) / dete)
    X.append((A[0] * B[1] - A[2] * B[0]) / dete)

    return X


def isCross():
    global x1, x2, x3, x4, y1, y2, y3, y4

    x1, y1, x2, y2 = float(x1), float(y1), float(x2), float(y2)
    x3, y3, x4, y4 = float(x3), float(y3), float(x4), float(y4)

    if x1 == x2:  # 첫 번째 선분이 y축에 평행
        if x3 == x4:  # 두 번째 선분도 y축에 평행
            if x1 == x3:  # 두 선분이 같은 x좌표 상에 있을 때
                if max(y1, y2) >= min(y3, y4) and max(y3, y4) >= min(y1, y2):
                    return True  # y축 상에서 겹침
                else:
                    return False  # 겹치지 않음
            else:
                return False  # x좌표가 달라서 교차하지 않음
        else:  # 첫 번째 선분만 y축에 평행
            jik2 = yunBang([x3, 1, x4, 1], [y3, y4])
            if jik2 is None:
                return False
            m2, n2 = jik2[0], jik2[1]
            y_cross = m2 * x1 + n2
            if min(y1, y2) <= y_cross <= max(y1, y2) and min(x3, x4) <= x1 <= max(
                x3, x4
            ):
                return True  # 교차함
            else:
                return False  # 교차하지 않음
    elif x3 == x4:  # 두 번째 선분이 y축에 평행한 경우
        jik1 = yunBang([x1, 1, x2, 1], [y1, y2])
        if jik1 is None:
            return False
        m1, n1 = jik1[0], jik1[1]
        y_cross = m1 * x3 + n1
        if min(y3, y4) <= y_cross <= max(y3, y4) and min(x1, x2) <= x3 <= max(x1, x2):
            return True  # 교차함
        else:
            return False  # 교차하지 않음

    # 두 선분이 평행하지 않은 경우
    jik1 = yunBang([x1, 1, x2, 1], [y1, y2])
    jik2 = yunBang([x3, 1, x4, 1], [y3, y4])

    if jik1 is None or jik2 is None:
        return False

    m1, n1 = jik1[0], jik1[1]
    m2, n2 = jik2[0], jik2[1]

    if m1 == m2:
        if n1 != n2:
            return False
        else:
            if min(x1, x2) < max(x1, x2) < min(x3, x4) < max(x3, x4) or min(
                x3, x4
            ) < max(x3, x4) < min(x1, x2) < max(x1, x2):
                return False
            else:
                return True
    else:
        cp = (n1 - n2) / (m2 - m1)
        if min(x1, x2) <= cp <= max(x1, x2) and min(x3, x4) <= cp <= max(x3, x4):
            return True
        else:
            return False


x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
x3, y3, x4, y4 = map(int, sys.stdin.readline().split())

ans = 1 if isCross() else 0
print(ans)
