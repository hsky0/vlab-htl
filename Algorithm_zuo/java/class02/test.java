package class02;

public class test {
    

    public static void main(String[] args) {
        
        int N = 2000;     //数组长度的最大值
        int V = 10000;  //数组元素的最大值
        int testTimes = 100000;     //测试次数

        System.out.println("测试开始");
        for(int i = 0; i < testTimes; i++){

            int n = (int)(Math.random() * N);     //0~N-1之间的随机数
            int[] arr = randomArray(n, V);        //得到一个随机数组，长度为N
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);

            //排序

            //测试
            if(!sameArray(arr1, arr2) || !sameArray(arr1, arr3)){

                System.out.println("出现错误！");
            }
            
        }
        System.out.println("测试结束");
    }


    public static int[] randomArray(int n, int V){
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = (int)(Math.random() * V) + 1;
        }

        return arr;
    }

    public static int[] copyArray(int[] arr){

        int n = arr.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = arr[i];
        }

        return ans;
    }

    public static boolean sameArray(int[] arr1, int[] arr2){

        int n = arr1.length;
        for(int i = 0; i < n; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }

        }

        return true;
    }

    public static void swap(int [] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
