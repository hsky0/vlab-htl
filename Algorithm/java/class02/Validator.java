package class02;

public class Validator {
    

    public static void main(String [] args){

        int N = 100;    //随机数组最大的长度
        int V = 1000;   //随机产生的数：0~V

        // 测试次数
        int testTimes = 10;
        System.out.println("测试开始...");
        for(int i = 0; i < testTimes; i++){

            // 随机得到一个长度，值在0~N之间
            int n = (int)(Math.random() * N);        //random()等概率产生[0,1)之间的小数

            // 得到随机数组
            int[] arr = randomArray(n, V);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            // 进行排序
            
            // 测试
            if(!sameArray(arr1, arr2) || !sameArray(arr1, arr3)){

                // 算法出现错误
                System.out.println("出现错误！请检查你的算法！");
            }
            
        }
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

    // 选择排序
    
}
