package class04;

import java.util.HashSet;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Comparator;
public class HashAndTree {
    

    public static class Node {
    
        public int value;
        public String text;
        public Node next;
    
        public Node(int val){
            value = val;
        }
    }

    public static class NodeComparator implements Comparator<Node>{
        
        public int compare(Node o1, Node o2){
            return o1.value - o2.value;
        }
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.text = "kdfjnbvfkgb";

        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(3);
        System.out.println(hashSet1.contains(3));

        HashMap<Integer, String> mapTest = new HashMap<>();
        mapTest.put(1, "fkgjb");
        mapTest.put(2, null);
        System.out.println(mapTest.get(1));
        System.out.println(mapTest.get(2));
        System.out.println(mapTest.get(4));
        System.out.println(mapTest.containsKey(1));

        System.out.println("====================================");

        TreeSet<Node> treeSet = new TreeSet<>(new NodeComparator());

        try{
            treeSet.add(node1);
            treeSet.add(node2);
            treeSet.add(node3);
        }
        catch(Exception e){
            System.out.println("错误信息" + e.getMessage());
        }
        System.out.println(node1.text);


    }
}
