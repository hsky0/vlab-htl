from random import random

def randomArray(n, V):
    return [(int)(random() * V + 1) for _ in range(n)]

def copyArray(arr):
    return [x for x in arr]

def sameArray(arr1, arr2):
    return arr1 == arr2

def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]


# 荷兰问题，版本一：给定一个数num，将数组arr中所有小于等于num的数放在左边，大于的全放在右边
def theNetherlandsIssue_v1(arr, num):
    if arr == None or len(arr) < 2:
        return
    i = 0
    leftptr = -1
    while i < len(arr):
        if arr[i] <= num:
            swap(arr, leftptr + 1, i)
            leftptr, i = leftptr + 1, i + 1
        else:
            i += 1
    

# 荷兰问题，版本二：给定一个数num，将数组arr中所有小于num的数放在左边，等于的放在中间，大于的全放在右边
def theNetherlandsIssue_v2(arr, num):
    if arr == None or len(arr) < 2:
        return
    i = 0
    leftptr  = -1
    rightptr = len(arr)
    while i < rightptr:
        if arr[i] < num:
            swap(arr, leftptr + 1, i)
            leftptr, i = leftptr + 1, i + 1
        elif arr[i] > num:
            swap(arr, rightptr - 1, i)
            rightptr -= 1
        else:
            i += 1

def main():
    n = 10
    V = 8
    for _ in range(5):
        arr = randomArray(n, V)
        print(arr)
        theNetherlandsIssue_v2(arr, 5)
        print(arr)
        print("\n")

main()