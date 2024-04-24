package class08;

import java.util.ArrayList;
import java.util.List;

public class Code02_PrintAllSubsquence {
    

    public static void printAllSubsequnence(String str){
        char[] chs = str.toCharArray();
        process1(chs, 0);
    }

    public static void process1(char[] str, int i){
        if(i == str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        process1(str, i + 1);
        char temp = str[i];
        str[i] = 0;
        process1(str, i + 1);
        str[i] = temp;
    }

    public static void function(String str){
        char[] chs = str.toCharArray();
        process(chs, 0, new ArrayList<Character>());
    }

    public static void process(char[] str, int i, List<Character> res){
        if(i == str.length){
            printList(res);
            return;
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(str[i]);
        process(str, i + 1, resKeep);                   // 要当前的字符
        List<Character> resNoInclude = copyList(res);
        process(str, i + 1, resNoInclude);              // 不要当前的字符
    }

    public static void printList(List<Character> res){
        for(int i = 0; i < res.size(); i++){
            System.out.print(res.get(i));
        }
        System.out.println();
    }   

    public static List<Character> copyList(List<Character> list){
        List<Character> res = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            res.add(list.get(i));
        }
        return res;

    }

    

    public static void main(String[] args) {
        
        String str = "htl";
        function(str);
        System.out.println("============================");
        printAllSubsequnence(str);
    }
}
