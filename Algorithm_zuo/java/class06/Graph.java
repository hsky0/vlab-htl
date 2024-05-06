package class06;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashMap<Integer, Node> nodes;            // 图包含的节点
    public HashSet<Edge> edges;                     // 图包含的边
    
    public Graph(){
        nodes = new HashMap<Integer, Node>();
        edges = new HashSet<Edge>();
    }
}


