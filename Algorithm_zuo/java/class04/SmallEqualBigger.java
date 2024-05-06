package class04;

import include.globalFunc;

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


    public static Node listPartition2(Node head, int pivot){
        Node sH = null;     // samll head
        Node sT = null;     // samll tail
        Node eH = null;     // equal head
        Node eT = null;     // equal tail
        Node bH = null;     // big head
        Node bT = null;     // big tail
        Node next = null;   // save next node
        // every node distributed to three lists
        while(head != null){
            next = head.next;
            head.next = null;
            if(head.value < pivot){
                if(sH == null){
                    sH = head;
                    sT = head;
                }
                else{
                    sT.next = head;
                    sT = head;
                }
            }
            else if(head.value == pivot){
                if(eH == null){
                    eH = head;
                    eT = head;
                }
                else{
                    eT.next = head;
                    eT = head;
                }
            }
            else{
                if(bH == null){
                    bH = head;
                    bT = head;
                }
                else{
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        if(sT != null){                     // 如果有小于区
            sT.next = eH;
            eT = eT == null ? sT : eT;      // 下一步，谁去连大于区的头，谁就变成eT
        }

        if(eT != null){
            eT.next = bH;
        }
        return sH != null ? sH : (eH != null ? eH : bH);

        
    }


    // 产生一个随机链表，链表长度为n，链表的结点的最大值为不超过V
    public static Node createRandomLinkList(int n, int V){

        Node head = new Node((int)(Math.random() * V) + 1);
        for(int i = 1; i < n; i++){
            headInsert(head, (int)(Math.random() * V) + 1);
        }

        return head;
    }

    public static void main(String[] args) {
        int n = 20;
        int V = 10;
        int pivot = 6;
        Node head = createRandomLinkList(n, V);
    
        printLinkList(head);
        Node head1 = listPartition2(head, pivot);
        printLinkList(head1);

        

    }

}
