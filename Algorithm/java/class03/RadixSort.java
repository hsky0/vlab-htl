package class03;

import java.util.Arrays;

import class02.Validator;

/**
 * RadixSort
 */
public class RadixSort {

    public static void radixSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    // arr[L...R]排序，digit是数组arr中最大值的位数，如最大值为100，则digit为3
    public static void radixSort(int[] arr, int L, int R, int digit){
        final int radix = 10;       // 基数为10
        
        int i = 0, j = 0;
        
        // 准备辅助空间来存放每次出桶的数
        int[] bucket = new int[R - L + 1];
        for(int d = 1; d <= digit; d++){        // 有多少位就进出多少次
            int[] count = new int[radix];       // 记录频次的辅助数组, count[0...9]
            for(i = L; i <= R; i++){
                j = getDigit(arr[i], d);        // 得到数数组元素第d位上的值，将其赋值给j
                count[j]++;
            }
            for(i = 1; i < radix; i++){
                count[i] = count[i] + count[i - 1];     // 计算前缀和
            }
            for(i = R; i >= L; i--){                    // 出桶，从右往左遍历辅助数组
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for(i = L, j = 0; i<= R; i++, j++){
                arr[i] = bucket[j];
            }

        }

    }

    public static int maxbits(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        int res = 0;
        while (max != 0) {
            res++;
            max = max / 10;
        }

        return res;
    }

    // 得到数组元素第d位的值
    public static int getDigit(int value, int d){
        int res = 0;
        while (d > 1) {
            value = value / 10;
            d--;
        }

        res = value % 10;
        return res;
    }
    

    public static void radixSort1(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        radixSort1(arr, 0, arr.length - 1, maxbits1(arr));
    }

    public static void radixSort1(int[] arr, int L, int R, int digit){

        final int radix = 10;
        int i = 0, j = 0;
        int[] bucket = new int[R - L + 1];
        for(int d = 1; d <= digit; d++){
            int[] count = new int[radix];
            for(i = L; i <= R; i++){
                j = getDigit1(arr[i], d);
                count[j]++;
            }
            for(i = 1; i < radix; i++){
                count[i] = count[i] + count[i - 1];
            }
            for(i = R; i >= L; i--){
                j = getDigit1(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            // for(i = L, j = 0; i <= R; i++, j++){
            //     arr[i] = bucket[j];
            // }
            for(i = 0; i < arr.length; i++){
                arr[i + L] = bucket[i];
            }
        }
    }

    public static int maxbits1(int[] arr){
        int d = 0;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(res < arr[i]){
                res = arr[i];
            }
        }
        while (res != 0) {
            d++;
            res = res / 10;
        }

        return d;
    }

    public static int getDigit1(int value, int d){
        int res = 0;
        while (d > 1) {
            value = value / 10;
            d--;
        }
        res = value % 10;
        return res;
    }

    public static void main(String[] args) {
        
        int n = 100;
        int V = 1000;
        int testTimes = 100000;
        Validator.validator(Validator::selectionSort, RadixSort::radixSort1, n, V, testTimes, true);
        Validator.validator(Arrays::sort, RadixSort::radixSort1, n, V, testTimes, true);
    }
    

}
