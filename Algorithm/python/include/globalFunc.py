from random import random

# 产生一个随机数组，数组的长度为n，数组元素的最大值为V
def randomArray(n, V):
    return [(int)(random() * V + 1) for _ in range(n)]


def copyArray(arr):
    return [x for x in arr]

def sameArray(arr1, arr2):
    return True if arr1 == arr2 else False

def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]

