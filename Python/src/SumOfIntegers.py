__author__ = 'andrew'

import sys
test_cases = open(sys.argv[1], 'r')

sum = 0

for test in test_cases:
    sum += int(test.rstrip('\n'))

print(sum)

test_cases.close()