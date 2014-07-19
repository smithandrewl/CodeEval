import sys

def decimalToBinary(num):
    result = []
    rem = num

    if num == 0:
        return "0"

    while rem > 0:
        result.append(str(rem % 2))
        rem = int(rem / 2)

    result.reverse()
    return "".join(result)

def processLine(line):
    print(decimalToBinary(int(line)))

lines = open(sys.argv[1], 'r').readlines()

for line in lines:
    processLine(line.rstrip("\r\n"))