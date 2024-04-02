package class02;

public class GetMax {

    public static void main(String[] args) {
        int n = 10;             // 数组长度
        int V = 100;            //数组元素的最大值
        int arr[] = randomArray(n, V);
        int maxValue = getMax(arr);
        printArray(arr);
        System.out.println(maxValue);
    }

    public static int getMax(int[] arr){
        return process(arr, 0, arr.length - 1);
    }

    // 找到数组arr[L...R]范围内的最大值
    public static int process(int[] arr, int L, int R){
        if(L == R){         // base case
            return arr[L];
        }

        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

    // 产生一个随机数组，数组长度为n，数组元素的最大值为V
    public static int[] randomArray(int n, int V){
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = (int)(Math.random() * V + 1);
        }

        return arr;
    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}