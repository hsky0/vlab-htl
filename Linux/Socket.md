OSI:
从上到下：
7应用层
6会话层
5网络层
4传输层
3链路层
2物理层
1？
TCP/IP:
4应用层
3传输层
2网际层
1网络接口层

网络字节序：
        在网络中数据使用大端法进行存储
        函数：
            htonl ---> 本地--> 网络(IP)
            htons ---> 本地--> 网络(port)
            ntohl ---> 网络--> 本地(IP)
            ntohs ---> 网络--> 本地(port)

        IP地址转换：
             int inet_pton(int af, const char *src, void *dst);


网络通信流程：
    server：
            1.socket()创建服务器套接字
            2.bind()绑定服务器地址结构(IP + Port)
            3.listen()设置同时连接服务器上限
            4.accept()阻塞？----阻塞监听客户端连接
            5.read(fd)读出来自客户端的数据？----读socket，来自客户端的socket
            6.处理...
            7.write(fd)向客户端写入数据？
            8.close()
    client:
            1.socket()创建客户端套接字
            2.connect()连接服务器
            3.write()向服务器写入数据
            4.read()从服务器读出数据
            5.close()



