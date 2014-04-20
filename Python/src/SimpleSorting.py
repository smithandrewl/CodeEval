import sys

test_cases = open(sys.argv[1], 'r')

for test in test_cases:
    numbers = [float(num) for num in test.rstrip('\n').split(" ")]
    numbers.sort()

    for number in numbers:
        print(number, end=' ')

    print()