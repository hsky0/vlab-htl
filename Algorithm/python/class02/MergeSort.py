def mergeSort(arr):
    return process(arr, 0, len(arr) - 1)


def process(arr, L, R):
    if L == R:      # base case
        return
    mid = L + ((R - L) >> 1)
    process(arr, L, mid)
    process(arr, mid + 1, R)
    merge(arr, L, mid, R)

def merge(arr, L, M, R):
    help = [0 for _ in range(R - L + 1)]
    i = 0
    p1 = L
    p2 = M + 1
    while p1 <= M and p2 <= R:
        if arr[p1] <= arr[p2]:
            help[i] = arr[p1]
            i, p1 = i + 1, p1 + 1
        else:
            help[i] = arr[p2]
            i, p2 = i + 1, p2 + 1

    while p1 <= M:
        help[i] = arr[p1]
        i, p1 = i + 1, p1 + 1

    while p2 <= R:
        help[i] = arr[p2]
        i, p2 = i + 1, p2 + 1
    
    for i in range(len(help)):
        arr[L + i] = help[i]

    