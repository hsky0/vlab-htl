package class07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code05_IPO {
    
    public static class Node {
        public int p;       // 利润
        public int c;       // 成本

        public Node(int p, int c){
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node>{
        
        public int compare(Node o1, Node o2){
            return o1.c - o2.c;
        }
        
    }

    public static class MaxProfitComparator implements Comparator<Node>{
        
        public int compare(Node o1, Node o2){
            return o2.p - o1.p;
        }
        
    }

    public static int findMaximizedCapital(int k, int w, int[] Profits, int[] Capital){
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for(int i = 0; i < Profits.length; i++){
            minCostQ.add(new Node(Profits[i], Capital[i]));
        }

        for(int i = 0; i < k; i++){
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= w) {
                maxProfitQ.add(minCostQ.poll());
            }
            if(maxProfitQ.isEmpty()){
                return w;
            }
            w += maxProfitQ.poll().p;
        }
        return w;
    }
}
