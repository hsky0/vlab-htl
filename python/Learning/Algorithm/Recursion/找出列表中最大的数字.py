
from random import random

def searchMaxElementInList(arr):
    if len(arr) == 2:
        return arr[0] if arr[0] > arr[1] else arr[1]
    sub_max = searchMaxElementInList(arr[1:])
    return arr[0] if arr[0] > sub_max else sub_max

a = [(int)(random() * 10) for _ in range(1, 11)]
print(a)
print(searchMaxElementInList(a))