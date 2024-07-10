from random import random

"""如果找到则返回第一个索引，如果没有找到则返回-1"""
def BinarySearchRecursion(arr, target):
    def help(arr, target, l, r):
        if l > r:
            return -1
        mid = ((r - l) >> 1) + l
        if arr[mid] > target:
            help(arr, target, l, mid - 1)
        elif arr[mid] < target:
            help(arr, target, mid + 1, r)
        else:
            return mid
    return help(arr, target, 0, len(arr))


def BinarySearch(arr, target):
    left, right = 0, len(arr) - 1
    
    while left <= right:
        mid = ((right - left) >> 1) + left
        if arr[mid] == target:
            return mid
        elif arr[mid] > target:
            right = mid - 1
        else:
            left = mid + 1

#a = [(int)(random() * 10) for _ in range(1, 11)]
a = [x for x in range(10)]
print(len(a))
print(a)
print(BinarySearchRecursion(a, 5))
print(BinarySearch(a, 5))
