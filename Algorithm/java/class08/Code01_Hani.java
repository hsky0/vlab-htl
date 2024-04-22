package class08;

public class Code01_Hani {
    

    public static void hani(int n){
        if(n > 0){
            func(n, "左", "右", "中");
        }
        
    }

    public static void func(int n, String start, String end, String other){
        if(n == 1){
            System.out.println("Move 1 from " + start + " to " + end);
        } else {
            func(n - 1, start, other, end);
            System.out.println("move " + n + " from " + start + " to " + end);
            func(n - 1, other, end, start);
        }
        
    }

    public static void main(String[] args) {
        int n = 3;
        hani(n);
    }
}
