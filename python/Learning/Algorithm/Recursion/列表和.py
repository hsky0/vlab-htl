


def sumRecursion(arr):
    if len(arr) == 0:
        return 0
    else:
        return arr[0] + sumRecursion(arr[1:])


n = 10
arr = [x for x in range(1, n + 1)]

print(sumRecursion(arr))