package class07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code06_MedianQuick {


    

    public static class MinHeapComparator implements Comparator<Integer> {
        
        public int compare(Integer o1, Integer o2){
            return o1 - o2;
        }
    }

    public static class MaxHeapComparator implements Comparator<Integer> {
        
        public int compare(Integer o1, Integer o2){
            return o2 - o1;
        }
    }
    public static class MedianQuick{
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianQuick(){
            minHeap = new PriorityQueue<>(new MinHeapComparator());
            maxHeap = new PriorityQueue<>(new MaxHeapComparator());
        }
    }

    
}
