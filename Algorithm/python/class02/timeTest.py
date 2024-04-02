from datetime import datetime
from time import time


t1 = time()             # 返回当前时间的时间戳（1970纪元后经过的浮点秒数） 


for _ in range(100000000):
    pass


t2 = time()

print(t2 - t1)