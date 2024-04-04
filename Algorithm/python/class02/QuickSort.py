from random import random

from globalFunc import swap, selectSort, bubbleSort, insertSort, mergeSort
from Validator import validator



def quickSort(arr):
    if arr == None or len(arr) < 2:  
        return
    process(arr, 0, len(arr) - 1)

def process(arr, L, R):
   if(L < R):
       swap(arr, L + (int)(random() * (R - L + 1)), R)
       mid = L + ((R - L) >> 1)
       p = partition(arr, L, R)
       process(arr, L, p[0] - 1)
       process(arr, p[1] + 1, R)
    
def partition(arr, L, R):
    leftptr = L - 1         # L表示当前值的索引
    rightptr = R 
    while L < rightptr:
        if arr[L] < arr[R]:
            swap(arr, leftptr + 1, L)
            leftptr, L = leftptr + 1, L  + 1
        elif arr[L] > arr[R]:
            swap(arr, rightptr - 1, L)
            rightptr -= 1
        else:
            L += 1
    swap(arr, rightptr, R)
    return [leftptr + 1, rightptr]

def main():
    N = 100
    V = 1000
    testTimes = 10000
    validator(selectSort, quickSort, N, V, testTimes)
    validator(bubbleSort, quickSort, N, V, testTimes)
    validator(insertSort, quickSort, N, V, testTimes)
    validator(mergeSort, quickSort, N, V, testTimes)
    validator(list.sort, quickSort, N, V, testTimes)

main()
