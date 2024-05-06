package class06;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Exercise {
    

    public class Graph {
        
        HashMap<Integer, Node> nodes;
        HashSet<Edge> edges;

        public Graph(){
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }
        
    }


    public class Node {
    
        public int value;
        public int in;
        public int out;
        public ArrayList<Node> nexts;
        public ArrayList<Edge> edges;

        public Node(int val){
            value = val;
        }
        
    }

    public class Edge{
        public int weight;
        public Node from;
        public Node to;

        public Edge(Node from, Node to, int weight){
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    public Graph createGraph(Integer[][] matrix){
        Graph graph = new Graph();
        for(int i = 0; i < matrix.length; i++){
            Integer from = matrix[0][0];
            Integer to   = matrix[0][1];
            int weight   = matrix[0][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode   = graph.nodes.get(to);
            Edge newEdge  = new Edge(fromNode, toNode, weight);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }

        return graph;
    }

    public static void printMatrix(Integer[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == null){
                    break;
                }
                System.out.print(matrix[i][j] + " ");
                
            }
            System.err.println();
            if(matrix[i][0] == null){
                break;
            }
        }
    
    }

    public static void main(String[] args) {
        // InputStream f = new FileInputStream("matrix.txt");
        // File f = new File("/home/ubuntu/htl/Algorithm/java/class06/matrix.txt");
        int N = 10;
        String filePath = "/home/ubuntu/htl/Algorithm/java/class06/matrix.txt"; // 替换为实际的文件路径
        Integer[][] matrix = new Integer[N][3];
        int i = 0, j = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] values = line.split(" ");
                while (j < 3) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                    j++;
                }
                i++;
                j = 0;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("==================");
        printMatrix(matrix);
    }
}
