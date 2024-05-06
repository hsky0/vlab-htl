package class02;
import java.util.Arrays;
import java.util.PriorityQueue;


import include.globalFunc;


public class HeapSort {
    public static void main(String[] args) {
        int n = 10;
        int V = 10;
        int testTimes = 10000;
        int[] arr = globalFunc.randomArray(n, V);
        globalFunc.printArray(arr);
        heapSort1(arr);
        globalFunc.printArray(arr);

        class02.Validator.validator(Arrays::sort, HeapSort::heapSort, 100, 1000, testTimes, true);
    
    }


    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        // // 先将得到的数组变成大根堆
        // for(int i = 0; i < arr.length; i++){            //O(N)
        //     heapInsert(arr, i);                         //O(logN)
        // }

        // 从右往左调整，整个循环时间复杂度为O(N)
        for(int i = arr.length - 1; i >= 0; i--){
            heapify(arr, i, arr.length);
        }

        // 将大根堆的最大值提取出来，并将剩下的元素重新排成大根堆，重复该过程，直到所有数组元素都排好序为止
        int heapSize = arr.length;
        globalFunc.swap(arr, 0, --heapSize);
        while (heapSize > 0) {                  // O(N)
            heapify(arr, 0, heapSize);    // O(logN)
            globalFunc.swap(arr, 0, --heapSize);         // O(1)
        }
    }

    // 某个数现在处在index位置，往上移动
    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index - 1) / 2]){       //大根堆，index的值大于其父结点的值，交换
            globalFunc.swap(arr, index, (index - 1) / 2);          //交换
            index = (index - 1) / 2;                    //继续往上找
        }          
    }


    // 某个数现在处于index位置，能否往下移动
    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 + 1;       // 左孩子的下标

        while (left < heapSize) {       // 下方还有孩子，对于一颗完全二叉树来说，有右孩子一定有左孩子，但是有左孩子不一定有右孩子

            // 两个孩子中，谁的值大，把下标给largest， left + 1表示右孩子的下标
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            
            // 父和孩子进行比较，谁的值大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;

            if(largest == index){   // 表面父的值相比于左孩子和右孩子较大，因此退出循环
                break;          
            }
            globalFunc.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void heapSort1(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        for(int i = 0; i < arr.length; i++){
            heapInsert1(arr, i);
        }

        int heapSize = arr.length;
        globalFunc.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify1(arr, 0, heapSize);
            globalFunc.swap(arr, 0, --heapSize);
        }
    }

    public static void heapInsert1(int[] arr, int index){
        while (arr[index] > arr[(index - 1) / 2]) {
            globalFunc.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify1(int[] arr, int index, int heapSize){
        int left = index * 2 + 1;

        while (left < heapSize) {
            // 比较两个孩子的值，谁大就将其下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;

            // 比较孩子和父的值，谁大谁将下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            globalFunc.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
        

    }
    
}
