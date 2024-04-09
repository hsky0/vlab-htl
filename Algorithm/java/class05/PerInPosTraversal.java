package class05;

import java.util.Stack;

public class PerInPosTraversal {
    
    public static class Node {
    
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(Node head){ 
        if(head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    public static void preOrderUnRecur(Node head){
        System.out.print("pre-order-unrecur: ");
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if(head.right != null){
                    stack.add(head.right);
                }
                if(head.left != null){
                    stack.add(head.left);
                }
            }
            System.out.println();
        }
    }
    
    public static void posOrderUnRecur(Node head){
        System.out.print("pos-order-unrecur: ");
        if(head != null){
            Stack<Node> stack1 = new Stack<Node>();
            Stack<Node> stack2 = new Stack<Node>();
            stack1.add(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.add(head);
                if(head.left != null){
                    stack1.add(head.left);
                }
                if(head.right != null){
                    stack1.add(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
            System.out.println();
        }
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
        System.out.print("pre-order-recur: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order-recur:  ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order-recur: ");
        posOrderRecur(head);
        System.out.println();
        preOrderUnRecur(head);
        posOrderUnRecur(head);
    }
}
