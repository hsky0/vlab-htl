from random import random
from time import time

def qsort(arr):
    if len(arr) < 2:
        return arr 
    else:
        pivot = arr[0]
        less = [x for x in arr[1:] if x <= pivot]
        greater = [x for x in arr[1:] if x > pivot]
        return qsort(less) + [pivot] + qsort(greater)


n = 1000
a = [(int)(random() * n) for _ in range(n)]
#print(a)
start = time()
b = qsort(a)
end = time()
#print(b)
print(end - start)