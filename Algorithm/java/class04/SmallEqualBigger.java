package class04;

public class SmallEqualBigger {
    
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


    public static Node listPartition2(Node head, int pivot){

        
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        tailInsert(head, 2);
        tailInsert(head, 3);
        tailInsert(head, 2);
        tailInsert(head, 1);

        printLinkList(head);
    }

}
