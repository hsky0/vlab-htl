package class06;

import java.util.HashSet;
import java.util.Stack;

public class Code02_DFS {
    public static void dfs(Node node){
        if(node == null){
            return;
        }
        HashSet<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        set.add(node);
        System.out.print(node.value + " ");
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for(Node next : cur.nexts){
                if(!set.contains(next)){
                    stack.add(cur);
                    stack.add(next);
                    set.add(next);
                    System.out.print(next.value + " ");
                    break;
                }
            }
        }
        System.out.println();
    }
}
