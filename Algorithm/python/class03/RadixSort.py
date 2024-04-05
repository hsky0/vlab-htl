
import sys
sys.path.append("/home/ubuntu/htl/Algorithm/python/include/")
sys.path.append("/home/ubuntu/htl/Algorithm/python/class02/")

from globalFunc import randomArray, selectSort
from Validator import validator

def maxbits(arr):
    maxval = - (2 << 63)
    for i in range(len(arr)):
        maxval = arr[i] if arr[i] > maxval else maxval
    res = 0
    while maxval != 0:
        res += 1
        maxval = maxval // 10
    return res

def getDigit(value, d):
    while d > 1:
        value = value // 10
        d -= 1
    res = value % 10
    return res

def radixSort(arr):
    if arr == None or len(arr) < 2:
        return
    radixSort_process(arr, 0, len(arr) - 1, maxbits(arr))

def radixSort_process(arr, L, R, digit):
    radix = 10
    bucket = [0 for _ in range(R - L + 1)]
    for d in range(1, digit + 1):
        count = [0 for _ in range(radix)]
        for i in range(L, R + 1):
            j = getDigit(arr[i], d)
            count[j] += 1
        for i in range(1, radix):
            count[i] += count[i - 1]
        for i in range(R, L - 1, -1):
            j = getDigit(arr[i], d)
            bucket[count[j] - 1] = arr[i]
            count[j] -= 1
        for i in range(len(arr)):
            arr[i + L] = bucket[i]
        

def main():
    n = 10
    V = 100
    testTimes = 1000
    arr = randomArray(n, V)
    print(arr)
    selectSort(arr)
    print(arr)
    radixSort(arr)
    print(arr)
    validator(selectSort, radixSort, 100, 1000, testTimes)

def test():
    for i in range(10, -1, -1):
        print(i)

main()
