import sys

def decimalToBinary(number):
    def inner(number, acc):
        if number == 0:
            acc.reverse()
            nums = [str(num) for num in acc]
            return "".join(nums)
        else:
            acc.append(number % 2)
            return inner(int(number / 2), acc)

    if number == 0:
        return "0"
    else:
        return inner(number, [])


def processLine(line):
    binary = decimalToBinary(int(line))

    sum = 0

    for digit in binary:
        if digit == "1":
            sum += 1

    print(sum)

lines = open(sys.argv[1], 'r').readlines()

for line in lines:
    processLine(line.rstrip("\r\n"))