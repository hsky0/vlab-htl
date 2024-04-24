package class08;

public class Code09_NQueens {
    
    public static int num1(int n){
        if(n < 1){
            return 0;
        }

        // record[0] ? record[1] ? record[2]
        int[] record = new int[n];  // record[i] -> 第i行的皇后，放在了第几列
        return process1(0, record, n);
    }

    // 目前来到第i行
    // record[0,,i-1]表示之前的行，放的皇后
    // 返回值：摆完所有的皇后，合理的摆法有多少种
    public static int process1(int i, int[] record, int n){
        if(i == n){
            return 1;
        }
        int res = 0;
        for(int j = 0; j < n; j++){     // 尝试i行所有的列
            if(isValid(record, i, j)){
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j){
        for(int k = 0; k < i; k++){
            if(j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)){
                return false;
            }
        }
        return true;
    }

    public static int num1_1(int n){
        if(n < 1){
            return 0;
        }

        int[] record = new int[n];
        return process1_1(0, record, n);
    }


    // 第i行的皇后应该放在第几列
    // 潜台词：record[0...i-1]的皇后，任何两个皇后不同行，不同列，不共斜线
    // record[i]记录第i行的皇后放在第j列
    public static int process1_1(int i, int[] record, int n){
        if(i == n){
            return 1;
        }
        int res = 0;
        
        // 来到第i行
        for(int j = 0; j < n; j++){
            if(isValid1_1(record, i, j)){  // 如果任意0...i行的任意两个皇后不共行，不共列，不共对角线，则记录该行皇后所在的列数
                record[i] = j;
                res += process1_1(i + 1, record, n);    // 进行下一行
            }
        }
        return res;
    }

    public static boolean isValid1_1(int[] record, int i, int j){
        for(int k = 0; k < i; k++){
            if(j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)){
                return false;
            }
        }
        return true;
    }

    public static int num2(int n){
        if(n < 1 || n > 32){
            return 0;
        }

        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    public static int process2(int limit, 
            int colLim,
            int leftDiaLim,
            int rightDiaLim){
                if(colLim == limit){
                    return 1;           // 找到了一种放法
                }
                int pos = 0;
                pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
                int mostRightOne = 0;
                int res = 0;
                while (pos != 0) {
                    mostRightOne = pos & (~pos  + 1);       // 提取pos最右边的1
                    pos = pos - mostRightOne;
                    res += process2(limit, 
                    colLim | mostRightOne, 
                    (leftDiaLim | mostRightOne) << 1, 
                    (rightDiaLim | mostRightOne) >> 1);
                }

                return res;

            }
    
    public static int num2_1(int n){
        if(n < 1 || n > 32){
            return 0;
        }
        
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2_1(limit, 0, 0, 0);
    }
    
    public static int process2_1(int limit, int colLim, int leftDiaLim, int rightDiaLim){
        
        if(limit == colLim){
            return 1;
        }
        
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2_1(limit, 
            colLim | mostRightOne, 
            (leftDiaLim | mostRightOne) << 1, 
            (rightDiaLim | mostRightOne) >> 1);
        }
        return res;
    }

    public static int num2_2(int n){
        if(n < 1 || n > 32){
            return 0;
        }

        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2_2(limit, 0, 0, 0);
    }

    public static int process2_2(int limit, int colLim, int leftDiaLim, int rightDiaLim){
        if(limit == colLim){
            return 1;
        }    

        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2_2(limit, colLim | mostRightOne, 
            (leftDiaLim | mostRightOne) << 1, 
            (rightDiaLim | mostRightOne) >> 1);
        }

        return res;

    }

    public static void main(String[] args) {
        int n = 8;
        long startTime, endTime;

        // startTime = System.currentTimeMillis();
        // int a = num1_1(n); 
        // endTime = System.currentTimeMillis();
        // System.out.println("num1 res = " + a);
        // System.out.println("cost time = " + (endTime - startTime) + "ms");

        // startTime = System.currentTimeMillis();
        // int b = num1_1(n); 
        // endTime = System.currentTimeMillis();
        // System.out.println("num1 res = " + b);
        // System.out.println("cost time = " + (endTime - startTime) + "ms");

        // startTime = System.currentTimeMillis();
        // int c = num2(n); 
        // endTime = System.currentTimeMillis();
        // System.out.println("num1 res = " + c);
        // System.out.println("cost time = " + (endTime - startTime) + "ms");

        // startTime = System.currentTimeMillis();
        // int d = num2_1(n); 
        // endTime = System.currentTimeMillis();
        // System.out.println("num1 res = " + d);
        // System.out.println("cost time = " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        int e = num2_2(n); 
        endTime = System.currentTimeMillis();
        System.out.println("num1 res = " + e);
        System.out.println("cost time = " + (endTime - startTime) + "ms");
    }
}
