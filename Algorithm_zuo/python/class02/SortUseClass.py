import random
from time import time


class Sort:

    N = 100                 #数组最大长度
    V = 1000                #数组元素的最大值
    testTimes = 1000      #测试次数

    def __init__(self):
        pass

    def validator(self):
        print("测试开始...")
        startTime = time()
        for i in range(self.testTimes):
            n = (int)(random.random() * self.N)

            arr = self.randomArray(n, self.V)     #参数随机数组
            arr1 = self.copyArray(arr)
            arr2 = self.copyArray(arr)
            arr3 = self.copyArray(arr)

            # 排序
            self.selectSort(arr1)
            self.bubbleSort(arr2)
            self.insertSort(arr3)
            # 测试
            if not self.sameArray(arr1, arr2) or not self.sameArray(arr1, arr3):
                print("出现错误！")
        stoptime = time()
        timeUse = stoptime - startTime
        print("测试结束")
        print(f"timeUse = {timeUse}")
    def randomArray(self, n, V):
        # 使用列表推导式
        arr = [(int)(random.random() * V) + 1 for _ in range(n)]
        return arr 


    def copyArray(self,arr):
        ans = [arr[i] for i in range(len(arr))]
        return ans

    def sameArray(self, arr1, arr2):
        return True if arr1 == arr2 else False
        
    def swap(self, arr, i, j):
        arr[i], arr[j] = arr[j], arr[i]

    # 选择排序
    def selectSort(self, arr):
        for i in range(len(arr) - 1):
            minIndex = i
            for j in range(i + 1, len(arr)):
                if arr[j] < arr[minIndex]:
                    minIndex = j
            self.swap(arr, i, minIndex)

    # 冒泡排序
    def bubbleSort(self, arr):
        for end in range(len(arr), 1, -1):
            for j in range(0, end - 1):
                if arr[j] > arr[j + 1]:
                    self.swap(arr, j, j + 1)

    # 插入排序
    def insertSort(self, arr):
        for i in range(1, len(arr)):
            for j in range(i, 0, -1):
                if arr[j] < arr[j - 1]:
                    self.swap(arr, j, j - 1)


sort = Sort()
sort.validator()