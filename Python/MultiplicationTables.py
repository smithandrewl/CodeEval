line = ""

for row in range(1, 13):

    for col in range(1, 13):
        line += "{:>4}".format(row * col)

    print(line.lstrip())

    line = ""
