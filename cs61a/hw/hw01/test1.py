def if_function(condition, true_result, false_result):
    """Return true_result if condition is a true value, and
    false_result otherwise.

    >>> if_function(True, 2, 3)
    2
    >>> if_function(False, 2, 3)
    3
    >>> if_function(3==2, 3+2, 3-2)
    1
    >>> if_function(3>2, 3+2, 3-2)
    5
    """
    if condition:
        return true_result
    else:
        return false_result
    
def test(condition, true_result, false_result):

    return 1

def with_if_function():
    """
    >>> result = with_if_function()
    42
    47
    >>> print(result)
    None
    """
    # return if_function(cond(), true_func(), false_func())
    return test(cond(), true_func(), false_func())



def cond():
    "*** YOUR CODE HERE ***"
    return False

def true_func():
    "*** YOUR CODE HERE ***"
    print(4243)

def false_func():
    "*** YOUR CODE HERE ***"
    print(47)

# def cond():

#     try:
#         global x
#     except NameError:
#         x=1
#     if x==1:
#         return True
#     else:
#         return False

# def true_func():

#     if x==1:
#         return (1)
#     else:
#         return (0)

# def false_func():

#     global x
#     x=2
#     if x==1:
#         return (1)
#     else:
#         return (0)


result = with_if_function()