

"""Implemention a Function"""


def remove(n, digit):
    """Return all digit of non-negative N
    that are not DIGIT, for some 
    non-negative DIGIT less than 10.
    >>> remove(231, 3)
    21
    >>> remove(243132, 2)
    4313
    """

    Kept, digits = 0, 0

    while n > 0:
        n, last = n // 10, n % 10
        if last != digit:
            Kept = Kept + last * pow(10, digits)
            digits = digits + 1

    return Kept

def remove2(n, digit):
    """Return all digit of non-negative N
    that are not DIGIT, for some 
    non-negative DIGIT less than 10.
    >>> remove(231, 3)
    21
    >>> remove(243132, 2)
    4313
    """

    Kept, digits = 0, 0

    while n > 0:
        n, last = n // 10, n % 10
        if last != digit:
            Kept = Kept / 10+ last
            digits = digits + 1

    return round(Kept * 10 ** (digits - 1))