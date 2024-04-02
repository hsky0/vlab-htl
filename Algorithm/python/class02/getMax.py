import sys

sys.path.append("/home/ubuntu/htl/Algorithm/python/include/")
from globalFunc import randomArray


def getMax(arr):
    return process(arr, 0, len(arr) - 1)

# 使用递归方法找到数组arr[L, R]的最大值
def process(arr, L, R):
    if L == R:
        return arr[L]       # base case
    
    mid = L + ((R - L) >> 1)
    leftMax = process(arr, L, mid)
    rightMax = process(arr, mid + 1, R)
    return max(leftMax, rightMax)

def main():
    a = randomArray(10, 23)
    print(a)
    print(getMax(a))

main()
