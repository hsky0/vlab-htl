package class06;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class Code01_BFS {
    

    // 从node出发，进行宽度优先遍历
    public static void bfs(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.value + " ");
            for(Node next : cur.nexts){
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String filePath = "/home/ubuntu/htl/Algorithm/java/class06/matrix.txt";
        Integer[][] matrix = GraphGenerator.createMatrix(filePath);
        GraphGenerator.printMatrix(matrix);
        System.out.println("=====================");
        Graph graph = GraphGenerator.createGraph(matrix);
        bfs(graph.nodes.get(1));
        Code02_DFS.dfs(graph.nodes.get(1));

    }
}
