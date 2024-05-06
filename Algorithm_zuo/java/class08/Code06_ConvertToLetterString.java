package class08;

public class Code06_ConvertToLetterString {
    

    public static int number(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        char[] chs = str.toCharArray();
        return process(chs, 0);
    }

    // i之前的位置已经做过决定了
    // i...有多少种转化的结果
    public static int process(char[] str, int i){
        if(i == str.length){
            return 1;
        }
        if(str[i] == '0'){
            return 0;
        }
        if(str[i] == '1'){
            int res = process(str, i + 1);
            if(i + 1 < str.length){
                res += process(str, i + 2);
            }
            return res;
        }
        if(str[i] == '2'){
            int res = process(str, i + 1);
            if(i + 1 < str.length && str[i + 1] >= '0' && str[i + 1] <= '6'){
                res += process(str, i + 2);
            }
            return res;
        }
        return process(str, i + 1);
        
    }


    public static void main(String[] args) {
        System.out.println(number("345612"));
    }
}
