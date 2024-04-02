package include;
public class globalFunc {
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
