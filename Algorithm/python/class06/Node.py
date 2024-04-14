"""图的节点"""


class Node:
    def __init__(self, val):
        self.value  = val 
        self.inNum  = 0
        self.outNum = 0
        self.nexts  = []
        self.edges  = []

        