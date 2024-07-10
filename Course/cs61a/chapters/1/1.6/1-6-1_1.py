
"""Section 1.6.1: Functions as Arguments"""

def sum_naturals(n):
    """Sum the number from 1 to N
    >>> sum_naturals(5)
    15
    >>> sum_naturals(100)
    5050
    """
    total, k = 0, 1
    while k <= n:
        total, k = total + k, k + 1
    
    return total


def sum_cubes(n):
    """Sum the cubes of number from 1 to N
    >>> sum_cubes(100)
    25502500
    """
    total, k = 0, 1
    while k <= n:
        total, k = total + k**3, k + 1
    
    return total



def pi_sum(n):
    """Calculate the value of pi using summation
    >>> pi_sum(100)
    3.1365926848388144
    """
    total, k = 0, 1
    while k <= n:
        total, k = total + 8 / ((4 * k - 3) * (4 * k - 1)), k + 1
    
    return total


def summation(n, term):
    """Take function as argment to summation"""
    total, k = 0, 1
    while k <= n:
        total, k = total + term(k), k + 1
    
    return total


def identity(x):
    return x

def square(x):
    return x * x

def cube(x):
    return x * x * x

def pi_term(x):
    return 8 / ((4 * x - 3) * (4 * x - 1))

def sum_naturals2(n):
    """Using the Function as argment to calculate summation of naturals from 1 to N
    >>> sum_naturals2(100)
    5050
    """
    return summation(n, identity)


def sum_squares2(n):
    """Using the Function as argment to calculate summation of naturals' square
    >>> sum_squares2(4)
    30
    """
    return summation(n, square)

def sum_cubes2(n):
    """Using the Function as argment to calculate summation of naturals' cube
    >>> sum_cubes2(100)
    25502500
    """
    return summation(n, cube)


def pi_sum2(n):
    """Using the Function as argment to calculate the value of pi
    >>> pi_sum2(1e6)
    3.141592153589902
    """
    return summation(n, pi_term)


