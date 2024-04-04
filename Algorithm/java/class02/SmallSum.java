package class02;
import include.globalFunc;


public class SmallSum {
    

    public static void main(String[] args) {
        int n = 5;
        int V = 10;
        //int[] arr = globalFunc.randomArray(n, V);
        int[] arr = {1, 2, 4, 5, 10};
        globalFunc.printArray(arr);
        int res = smallSum(arr);
        globalFunc.printArray(arr);
        System.out.println(res);

    }

    public static int smallSum(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }

        return process(arr, 0, arr.length - 1);
    }

    // arr[L...R]既要排好序，也要求小和
    public static int process(int[] arr, int L, int R){
        if(L == R){
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    //将两个有序列表合并并实现整体有序
    public static int merge(int[] arr, int L, int M, int R){
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int res = 0;
        while (p1 <= M && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[i + L] = help[i];
        }

        return res;
    }
}
