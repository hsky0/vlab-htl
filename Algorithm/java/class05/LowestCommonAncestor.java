package class05;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestor {
    public static class Node {
    
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    // o1和o2属于以head为头的 树
    // 返回o1和o2的最低公共祖先
    public static Node lca(Node head, Node o1, Node o2){
        HashMap<Node, Node> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap);
        HashSet<Node> set1 = new HashSet<>();
        Node cur = o1;
        while (cur != fatherMap.get(cur)) {
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);
        cur = o2;
        while (cur != fatherMap.get(cur)) {
            if(set1.contains(fatherMap.get(cur))){
                return fatherMap.get(cur);
            }
            cur = fatherMap.get(cur);
        }
        return head;

    }

    public static void process(Node head, HashMap<Node, Node> fatherMap){
        if(head == null){
            return;
        }

        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }

    public static Node lowestAncestor(Node head, Node o1, Node o2){
        if(head == null || head == o1 || head == o2){
            return head;
        }
        Node left  = lowestAncestor(head.left, o1, o2);
        Node right = lowestAncestor(head.right, o1, o2);
        if(left != null && right != null){
            return head;
        }
        return left != null ? left : right;
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


        System.out.println("================================");
        preOrderRecur(head);
        System.out.println();
        Node o1 = head.left.left;
        Node o2 = head.left.right;
        System.out.println(lca(head, o1, o2).value);
        System.out.println(lowestAncestor(head, o1, o2).value);
    }
}
