"""构造一个图"""
import numpy as np

import Graph, Node, Edge

class Queue:
    def __init__(self):
        self.queue = []
    def add(self, e):
        self.queue.append(e)
    def pop(self):
        if len(self.queue) == 0:
            return None
        res = self.queue[0]
        self.queue = self.queue[1:]
        return res
    def isEmpty(self):
        if len(self.queue) == 0:
            return True
        else:
            return False

class Stack:
    def __init__(self):
        self.stack = []
    def push(self, e):
        self.stack.append(e)
    def pop(self):
        if len(self.stack) == 0:
            return None
        res = self.stack.pop()
        return res
    def isEmpty(self):
        if len(self.stack) == 0:
            return True
        else:
            return False
        

class GraphGenerator:
    def createGraph(self, matrix):
        self.graph = Graph.Graph()
        for i in range(len(matrix)):
            fromNum = matrix[i][0]
            toNum   = matrix[i][1]
            weight   = matrix[i][2]
            if not fromNum in self.graph.nodes:
                self.graph.nodes[fromNum] = Node.Node(fromNum)
            if not toNum in self.graph.nodes:
                self.graph.nodes[toNum] = Node.Node(toNum)
            fromNode = self.graph.nodes[fromNum]
            toNode   = self.graph.nodes[toNum]
            newEdge  = Edge.Edge(fromNode, toNode, weight)
            fromNode.nexts.append(toNode)
            fromNode.outNum += 1
            toNode.inNum += 1
            fromNode.edges.append(newEdge)
            self.graph.edges.add(newEdge)
        return self.graph

    # 从文件中提取数据来创建一个矩阵
    def createMatrix(self, filePath):
        row, col = self.getFileRowAndColNumber(filePath)
        i, j = 0, 0
        matrix = np.zeros((row, col), dtype=int)
        with open(filePath, 'r') as file:
            lines = file.readlines()
            for line in  lines:
                line = line.strip()
                values = line.split()
                while j < col:
                    matrix[i][j] = values[j]
                    j = j + 1
                i = i + 1
                j = 0
        return matrix

    def printMatrix(self, matrix):
        row, col = len(matrix), len(matrix[0])
        for i in range(row):
            for j in range(col):
                print(f"{matrix[i][j]} ", end="")
            print()
    # 得到txt文件的行数和列数（其中列数不包括空格）
    def getFileRowAndColNumber(self, filePath):
        with open(filePath, 'r') as file:
            lines = file.readlines()
            row = len(lines)
            line = lines[0]
            values = line.split(" ")
            col = len(values)
            return row, col


    # 实现图的宽度优先遍历（广度优先搜索）
    def bfs(self, node):
        if(node == None):
            return
        queue = Queue()
        setnode = set()
        queue.add(node)
        setnode.add(node)
        while not queue.isEmpty():
            cur = queue.pop()
            print(f"{cur.value} ", end="")
            for next in cur.nexts:
                if not next in setnode:
                    setnode.add(next)
                    queue.add(next)
        print()


    def dfs(self, node):
        if node == None:
            return
        stack = Stack()
        nodeset = set()
        stack.push(node)
        nodeset.add(node)
        print(f"{node.value} ", end="")
        while not stack.isEmpty():
            cur = stack.pop()
            for next in cur.nexts:
                if not next in nodeset:
                    stack.push(cur)
                    stack.push(next)
                    nodeset.add(next)
                    print(f"{next.value} ", end="")
                    break
        print()
    def sortedTopolgy(self, graph):
        inMap = {}
        zeroInQueue = Queue()
        for node in self.graph.nodes.values():
            inMap[node] = node.inNum
            if(node.inNum == 0):
                zeroInQueue.add(node)
        result = []
        while not zeroInQueue.isEmpty():
            cur = zeroInQueue.pop()
            result.append(cur)
            for next in cur.nexts:
                inMap[next] = inMap[next] - 1
                if inMap[next] == 0:
                    zeroInQueue.add(next)
        return result
    
    def printSortedResult(self, result):
        if len(result) == 0:
            return
        for x in result:
            print(f"{x.value} ", end="")
        print()

def test():
    stack = Stack()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    print(stack.pop())
    print(stack.pop())
    print(stack.pop())
    print(stack.pop())


def main():
    filePath = "/home/ubuntu/htl/Algorithm/python/class06/matrix.txt"
    graphGenerator = GraphGenerator()
    matrix = graphGenerator.createMatrix(filePath)
    graphGenerator.printMatrix(matrix)
    print("="*20)
    graph = graphGenerator.createGraph(matrix)
    graphGenerator.bfs(graph.nodes[1])
    graphGenerator.dfs(graph.nodes[1])
    print("="*20)
    graphGenerator.printSortedResult(graphGenerator.sortedTopolgy(graph))



main()