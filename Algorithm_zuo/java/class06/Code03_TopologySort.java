package class06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code03_TopologySort {
    
    public static List<Node> sortedTopology(Graph graph){
        // key：某一个node
        // value：剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        // 入度为0的点进入的队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        for(Node node : graph.nodes.values()){
            inMap.put(node, node.in);
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }
        // 拓扑排序的结果，依次加入result
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for(Node next : cur.nexts){
                inMap.put(next, inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }

        return result;
    }

    public static List<Node> sortedTopology2(Graph graph){
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for(Node node : graph.nodes.values()){
            inMap.put(node, node.in);
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for(Node next : cur.nexts){
                inMap.put(next, inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }

        return result;
    }

    public static void printSortedResult(List<Node> result){
        if(result.size() == 0){
            return;
        }
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i).value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String filePath = "/home/ubuntu/htl/Algorithm/java/class06/matrix.txt";
        Integer[][] matrix = GraphGenerator.createMatrix(filePath);
        GraphGenerator.printMatrix(matrix);
        System.out.println("=====================");
        Graph graph = GraphGenerator.createGraph(matrix);
        Code01_BFS.bfs(graph.nodes.get(1));
        Code02_DFS.dfs(graph.nodes.get(1));

        System.out.println("=======================");
        printSortedResult(sortedTopology(graph));

    }
}
