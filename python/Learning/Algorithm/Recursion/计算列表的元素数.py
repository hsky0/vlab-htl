
def calListNumber(arr):
    if arr == []:
        return 0
    else:
        return 1 + calListNumber(arr[1:])
    

def calListNumberNoRecursion(arr):
    count = 0
    while arr != []:
        count += 1
        arr = arr[1:]
    return count

n = 10
arr = [x for x in range(1, n + 1)]
print(calListNumber(arr))
print(calListNumberNoRecursion(arr))