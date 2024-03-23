def falling(n, k):
    """Compute the falling factorial of n to depth k.

    >>> falling(6, 3)  # 6 * 5 * 4
    120
    >>> falling(4, 3)  # 4 * 3 * 2
    24
    >>> falling(4, 1)  # 4
    4
    >>> falling(4, 0)
    1
    """
    "*** YOUR CODE HERE ***"
    result = 1
    if k != 0:
        while k > 0:
            result *= n
            k -= 1
            n -= 1
        return result
    else:
        return 1



def sum_digits(y):
    """Sum all the digits of y.

    >>> sum_digits(10) # 1 + 0 = 1
    1
    >>> sum_digits(4224) # 4 + 2 + 2 + 4 = 12
    12
    >>> sum_digits(1234567890)
    45
    >>> a = sum_digits(123) # make sure that you are using return rather than print
    >>> a
    6
    """
    "*** YOUR CODE HERE ***"
    result = 0
    temp = y
    quotient = 1
    remainder = 0
    while quotient != 0:
        quotient = temp // 10
        remainder = temp % 10
        result += remainder
        temp = quotient

    return result

def double_eights(n):
    """Return true if n has two eights in a row.
    >>> double_eights(8)
    False
    >>> double_eights(88)
    True
    >>> double_eights(2882)
    True
    >>> double_eights(880088)
    True
    >>> double_eights(12345)
    False
    >>> double_eights(80808080)
    False
    """
    "*** YOUR CODE HERE ***"

    "my code"
    """
    temp = n
    quotient = 1
    remainder = 0
    isadjacentnum = 0
    while quotient != 0:
        quotient = temp // 10
        remainder = temp % 10
        if remainder == 8:
            isadjacentnum += 1
            if isadjacentnum == 2:
                return True
        else:
            isadjacentnum = 0
        temp = quotient

    if isadjacentnum == 2:
        return True
    else:
        return False
    """

    "Internet code from 'PKUFlyingPig'"
    if n // 10 == 0:
        return False

    while n:
        last = n % 10
        n = n // 10
        if last == 8 and (n % 10):
            return True
    
    return False
