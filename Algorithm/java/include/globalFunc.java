package include;
public class globalFunc {
    // 产生一个随机数组，数组长度为n，数组元素的最大值为V
    public static int[] randomArray(int n, int V){
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = (int)(Math.random() * V + 1);
        }

        return arr;
    }

    public static void printArray(int[] arr){
        System.out.print("[");
        for(int i = 0; i < arr.length - 1; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + "]\n");
    }

    // 复制数组，传入一个数组，复制该数组并返回
    public static int[] copyArray(int[] arr){

        int n = arr.length;
        int[] newarr = new int[n];
        for(int i = 0; i < n; i++){
            newarr[i] = arr[i];
        }

        return newarr;
    }

    // 返回两个数组是否相等的布尔值
    public static boolean sameArray(int[] arr1, int[] arr2){

        int n = arr1.length;
        for(int i = 0; i < n; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }

    // 交换数组中i和j位置的元素
    public static void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }


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

}
