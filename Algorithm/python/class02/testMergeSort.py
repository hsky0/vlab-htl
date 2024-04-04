import random
from time import time
import sys

sys.path.append("/home/ubuntu/htl/Algorithm/python/include/")
sys.setrecursionlimit(10000)

from globalFunc import randomArray, sameArray, copyArray, swap
from MergeSort import mergeSort

# 选择排序
def selectSort(arr):
    for i in range(len(arr) - 1):
        minIndex = i
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[minIndex]:
                minIndex = j
        swap(arr, i, minIndex)

def main():
    N = 100
    V = 1000

    testTimes = 100000
    print("测试开始...")
    startTime = time() 
    for i in range(testTimes):
        #n = (int)(random.random() * N)
        n = N
        arr = randomArray(n, V)
        arr1 = copyArray(arr)
        arr2 = copyArray(arr)
        selectSort(arr1)
        mergeSort(arr2)
        if not sameArray(arr1, arr2):
            print("出现错误！")

    stopTime = time()
    timeUse = stopTime - startTime
    print("测试结束")
    print(f"timeUse = {timeUse}")

main()