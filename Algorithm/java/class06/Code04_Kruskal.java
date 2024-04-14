package class06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Collection;
import java.util.Comparator;

public class Code04_Kruskal {
    
    public static class Mysets{

        // 一个节点对应的集合是什么 node -> List(该节点所属的集合)
        public HashMap<Node, List<Node>> setMap;
        
        public Mysets(Collection<Node> collection){
            for(Node cur : collection){
                List<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }

        public boolean isSameSet(Node from, Node to){
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public void union(Node from, Node to){
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for(Node toNode : toSet){
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge>{
        
        public int compare(Edge o1, Edge o2){
            return o1.weight - o2.weight;
        }
    }

    public static List<Edge> kruskalMST(Graph graph){
        
        Mysets mySets = new Mysets(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for(Edge edge : graph.edges){
            priorityQueue.add(edge);
        }
        List<Edge> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if(!mySets.isSameSet(edge.from, edge.to)){
                result.add(edge);
                mySets.union(edge.from, edge.to);
            }
        }

        return result;
    }

    public static List<Edge> kruskalMST2(Graph graph){
        Mysets mySets = new Mysets(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for(Edge edge : graph.edges){
            priorityQueue.add(edge);
        }
        List<Edge> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if(!mySets.isSameSet(edge.from, edge.to)){
                result.add(edge);
            }
        }

        return result;
    }




    public static void main(String[] args) {
        
    }

}
