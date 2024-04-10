package class05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxWidth {
    

    public static class Node {
    
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }


    // 二叉树宽度优先遍历
    public static void widthFirstTraversal(Node head){
        if(head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.value + " ");
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
        System.out.println();
    }

    public static int getMaxWidth(Node head){
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if(curLevel == curNodeLevel){
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
            if(cur.left != null){
                queue.add(cur.left);
                levelMap.put(cur.left, curNodeLevel + 1);
            }
            if(cur.right != null){
                queue.add(cur.right);
                levelMap.put(cur.right, curNodeLevel + 1);
            }
        }
        return Math.max(max, curLevelNodes);
    }

    public static int getMaxWidth2(Node head){
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if(curLevel == curNodeLevel){
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
            if(cur.left != null){
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if(cur.right != null){
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);  
            }
        }
        return Math.max(max, curLevelNodes);
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
        widthFirstTraversal(head);
        System.out.println(getMaxWidth(head));
        widthFirstTraversal(head);
        System.out.println(getMaxWidth2(head));
    }
}
