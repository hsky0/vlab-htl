package class02;



public class timeTest {
    
    // public static void main(String[] args) {
    //     SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间 
    //     sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记  
    //     Date date = new Date();// 获取当前时间 
    //     System.out.println("现在时间：" + sdf.format(date)); // 输出已经格式化的现在时间（24小时制） 
    // }

    public static void main(String[] args) {
        int a = 0;
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++){
            a += i;
        }
        long stopTime = System.currentTimeMillis();

        System.out.println((stopTime - startTime) / 1000.0);
    }
}
