def hailstone(x):
    """Print the hailstone sequence starting at x and return its
    length.

    >>> a = hailstone(10)
    10
    5
    16
    8
    4
    2
    1
    >>> a
    7
    """
    "*** YOUR CODE HERE ***"
    count = 1
    while x != 1:
        print(x)
        if x % 2 == 0:
            x = x // 2
            count += 1
        else:
            x = x * 3
            x = x + 1
            count += 1
    
    print(1)
    return count


a = hailstone(27)
print("a =", a)
