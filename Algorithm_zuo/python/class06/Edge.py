"""图的边"""


class Edge:
    def __init__(self, fromNode, toNode, weight):
        self.fromNode = fromNode
        self.toNode   = toNode
        self.weight   = weight


