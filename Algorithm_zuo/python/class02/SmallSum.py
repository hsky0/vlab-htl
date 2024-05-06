from random import random

def randomArray(n, V):
    return [(int)(random() * V + 1) for _ in range(n)]

def copyArray(arr):
    return [x for x in arr]

def sameArray(arr1, arr2):
    return arr1 == arr2

def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]


def smallSum(arr):
    if arr == None or len(arr) < 2:
        return 0
    return process(arr, 0, len(arr) - 1)

def process(arr, L, R):
    if L == R:
        return 0
    mid = L + ((R - L) >> 1)
    return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R)

def merge(arr, L, M, R):
    i = 0
    help =  [0 for _ in range(R - L + 1)]
    p1 = L
    p2 = M + 1
    res = 0
    while p1 <= M and p2 <= R:
        if arr[p1] < arr[p2]:
            res += (R - p2 + 1) * arr[p1]
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
        arr[i + L] = help[i]
    return res

def main():
    n = 5
    V = 10
    arr = randomArray(n, V)
    print(arr)
    res = smallSum(arr)
    print(res)

main()

