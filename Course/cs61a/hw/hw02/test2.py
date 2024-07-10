

def zero(f):
    return lambda x: x


def f(x):
    return 1

def add():
    print("add func")


a = zero(add)
print(a)
print(zero)

print(a(3))