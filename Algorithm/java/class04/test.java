package class04;

import include.globalFunc;

public class test {
    public static void main(String[] args) {
        int n = 10;
        int V = 10;
        globalFunc.Node head = globalFunc.createRandomLinkList(n, V);
        globalFunc.printLinkList(head);
    }
}
