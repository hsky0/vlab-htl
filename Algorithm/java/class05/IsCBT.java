package class05;

import java.util.LinkedList;
import java.util.Queue;

public class IsCBT {
    public static class Node {
    
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static boolean isCBT(Node head){
        if(head == null){
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        // 是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        Node l = null;
        Node r = null;
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
             
            if( // 如果遇到不双全的节点，并且又发现当前节点不是叶节点
                (leaf && (l == null || r == null)) 
                || 
                (l == null && r != null)){
                return false;
            }
            if(l != null){
                queue.add(l);
            }
            if(r != null){
                queue.add(r);
            }
            // 左右子树不双全
            if(l == null || r == null){
                leaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(5);
        head.left.left = new Node(3);
        head.left.right = new Node(4);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println("=============================");
    }
}
