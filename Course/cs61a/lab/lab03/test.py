

def crust():
    print("70km")
    def mantle():
        print("2900km")
        def core():
            print("3500km")
            return mantle()
        return core
    return mantle()
    


def pascal(row, column):

    """
    >>> pascal(0, 0)
    1
    >>> pascal(0, 5)
    0
    >>> pascal(3, 2)
    3
    """

    if column == 0:
        return 1
    if row == column:
        return 1
    elif row < column:
        return 0
    else:
        return pascal(row - 1, column) + pascal(row - 1, column - 1)