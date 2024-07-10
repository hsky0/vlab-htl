
"""Reducing a Sequence to a Value"""

from operator import add, mul, truediv

def reduce(f, s, initial):
    """Combine elements of a pairwise using f, starting with initial
    E.g., reduce(mul, [2, 4, 8], 1) is equivalent to mul(mul(mul(1, 2), 4), 8).
    
    >>> reduce(mul, [2, 4, 8], 1)
    64
    """
    for x in s:
        initial = f(initial, x)
    return initial


def reduce2(f, s, initial):

    if not s:
        return initial
    else:
        first, rest = s[0], s[1:]
        return reduce(f, rest, f(initial, first))
    
def divide_all(n, ds):
    try:
        return reduce(truediv, ds, n)
    except ZeroDivisionError:
        return float('inf')