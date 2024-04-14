package class05;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndReconstructTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int val){
          value = val;
        }
    }   

    public static String serialByPre(Node head){
        if(head == null){
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Node reconByPreString(String preStr){
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i != values.length; i++) {
            queue.add(values[i]);
        }
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);

        return head;
    }

    public static String serialByPre2(Node head){
        if(head == null){
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPre2(head.left);
        res += serialByPre2(head.right);

        return res;
    }

    public static Node reconByPreString2(String preStr){
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i != values.length; i++){
            queue.add(values[i]);
        }

        return reconPreOrder(queue);
    }

    public static Node reconPreOrder2(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#_")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder2(queue);
        head.right = reconPreOrder2(queue);

        return head;
    }

    public static void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(5);
        head.left.left = new Node(3);
        head.left.right = new Node(4);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println("==================");
        preOrderRecur(head);
        System.out.println();
        System.out.println(serialByPre(head));
        Node head1 = reconByPreString2(serialByPre2(head));
        preOrderRecur(head1);
        System.err.println();
        
    }
}
