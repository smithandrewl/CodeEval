import sys

test_cases = open(sys.argv[1], 'r')

for test in test_cases:
    line = test.rstrip('\n')
    print(line.lower())