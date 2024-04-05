# 学习数据结构和算法

来源：https://www.bilibili.com/video/BV13g41157hK/?spm_id_from=333.999.0.0&vd_source=d6bcbd2fac9e9b84fc22095c62ddbe80
github：https://github.com/algorithmzuo

## Linux环境配置java开发环境

### 安装java
- sudo apt install openjdk-11-jdk(安装OpenJDK 11软件包)
- java --version(检查是否安装成功)
- sudo update-alternatives --config java(修改默认版本)

### 配置环境变量
- 找到java的安装位置：sudo update-alternatives --config java
  - /usr/lib/jvm/java-11-openjdk-amd64/bin/java
- 找到安装路径后，打开/etc/environment文件：sudo vim /etc/enviroment
- 在该文件末尾加上：JAVA_HOME = "path", path为刚才查找到的路径
  - 例如：JAVA_HOME = "/usr/lib/jvm/java-11-openjdk-amd64"
  - 注意：如果有多个路径，选择一个即可，并且不需要/bin/java
- 使该文件生效：source /etc/environment

### 卸载java
- sudo apt remove openjdk-11-jdk

### 运行java文件
- 创建java文件，例如：demo1.java
- 编写代码
- 在bash中输入命令：javac demo1.java，该命令将会产生一个.class文件
- 运行代码：java demo1

### Makefile文件编写
- 来源：https://www.bilibili.com/video/BV188411L7d2/?spm_id_from=333.337.search-card.all.click&vd_source=d6bcbd2fac9e9b84fc22095c62ddbe80
- 该视频简要讲述了makefile文件的编写

- 文件注释使用#号

#### 编写步骤
- 描述：加入现在有main.c, printhello.c factorial.c 三个文件
- 版本一:
  ```makefile
  hello: main.c printhello.c factorial.c
    gcc -o hello main.c printhello.c factorial.c
  ```
- 版本二：
  ```makefile
  CXX     = gcc
  TARGET  = hello
  OBJ     = main.o printhello.o factorial.o
  $(TARGET): $(OBJ)
    $(CXX) -o $(TARGET) $(OBJ)
  
  main.o: main.c
    $(CXX) -c main.c
  printhello.o: printhello.c
    $(CXX) -c printhello.c
  factorial.o: factorial.c
  $(CXX) -c factorial.c

  ```

- 版本三：
  ```makefile
  CXX     = gcc
  TARGET  = hello
  OBJ     = main.o printhello.o factorial.o
  CXXFLAGS = -c -Wall
  $(TARGET): $(OBJ)
    $(CXX) -o $@ $^
  
  %.o: %.c
    $(CXX) $(CXXFLAGS) $< -o $@

  .PHONY: clean
  clean:  
    rm -f *.o $(TARGET)
  ```

  - 版本四：
  ```makefile
  CXX     = gcc
  TARGET  = hello
  SRC     = $(wildcard *.c)
  OBJ     = $(patsubst %.c, %.o, $(SRC))
  CXXFLAGS = -c -Wall
  $(TARGET): $(OBJ)
    $(CXX) -o $@ $^
  
  %.o: %.c
    $(CXX) $(CXXFLAGS) $< -o $@

  .PHONY: clean
  clean:  
    rm -f *.o $(TARGET)
  ```

## 数据结构与算法
### 选择排序
描述：从数组中选择一个最小值放在数组的第一个位置，然后再从剩下的元素中选择最小值放在第二个位置，以此类推，直到最后一个元素
- 循环第一次寻找第一个元素到最后一个元素的最小值，放在第一个元素的位置
- 循环第二次寻找第二个元素到最后一个元素的最小值，放在第二个元素的位置
- 以此内推，直至排序完成


### 冒泡排序
描述：从第一个元素开始，相邻两个元素相互比较，较大的元素往右移动（两两交换），直到倒数第二个元素
- 循环一次将选出一个最大值放在数组末尾
- 第一次循环从第一个元素到倒数第二个元素
- 第二次循环从第一个元素到倒数第三个元素
- ...


### 异或
描述：在一个整形数组中，已知
1. 只有一种数出现了奇数次，其他的所有数都出现了偶数次，怎么找到出现了奇数次的数？
2. 有两种数出现了奇数次，其他的所有数都出现了偶数次，怎么找到这两种数？
要求：时间复杂度O(n), 空间复杂度O(1)

### 插入排序
描述：从第一个元素开始，从该元素往前查找，遇到比自己大的就交换（相邻交换，每次查找一直到第一个元素才结束），否则就开始下一个
- 部分有序-->整体有序


### 二分法
1. 在一个有序数组中，找某个数是否存在
   1. 遍历：时间复杂度O(n)
   2. 二分法：时间复杂度O(nlog(n))
2. 在一个有序数组中，找>=某个数最左侧的位置
3. 局部最小值问题 
   描述：在一个无序数组中，任何两个相邻数一定不相等。
   $a_0 < a_1, a_{n-1} < a_{n-2}, a_{i-1} < a_i < a_{i + 1}$三种情况均为局部最小值，求一个即可，时间复杂度小于O(n)



