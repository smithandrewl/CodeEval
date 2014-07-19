import sys

def processLine(line):
    print(sum([int(digit) for digit in line]))

lines = open(sys.argv[1], 'r').readlines()

for line in lines:
    processLine(line.rstrip("\r\n"))