package class08;

import java.util.ArrayList;
import java.util.List;

public class Code03_PrintAllPermutations {

    public static List<String> permute(String str) {
        List<String> result = new ArrayList<>();
        permuteHelper(str.toCharArray(), 0, result);
        return result;
    }

    private static void permuteHelper(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permuteHelper(chars, index + 1, result);
            swap(chars, index, i); // 恢复原始顺序，进行下一次排列
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


    public static List<String> permutation_r1(String str){
        List<String> res = new ArrayList<>();
        if(str == null || str.length() == 0){
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        return res;
    }

    public static void process(char[] str, int index, List<String> res){
        if(index == str.length){
            res.add(String.valueOf(str));
            return;
        }
        boolean[] visit = new boolean[26];
        for(int i = index; i < str.length; i++){
            if(!visit[str[i] - 'a']){
                visit[str[i] - 'a'] = true;
                swap(str, index, i);
                process(str, index + 1, res);
                swap(str, index, i);
            }
            
        }
        

    }

    public static void main(String[] args) {
        String str = "abc";
        // List<String> permutations = permute(str);
        List<String> permutations = permutation_r1(str);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
