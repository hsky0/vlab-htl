package class08;

public class Code08_CardsInLine {
    
    public static int win1(int[] arr){

        if(arr == null || arr.length == 0){
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }


    // arr[i..j]，i， j分别表示数组的左右边界
    public static int f(int[] arr, int i, int j){
        if(i == j){
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + f(arr, i, j - 1));
    }

    public static int s(int[] arr, int i, int j){
        if(i == j){
            return arr[i];
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 10, 6};
        int win = win1(a);
        System.out.println("the value of win = " + win); 
    }
}
