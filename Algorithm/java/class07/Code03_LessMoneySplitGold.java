package class07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code03_LessMoneySplitGold {
    
    public static int lessMoney(int[] arr){

        PriorityQueue<Integer> pQ = new PriorityQueue<>();      // 准备一个小根堆
        for(int i = 0; i < arr.length; i++){
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (!pQ.isEmpty()) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }

        return sum;
    }


    public static class MinHeapComparator implements Comparator<Integer>{
        
        public int compare(Integer o1, Integer o2){
            return o1 - o2;
        }
        
    }
}
