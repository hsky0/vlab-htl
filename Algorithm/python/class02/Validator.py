from random import random
from time import time


from globalFunc import randomArray, sameArray, copyArray

def validator(func1, func2, N, V, testTimes, fixLength=True):
    
    print("测试开始...")
    startTime = time()
    for _ in range(testTimes):
        n = N if fixLength else (int)(random() * N)
        arr = randomArray(n, V)
        arr1 = copyArray(arr)
        arr2 = copyArray(arr)

        func1(arr1)
        func2(arr2)
        
        if not sameArray(arr1, arr2):
            print("出现错误！")
            break
    stopTime = time()
    timeUse = stopTime - startTime
    print("测试结束")
    print(f"timeUse = {timeUse}")


