import sys

test_cases = open(sys.argv[1], 'r')

for test in test_cases:
    line = test.rstrip('\n')

    reversed_words = line.split(' ')
    reversed_words.reverse()

    print(" ".join(reversed_words))

test_cases.close()