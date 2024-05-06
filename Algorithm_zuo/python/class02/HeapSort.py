

from globalFunc import swap, randomArray, selectSort
from Validator import validator

def heapSort(arr):
    if arr == None or len(arr) < 2:
        return
    
    # for i in range(len(arr)):
    #     heapInsert(arr, i)

    for i in range(len(arr) - 1, -1, -1):
        heapify(arr, i, len(arr))

    heapSize = len(arr)
    swap(arr, 0, heapSize - 1)
    heapSize -= 1
    while heapSize > 0:
        heapify(arr, 0, heapSize)
        swap(arr, 0, heapSize - 1)
        heapSize -= 1


def heapInsert(arr, index):
    while arr[index] > arr[(int)((index - 1) / 2)]:
        swap(arr, index, (int)((index - 1) / 2))
        index = (int)((index - 1) / 2)

def heapify(arr, index, heapSize):
    left = index * 2 + 1
    while left < heapSize:
        largest = left + 1 if left + 1 < heapSize and arr[left + 1] > arr[left] else left 
        largest = largest if arr[largest] > arr[index] else index
        if largest == index:
            break
        swap(arr, largest, index)
        index = largest
        left = index * 2 + 1


def main():
    n = 10
    V = 10
    testTimes = 1000
    arr = randomArray(n, V)
    print(arr)
    heapSort(arr)
    print(arr)
    validator(selectSort, heapSort, 100, 1000, testTimes)

main() 