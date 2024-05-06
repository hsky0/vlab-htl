package class06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphGenerator {
    
    // matrix 所有的边
    //  N * 3矩阵，N行3列
    // [from, to, weight] 
    /**
     * @param matrix
     * @return
     */
    public static Graph createGraph(Integer[][] matrix){
        Graph graph = new Graph();
        for(int i = 0; i < matrix.length; i++){
            Integer from    = matrix[i][0];
            Integer to      = matrix[i][1];
            Integer weight  = matrix[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode   = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }

        return graph;
    }

    // 从文件中提取数据并创建一个矩阵
    public static Integer[][] createMatrix(String filePath){
        int[] dimension = getFileRowAndColNumer(filePath);
        int row = dimension[0], col = dimension[1];
        Integer[][] matrix = new Integer[row][col];
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            int i = 0, j = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                while (j < col && i < row) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                    j++;
                }
                i++;
                j = 0;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return matrix;
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

    // 返回一个长度为2的数组[row, col]，包含矩阵的行数和列数
    public static int[] getFileRowAndColNumer(String filePath){
        int row = 0, col = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = reader.readLine();
            row++;
            String[] values = line.split(" ");
            col = values.length;
            while ((line = reader.readLine()) != null) {
                row++;
            }
            
        } catch (IOException e){
            e.printStackTrace();
        }
        int[] res = {row, col};
        return res;
    }

    public static void main(String[] args) {
    
        String filePath = "/home/ubuntu/htl/Algorithm/java/class06/matrix.txt";
        Integer[][] matrix = createMatrix(filePath);
        printMatrix(matrix);

        int[] res = getFileRowAndColNumer(filePath);
        System.err.print("row = " + res[0] + " col = " + res[1] + "\n");
        
    }
}
