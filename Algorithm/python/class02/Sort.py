import random
from time import time
def validator():
    N = 100                 #数组最大长度
    V = 1000                #数组元素的最大值
    testTimes = 10000     #测试次数
    print("测试开始...")
    startTime = time()      
    for i in range(testTimes):
        n = (int)(random.random() * N)

        arr = randomArray(n, V)     #参数随机数组
        arr1 = copyArray(arr)
        arr2 = copyArray(arr)
        arr3 = copyArray(arr)

        # 排序
        selectSort(arr1)
        bubbleSort(arr2)
        insertSort(arr3)
        # 测试
        if not sameArray(arr1, arr2) or not sameArray(arr1, arr3):
            print("出现错误！")
    stopTime = time()
    print("测试结束")
    print("timeUse = {0}s".format(stopTime - startTime))

def randomArray(n, V):
    # 使用列表推导式
    arr = [(int)(random.random() * V) + 1 for _ in range(n)]
    return arr 


def copyArray(arr):
    ans = [arr[i] for i in range(len(arr))]
    return ans

def sameArray(arr1, arr2):
    return True if arr1 == arr2 else False
    
def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]

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

# a = randomArray(12, 8)
# b = copyArray(a)
# c = copyArray(a)
# d = copyArray(a)
# selectSort(b)
# bubbleSort(c)
# insertSort(d)
# print(a)
# print(b)
# print(c)
# print(d)

