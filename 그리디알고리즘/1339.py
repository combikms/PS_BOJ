import sys

def Calc(words):
    value = {}

    for word in words:
        length = len(word)
        for i, char in enumerate(word):
            power = length - i - 1
            if char in value:
                value[char] += 10 ** power
            else:
                value[char] = 10 ** power

    sorted_chars = sorted(value.items(), key=lambda x: x[1], reverse=True)

    num = 9
    char_to_num = {}
    for char, _ in sorted_chars:
        char_to_num[char] = num
        num -= 1

    sum = 0
    for word in words:
        cur = 0
        for char in word:
            cur = cur * 10 + char_to_num[char]
        sum += cur

    return sum

N = int(sys.stdin.readline().strip())
words = [sys.stdin.readline().strip() for _ in range(N)]
sys.stdout.write(str(Calc(words)))