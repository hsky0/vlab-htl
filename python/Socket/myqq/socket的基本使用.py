"""利用python的内置库实现通信"""


import socket


def main():
    # 1.创建socket
    """
    socket:传入两个参数
    网络协议: ip地址、网络模型
    return:
    """
    udp_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

    # 2. 发送信息
    """
    socket.sendto():传入三个参数
    要发送的消息
    ip地址
    端口
    """
    udp_socket.sendto(b"123",  ('192.168.56.1', 8080))

    # 3. 关闭socket
    udp_socket.close()


if __name__ == "__main__":
    main()
