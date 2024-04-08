package class04;

import java.util.Stack;

public class IsPalindromeNumber {
    
    public static class Node {
    
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }

    // 初始化链表
    public static void initialNode(Node head){
        head.next = null;
    }

    // 使用尾插法插入一个元素到链表中
    public static void tailInsert(Node head, int e){
        Node node = new Node(e);
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = node;
        node.next = null;
    }

    public static void printLinkList(Node head){
        if(head == null){
            System.out.println("链表为空！");
        }
        Node p = head;
        while (p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }
        System.out.println();
    }

    // 需要n个额外空间，先将链表的所有结点压入栈中，在依次弹出比较
    public static boolean isPalindromeNumber1(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 使用快慢指针，额外空间为n/2
    public static boolean isPalindromeNumber2(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 版本三，使用有限几个变量实现，额外空间复杂度为O(1)
    public static boolean isPalindromeNumber3(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null  && n2.next.next != null) {  // find mid node
            n1 = n1.next;       // n1 -> mid
            n2 = n2.next.next;  // n2 -> end
        }
        n2 = n1.next; // n2 -> right part first node
        n1.next = null; //mid.next -> null
        Node n3 = null;
        while (n2 != null) {        // right part convert
            n3 = n2.next;          // n3 -> save next node
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;    // n3 -> save last node
        n2 = head;  // n2 ->left first node
        boolean res = true;
        while (n1 != null && n2 != null) {
            if(n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return res;
    }


    public static boolean isPalindromeNumber3_reapt(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node n1 = head;          // n1 -> mid
        Node n2 = head;          // n2 -> end
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        n2 = n1.next;
        n1.next = null;
        Node n3 = null;     // to save node
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;        // the end node
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if(n1.value != n2.value){
                res = false;
                break;
            }
        n1 = n1.next;
        n2 = n2.next;
        }
        n2 = n3.next;
        n3.next = null;
        while (n2 != null) {
            n1 = n2.next;
            n2.next = n3;
            n3 = n2;
            n2 = n1;
        }

        return res;
    }

    public static boolean isPalindromeNumber3_reapt1(Node head){

        if(head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;           // n1 -> mid node
            n2 = n2.next.next;       // n2 -> end node
        }
        // find the mid node, set the mid node's next pointer point null
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;         // n3 is used to save the node, is a intermediate variable
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n2 = head;
        n3 = n1;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if(n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n2 = n3.next;
        n3.next = null;
        n1 = n3;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        return res;
    }



    public static void main(String[] args) {
        
        Node head = new Node(1);
        tailInsert(head, 2);
        tailInsert(head, 3);
        tailInsert(head, 2);
        tailInsert(head, 1);
        tailInsert(head, 1);
        tailInsert(head, 1);

        Node head1 = new Node(1);
        tailInsert(head1, 2);
        tailInsert(head1, 3);
        tailInsert(head1, 3);
        tailInsert(head1, 2);
        tailInsert(head1, 1);

        printLinkList(head);
        if(isPalindromeNumber3_reapt1(head)){
            System.out.println("该链表是回文结构");
            printLinkList(head);
        }
        else{
            System.out.println("该链表不是回文结构");
            printLinkList(head);
        }

        printLinkList(head1);
        if(isPalindromeNumber3(head1)){
            System.out.println("该链表是回文结构");
            printLinkList(head1);
        }
        else{
            System.out.println("该链表不是回文结构");
            printLinkList(head1);
        }
        

    }

}
