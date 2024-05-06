package class06;

import java.util.ArrayList;

public class Node {
    public int value;               // 节点的数据项，可表示节点的编号
    public int in;                  // 节点的入度，表示有多少节点指向该节点
    public int out;                 // 节点的出度，表示有该节点指向多少个节点
    public ArrayList<Node> nexts;   // 该节点的发散出去的边的邻接节点，该数据是一个节点
    public ArrayList<Edge> edges;   // 属于该节点的边有哪些（必须是从该节点发散的边才是属于该节点）
    
    public Node(int val){
        value = val;
        in  = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
