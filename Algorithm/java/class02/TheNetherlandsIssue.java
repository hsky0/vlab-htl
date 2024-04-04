package class02;
import include.globalFunc;


public class TheNetherlandsIssue {
    public static void main(String[] args) {
        int n = 8;
        int V = 10;
        int[] arr = globalFunc.randomArray(n, V);
        globalFunc.printArray(arr);
        theNetherlandsIssue_v1(arr, 5);
        globalFunc.printArray(arr);
        theNetherlandsIssue_v2(arr, 5);
        globalFunc.printArray(arr);
    }

    public static void theNetherlandsIssue_v1(int[] arr, int num){
        int i = 0;
        int leftptr = -1;
        while (i < arr.length) {
            if(arr[i] <= num){
                int temp = arr[i];
                arr[i] = arr[leftptr + 1];
                arr[leftptr + 1] = temp;
                i++;
                leftptr++;
            }
            else{
                i++;
            }
        }
    }

    public static void theNetherlandsIssue_v2(int[] arr, int num){
        int i = 0;
        int leftptr = -1;
        int rightptr = arr.length;
        while (rightptr > i) {
            if(arr[i] < num){
                int temp = arr[i];
                arr[i] = arr[leftptr + 1];
                arr[leftptr + 1] = temp;
                i++;
                leftptr++;
            }
            else if(arr[i] == num){
                i++;
            }
            else{
                int temp = arr[i];
                arr[i] = arr[rightptr - 1];
                arr[rightptr - 1] = temp;
                rightptr--;
                
            }
        }
    }
}
