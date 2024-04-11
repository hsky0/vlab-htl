package class05;

import java.util.Stack;

public class IsBST {
    public static class Node {
    
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static int preValue = Integer.MIN_VALUE;

    public static boolean isBST(Node head){
        if(head == null){
            return true;
        }
        Boolean isLeftBst = isBST(head.left);
        if(!isLeftBst){
            return false;
        }
        if(preValue >= head.value){
            return false;
        } else {
            preValue = head.value;
        }
        return isBST(head.right);
    }

    public static Boolean isBST2(Node head){
        if(head == null){
            return true;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if(head != null){
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if(head.value <= preValue){
                    return false;
                } else {
                    preValue = head.value;
                }
                head = head.right;
            }
        }
        return true;
    }

    public static void inOrderUnRecur(Node head){
        if(head == null){
            return;
        }
        System.out.print("in-order-unrecur:  ");
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if(head != null){
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
        System.out.println();
    }

    public static void preOrderUnRecur(Node head){
        if(head == null){
            return;
        }
        System.out.print("pre-order-unrecur: ");
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.value + " ");
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        System.out.println();
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
        inOrderUnRecur(head);
        inOrderUnRecur(head);
        if(isBST2(head)){
            System.out.println("该树是搜索二叉树");
        } else {
            System.out.println("该树不是搜索二叉树");
        }
    }
}
