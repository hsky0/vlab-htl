package class02;
import java.util.Arrays;
import class02.MergeSort;
import class02.QuickSort;


public class Validator {
    

    public static void main(String [] args){

        int N = 100;    //随机数组最大的长度
        int V = 1000;   //随机产生的数：0~V

        // 测试次数
        int testTimes = 100000;
        System.out.println("测试开始...");
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < testTimes; i++){

            // 随机得到一个长度，值在0~N之间
            int n = (int)(Math.random() * N);        //random()等概率产生[0,1)之间的小数

            // 得到随机数组
            int[] arr = randomArray(n, V);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            int[] cmparr = copyArray(arr);;
            // 进行排序
            selectionSort(arr1);
            bubbleSort(arr3);
            QuickSort.quickSort(arr2);
            Arrays.sort(cmparr);
            // printArray(arr);
            // printArray(arr1);
            // printArray(arr2);
            // printArray(arr3);
            // 测试
            // if(!sameArray(arr1, arr2) || !sameArray(arr1, arr3) || !sameArray(arr1, arr4)){

            //     // 算法出现错误
            //     System.out.println("出现错误！请检查你的算法！");
            // }
            if(!sameArray(cmparr, arr2)){

                
                System.out.println("出现错误！请检查你的算法！");
                break;
            }
            
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("timeUse = " + (stopTime - startTime) / 1000.0 + "s");
        System.out.println("测试结束");

    }

    // 产生随机数组，数组长度为n， 数组元素值：0~V之间
    public static int[] randomArray(int n, int V){
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = (int)(Math.random() * V) + 1;
        }

        return arr;
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

    // 打印数组
    public static void printArray(int[] arr) {

        for(int e : arr){
            System.err.print(e);
            System.err.print(" ");
        }
        System.out.println();
    }

    // 选择排序
    public static void selectionSort(int[] arr){

        if(arr == null || arr.length < 2){
            return;
        }
        for(int minIndex, i = 0; i < arr.length - 1; i++){
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        
        int n = arr.length;
        if(arr == null || arr.length < 2){
            return;
        }
        while (n != 0) {
            for(int i = 0; i < n - 1; i++){
                if(arr[i] > arr[i + 1]){
                    swap(arr, i, i + 1);
                }
            }
            n -= 1;
        }
    }

    // 插入排序
    public static void insertionSort(int[] arr){

        int n = arr.length;
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 1; i < n; i++){
            for(int j = i; j > 0 && arr[j] < arr[j - 1]; j--){
                swap(arr, j, j - 1);
            }
        }
    }

}
