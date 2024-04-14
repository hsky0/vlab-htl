package class06;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Code05_Prim {
    
    public static class EdgeComparator implements Comparator<Edge>{
        
        public int compare(Edge o1, Edge o2){
            return o1.weight - o2.weight;
        }
    }

    // 使用prim算法得到最小生成树
    public static List<Edge> PrimMST(Graph graph){

        // 创建一个小根堆用于得到最小的边
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> set = new HashSet<>();

        List<Edge> result = new ArrayList<>();
        for(Node node : graph.nodes.values()){

            if(!set.contains(node)){
                set.add(node);
                for(Edge edge : node.edges){
                    priorityQueue.add(edge);
                }
                Edge edge = priorityQueue.poll();
                Node toNode = edge.to;
                if(!set.contains(toNode)){
                    set.add(toNode);
                    result.add(edge);
                    for(Edge nextedge : toNode.edges){
                        priorityQueue.add(nextedge);
                    }
                }
            }
        }

        return result;
    }

    public static List<Edge> primMST2(Graph graph){

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> set = new HashSet<>();

        List<Edge> result = new ArrayList<>();

        for(Node node : graph.nodes.values()){

            if(!set.contains(node)){
                set.add(node);
                for(Edge edge : node.edges){
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if(!set.contains(toNode)){
                        set.add(toNode);
                        result.add(edge);
                        for(Edge nextEdge : toNode.edges){
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }

        return result;
    }
}
