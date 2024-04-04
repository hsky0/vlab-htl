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

def selectSort(arr):
    for i in range(len(arr) - 1):
        minIndex = i
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[minIndex]:
                minIndex = j
        swap(arr, i, minIndex)


# 冒泡排序
def bubbleSort(arr):
    for end in range(len(arr), 1, -1):
        for j in range(0, end - 1):
            if arr[j] > arr[j + 1]:
                swap(arr, j, j + 1)

# 插入排序
def insertSort(arr):
    for i in range(1, len(arr)):
        for j in range(i, 0, -1):
            if arr[j] < arr[j - 1]:
                swap(arr, j, j - 1)

def mergeSort(arr):
    if arr == None or len(arr) < 2:
        return
    process(arr, 0, len(arr) - 1)


def process(arr, L, R):
    if L == R:      # base case
        return
    mid = L + ((R - L) >> 1)
    process(arr, L, mid)
    process(arr, mid + 1, R)
    merge(arr, L, mid, R)

def merge(arr, L, M, R):
    help = [0 for _ in range(R - L + 1)]
    i = 0
    p1 = L
    p2 = M + 1
    while p1 <= M and p2 <= R:
        if arr[p1] <= arr[p2]:
            help[i] = arr[p1]
            i, p1 = i + 1, p1 + 1
        else:
            help[i] = arr[p2]
            i, p2 = i + 1, p2 + 1

    while p1 <= M:
        help[i] = arr[p1]
        i, p1 = i + 1, p1 + 1

    while p2 <= R:
        help[i] = arr[p2]
        i, p2 = i + 1, p2 + 1
    
    for i in range(len(help)):
        arr[L + i] = help[i]
