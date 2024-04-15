package class06;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Code06_Dijkstra {
    
    public static HashMap<Node, Integer> dijkstra1(Node head){

        // 从head出发到所有点的最小距离
        // key：从head出发到达key
        // value：从head出发到达key的最小距离
        // 如果在表中，没有T的记录，含义是从head出发到T这个点的距离为正无穷

        // distanceMap从一开始规定的节点（起始节点）到一个节点的最小距离
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);       // 起始节点到起始节点的距离为0
        // 已经求过距离的节点，存在selectedNodes中，以后不再管
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for(Edge edge : minNode.edges){
                Node toNode = edge.to;
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }


    public static Node getMinDistanceAndUnselectedNode(
        HashMap<Node, Integer> distanceMap, 
        HashSet<Node> touchedNodes){
            Node minNode = null;
            int  minDistance = Integer.MAX_VALUE;
            for(Map.Entry<Node, Integer> entry : distanceMap.entrySet()){
                Node node = entry.getKey();
                int distance = entry.getValue();
                if(!touchedNodes.contains(node) && distance < minDistance){
                    minNode = node;
                    minDistance = distance;
                }
            }
        return minNode;
    }


    public static HashMap<Node, Integer> dijkstra2(Node head){

        HashMap<Node, Integer> distanceMap = new HashMap<>();
        HashSet<Node> selectedNodes = new HashSet<>();
        distanceMap.put(head, 0);
        Node minNode = getMinDistanceAndUnselectedNode2(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for(Edge edge : minNode.edges){
                Node toNode = edge.to;
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }


    public static Node getMinDistanceAndUnselectedNode2(
        HashMap<Node, Integer> distanceMap,
        HashSet<Node> touchedNodes
    ){
        Node minNode = null;
        int  minDistance = Integer.MAX_VALUE;
        for(Map.Entry<Node, Integer> entry : distanceMap.entrySet()){
            Node node = entry.getKey();
            int distance = entry.getValue();
            if(!touchedNodes.contains(node) && distance < minDistance){
                minDistance = distance;
                minNode = node;
            }
        }
        return minNode;
    }


    public static void printDijkstraMap(HashMap<Node, Integer> disHashMap){
        System.out.println();
        for(Map.Entry<Node, Integer> entry : disHashMap.entrySet()){
            Node node = entry.getKey();
            int  distance = entry.getValue();
            System.out.print(node.value + ":" + distance + "-");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String filePath = "/home/ubuntu/htl/Algorithm/java/class06/matrixD.txt";
        Integer[][] matrix = GraphGenerator.createMatrix(filePath);
        GraphGenerator.printMatrix(matrix);
        System.out.println("=====================");
        Graph graph = GraphGenerator.createGraph(matrix);
        Code01_BFS.bfs(graph.nodes.get(1));
        Code02_DFS.dfs(graph.nodes.get(1));
        System.out.println("===============Djikstra===========");
        printDijkstraMap(dijkstra2(graph.nodes.get(1)));

    }
}


