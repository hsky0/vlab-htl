
"""Generalization"""

def make_adder(n):
    """Return a function that takes a argment K and return K + N.

    >>> add_three = make_adder(3)
    >>> add_three(4)
    7
    """

    def adder(k):
        return k + n
    return adder


add_three = make_adder(3)

print(add_three(5))