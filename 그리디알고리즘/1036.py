def cal_gain(numbers):
    gain = {}
    for num in numbers:
        base = 1
        for digit in reversed(num):
            if digit.isdigit():
                digit_val = int(digit)
            else:
                digit_val = 10 + ord(digit) - ord('A')
            gain[digit] = gain.get(digit, 0) + (35 - digit_val) * base
            base *= 36
    return gain

def sum_values(numbers, chosen):
    total_sum = 0
    for num in numbers:
        num_value = 0
        base = 1
        for digit in reversed(num):
            if digit.isdigit():
                value = int(digit)
            else:
                value = 10 + ord(digit) - ord('A')
            if digit in chosen:
                value = 35
            num_value += value * base
            base *= 36
        total_sum += num_value
    return total_sum

def ten_to_36(value):
    if value == 0:
        return "0"
    result = ""
    while value > 0:
        digit = value % 36
        if digit < 10:
            result += chr(digit + ord('0'))
        else:
            result += chr(digit - 10 + ord('A'))
        value //= 36
    return result[::-1]

def solve(numbers, K):
    gain = cal_gain(numbers)
    sorted_gain = sorted(gain.items(), key=lambda x: x[1], reverse=True)
    chosen = {x[0] for x in sorted_gain[:K]}
    total = sum_values(numbers, chosen)
    return ten_to_36(total)

def main():
    N = int(input())
    numbers = [input() for i in range(N)]
    K = int(input())
    
    result = solve(numbers, K)
    print(result)

main()
