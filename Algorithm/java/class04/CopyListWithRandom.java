package class04;

import java.util.HashMap;

import include.globalFunc;

public class CopyListWithRandom {

    public static class Node {
    
        public int value;
        public Node next;
        public Node rand;
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

    // 使用头插法插入一个元素到链表中
    public static void headInsert(Node head, int e){
        if(head == null){
            System.out.println("出现错误，请检查头节点");
        }
        Node node = new Node(e);
        if(head.next == null){
            head.next = node;
        }
        else{
            node.next = head.next;
            head.next = node;
        }

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

    // 产生一个随机链表，链表长度为n，链表的结点的最大值为不超过V
    public static Node createRandomLinkList(int n, int V){

        Node head = new Node((int)(Math.random() * V) + 1);
        for(int i = 1; i < n; i++){
            headInsert(head, (int)(Math.random() * V) + 1);
        }

        return head;
    }


    public static Node copyListWithRand1(Node head){
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            // cur 老
            // map.get(cur) 新
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyListWithRand2(Node head){
        if(head == null){
            return null;
        }
        Node cur  = head;
        Node next = null;       // save new node
        // copy node and link to every node
        // 1 -> 2
        // 1 -> 1' -> 2
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        // set copy node rand
        // 1 -> 1' -> 2 -> 2'
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        Node res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }

        return res;
    }
    
    public static Node copyListWithRand1_repeat(Node head){
        if(head == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyListWithRand1_repeat2(Node head){
        if(head == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }

        return map.get(head);
    }

    public static Node copyListWithRand2_repeat(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node copyNode = null;
        while (cur != null) {
            next = cur.next.next;
            copyNode = cur.next;
            copyNode.rand = cur.rand.next;
            cur = next;
        }

        // 有问题
        return copyNode;

    }

    public static Node copyListWithRand2_repeat2(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        Node res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next  != null ? next.next : null;
            cur = next;
        }

        return res;

    }
    public static void main(String[] args) {
        int n = 10;
        int V = 10;
        Node head = createRandomLinkList(n, V);
        printLinkList(head);
        Node head1 = copyListWithRand2_repeat2(head);
        printLinkList(head1);
    }
}
