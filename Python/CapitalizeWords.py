import sys


def title_case(word):
    return word[0].upper() + word[1::]


for test in open(sys.argv[1], 'r'):
    line = test.rstrip('\n')

    print(" ".join([title_case(word) for word in line.split(' ')]))

