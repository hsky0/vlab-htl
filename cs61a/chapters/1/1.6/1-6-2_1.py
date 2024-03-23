

"""Calculate the golden ratio"""


def improve(update, close, guess=1):
    """The Global frame, guess the return value(The golden ratio)"""
    while not close(guess):
        guess = update(guess)
    
    return guess


def golden_update(guess):
    """The calculation formula of golden ratio"""
    return 1 / guess + 1


def square_close_to_successor(guess):
    """The properity of golden ratio"""
    return approx_eq(guess * guess, guess + 1)


def approx_eq(x, y, tolerance = 1e-8):
    return abs(x - y) < tolerance


a = improve(golden_update, square_close_to_successor)
print(a)