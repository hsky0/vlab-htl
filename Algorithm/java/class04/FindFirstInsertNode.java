package class04;

import include.globalFunc.Node;
import include.globalFunc;


public class FindFirstInsertNode {
    


    // 找到链表的第一个环节点，如果无环，则返回null
    public static Node getLoopNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;            // 单链表要形成环至少要有三个结点
        }
        Node n1 = head.next;         // n1 -> slow ndoe, go one step per time
        Node n2 = head.next.next;    // n2 -> fast node, go two step per time
        while (n1 != n2) {
            if(n2.next == null || n2.next.next == null){
                return null;            // 这种情况说明该链表没有环
            }
            n1 = n1.next;
            n2 = n2.next.next;     
        }
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
    }  

    public static Node getLoopNode2(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }

        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2) {
            if(n2.next == null || n2.next.next == null){
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
    }

    // 如果两个链表都无环，返回第一个相交结点，如果不相交，返回null
    public static Node noLoop(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        // 找到第一个相交的节点
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;        // 如果两个链表相交，则他们的最后一个节点一定相同
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }

    public static Node noLoop2(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;        // 如果两个链表相交，则他们的最后一个节点一定相同
        }
        cur1 = n > 0 ? head1 : head2;           // 两个链表中，谁长谁把head给cur1
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {        // 长的链表先走n个节点
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) { // 两个链表一起走直到找到第一个相交的节点
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }



    // 两个有环链表，返回第一个相交节点，如果不相交返回null
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
        else{
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if(cur1 == loop2){
                    return loop1;
                }
            }
            return null;
        }
    }
    
    public static Node bothLoop2(Node head1, Node loop1, Node head2, Node loop2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;

        }
        else{
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2){
        if(head1 == null|| head2 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1 == null && loop2 == null){
            return noLoop(head1, head2);
        }
        if(loop1 != null && loop2 != null){
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    public static void main(String[] args) {
        int length = 10;
        int pos = 2;
        int V = 20;
        Node head  = globalFunc.createLoopLinkList(length, pos, V);
        globalFunc.printLoopLinkList(head, length);
        System.out.println(getLoopNode(head).value);
    }
}
