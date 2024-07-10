
from operator import floordiv, mod 

def divide_exact(n, d):
    """Return the quotient and remainder of dividing N by D.
    >>> q, r = divide_exact(2024, 10)
    >>> q
    202
    >>> r
    4
    """
    return floordiv(n, d), mod(n, d)



