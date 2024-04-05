package class02;

import java.util.PriorityQueue;
import include.globalFunc;

public class SortArrayDistanceLessK {
    public static void main(String[] args) {
        int n = 10;
        int V = 10;
        int[] arr = globalFunc.randomArray(n, V);
        globalFunc.printArray(arr);
        sortArrayDistanceLessK1(arr, 7);
        globalFunc.printArray(arr);
        
    }

    public static void sortArrayDistanceLessK(int[] arr, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for(; index <= Math.min(arr.length, k); index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for(; index < arr.length; i++, index++){
            arr[i] = heap.poll();
            heap.add(arr[index]);
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    public static void sortArrayDistanceLessK1(int[] arr, int k){

        int index = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(; index <= Math.min(arr.length, k); index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for(; index < arr.length; i++, index++){
            arr[i] = heap.poll();
            heap.add(index);
        }
        while(!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