### 对数器
来源：视频p3，时间：1：59：00
- 构造对数器的步骤：
  - 随机数数组的产生，数组长度随机，数组中的元素随机
    - random函数产生随机的，规定数组的长度的最大值、最小值和测试次数
    - 使用random产生数组的元素
  - 比较不同的算法
    - 构造复制数组的函数
  - 得出结果


### 用递归方法找一个数组中的最大值
- master公式的使用：
  $T(N) = a * T(\frac{N}{b}) + O(N^d)$
  - T(N)指母问题的数据量，规模是N
  - 子问题的规模是N/b的规模，a是子问题被调用的次数
  - 最后一项表示除了调用之外的时间复杂度

- arr[L..R]上返回z最大值 
  - 求中点的索引：mid = L + ((R - L) >> 1)
  - 注意，不要使用：mid = (L + R) / 2，因为如果数组很长，(L + R)可能会溢出，导致计算出的mid不正确
  - $log_b^a < d ---> O(N^d)$
  - $log_b^a > d ---> O(N^{log_b^a})$
  - $log_b^a = d ---> O(N^d * log^N)$


### 归并排序（重要）
- 描述：先让左侧部分排好序，再让右侧部分排好序，最后再合并怕排序
  
#### 归并排序的扩展
- 1.小和问题：在一个数组中，每一个数的左边比当前数小的数累加起来，叫做这个数组的小和
- 2.逆序对问题：在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印该数组中所有的逆序对

### 快排
- 问题一：
  给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。要求额外空间复杂度O(1)，时间复杂度为O(N)

- 问题二：
  给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边。要求额外空间复杂度O(1)，时间复杂度为O(N)
 
#### 快排1.0
- 描述：划分值为数组的最后一个数，对数组进行**问题一**处理，然后递归
  
#### 快排2.0
- 描述：划分值为数组的最后一个数，对数组进行**问题二**处理，然后递归

#### 快排3.0
- 描述：**随机**选择一个数组元素作为划分值，对数组进行**问题二**处理，然后递归




### 堆
#### 堆结构
- 完全二叉树结构
- 数组从零出发的一段可以形成完全二叉树
- 在一个数组arr中，下标i对应的左孩子的下标为2*i+1，右孩子的下标为2*i+2，其父的下标为(i - 1)/2
- 分类：
  - 大根堆：子树上的最大值为头节点
  - 小根堆：子树上的最小值为头结点

#### 构建堆的步骤
- heapinsert：往上走
  - 某个数出现下在数组的index位置，判断其与父结点的值谁大谁小，然后决定是否要交换
- heapify：往下走
  - 某个数出现下在数组的index位置，判断其与左孩子和右孩子的值谁大谁小，然后决定是否要交换


#### 堆排序的扩展问题
- 描述：已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素的移动距离不超过k，并且k相对于数组来说较小。请选择一个合适是排序算法针对这个数据进行排序

### 比较器
- 其实质就是重载比较运算符
- 比较器可以很好的应用在特殊标准的排序上
- 比较器可以很好的应用在根据特殊标准排序的结构上


- 规则：
  - 返回负数的时候，第一个参数排在前面
  - 返回正数的时候，第二个参数排在前面
  - 返回0的时候，谁在前面无所谓


### 不基于比较的排序
#### 基数排序
- 别名：桶排序
- 描述：基于每个元素在每个权重位上的数值来排序


### 排序算法的稳定性与总结
- 稳定性：同样值的个体之间，如果不因为排序而改变相对次序，这个排序是有稳定性的，否则就没有
- 不稳定的排序：
  - 选择排序
  - 快速排序
  - 堆排序
- 具有稳定性的排序
  - 冒泡排序
  - 插入排序
  - 归并排序
  - 一切桶排序思想下的排序

- 时间复杂度和空间复杂度（基于比较的排序）
  |    |时间|空间|稳定性|
  |:-   |:-:   |:-:  |:-:|
  |选择|O(N^2^)|O(1)|$\times$|
  |冒泡|O(N^2^)|O(1)|$\surd$|
  |插入|O(N^2^)|O(1)|$\surd$|
  |归并|O(N*logN)|O(N)|$\surd$|
  |快排|O(N*logN)|O(logN)|$\times$|
  |堆排|O(N*logN)|O(1)|$\times$|



- 一般来说会选择快速排序，实验上得出，其排序所用时间最短
- 如果有空间的限制，可考虑使用快排
- 结论：
  - 1.目前没找到时间复杂度为O(N*logN)以下的基于比较的排序算法
  - 2.目前也没有找到时间复杂度为O(N*logN)，空间复杂度为O(N)，并且还能做到稳定
  

- 常见的坑
- 工程上的改进
  - 充分利用O(N*logN)和O(N^2^)排序各自的优势
  - 稳定性的考虑
  

### 哈希表与有序表


#### 链表
 - 