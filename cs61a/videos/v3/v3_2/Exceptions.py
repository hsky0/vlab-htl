
"""Handing Errors"""

"""
    Raise Statement: 
    assert <condition>, <string description> 
    Raise <expresion>
    Try Statements:
        try:
            <try suite>
        except <exception class> as <name>:
            <except suite>
"""




def invert(x):
    y = 1 / x
    print('Never printed if x is 0')
    return y


def invert_safe(x):
    try:
        return invert(x)
    except ZeroDivisionError as e:
        print('handled', e)
        return 0
    






