import random
from time import time
import sys

sys.path.append("/home/ubuntu/htl/Algorithm/python/include/")
sys.setrecursionlimit(10000)

from globalFunc import randomArray, sameArray, copyArray, swap
from MergeSort import mergeSort

def validator():
    N = 100                 #数组最大长度
    V = 1000                #数组元素的最大值
    testTimes = 10000     #测试次数
    print("测试开始...")
    startTime = time()      
    for i in range(testTimes):
        #n = (int)(random.random() * N)
        n = N
        arr = randomArray(n, V)     #参数随机数组
        arr1 = copyArray(arr)
        arr2 = copyArray(arr)
        arr3 = copyArray(arr)
        arr4 = copyArray(arr)

        # 排序
        selectSort(arr1)
        bubbleSort(arr2)
        insertSort(arr3)
        mergeSort(arr4)                
        # 测试
        if not sameArray(arr1, arr2) or not sameArray(arr1, arr3) or not sameArray(arr1, arr4):
            print("出现错误！")
    stopTime = time()
    print("测试结束")
    print("timeUse = {0}s".format(stopTime - startTime))

# 选择排序
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
    



validator()


