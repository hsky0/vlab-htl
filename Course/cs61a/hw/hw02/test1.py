

def square(n):
    return n ** 2

y = lambda x: square(x)


a = y
b = square(5)



print(a(5))

print(b)