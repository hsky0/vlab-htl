package class02;
import java.util.Arrays;

import include.globalFunc;
public class QuickSort {

    public static void main(String[] args) {
        int n = 10;
        int V = 10;
        int[] arr = globalFunc.randomArray(n, V);
        globalFunc.printArray(arr);
        Arrays.sort(arr);
        globalFunc.printArray(arr);
        quickSort(arr);
        globalFunc.printArray(arr);
    }
    
    // 快排
    public static void quickSort(int[] arr){

        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr, 0, arr.length - 1);     
    }

    // 将数组arr[L...R]排好序
    public static void quickSort(int[] arr, int L, int R){
        if(L < R){
            swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);                         //对数组arr应用荷兰问题
            quickSort(arr, L, p[0] - 1);                            //对划分好的数组重新进行排序
            quickSort(arr, p[1] + 1, R);
        }
    }

    // 处理arr[L...R]的函数
    // 默认以arr[R]做划分，arr[R]是在数组中随机选出的值，并将其与数组的最后一个值做交换
    // 该函数对arr[L...R]进行处理，将 < arr[R]数放在左边，== 的数放在中间，> 的数放在右边(荷兰问题)
    // 该函数返回一个包含两个元素的数组，第一个元素为等于区域的左边界，第二个为右边界
    public static int[] partition(int[] arr, int L, int R){
        int less = L - 1;
        int more = R;
        while (L < more) {
            if(arr[L] < arr[R]){            // 表示当前数的位置，arr[R]  -> 划分值
                swap(arr, ++less, L++);     // 当前值与小于区的下一个数做交换，小于区往右扩，当前位置加一
            }
            else if(arr[L] > arr[R]){
                swap(arr, --more, L);       // 当前值与大于区的前一个数做交换，大于区往左扩，当前位置不变
            }
            else{
                L++;
            }
        }
        swap(arr, more, R);
        return new int[] {less + 1, more};
    }


    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
