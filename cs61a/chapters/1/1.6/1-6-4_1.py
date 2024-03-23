

"""Function as Return Values"""

def compose1(f, g): 
    def h(x): 
        return f(g(x))
    
    return h

def compose2(f, g):
    def h(x):
        return f(x)*g(x)
    
    return h

def square(x): 
    return x * x

def identity(x):
    return x

def cube(x):
    return x * x * x

