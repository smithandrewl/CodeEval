def primes(max):
    primes = [2]

    for number in range(3, max):
        isPrime = True

        for prime in primes:
            if number % prime == 0:
                isPrime = False
                break

        if isPrime:
            primes.append(number)
            yield number

def primePalindromes(max):
    for prime in primes(max):
        if str(prime) == str(prime)[::-1]:
            yield prime

print(max(primePalindromes(1000)))

