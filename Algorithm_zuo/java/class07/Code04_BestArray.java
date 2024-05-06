package class07;

import java.util.Arrays;
import java.util.Comparator;

public class Code04_BestArray {
    
    public static class Program {
        
        public int start;
        public int end;
        
        public Program(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {
        public int compare(Program o1, Program o2){
            return o1.end - o2.end;
        }
        
    }


    // 返回最多能安排多少个会议数
    public static int bestArrange(Program[] programs, int timePoint){
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for(int i = 0; i < programs.length; i++){
            if(timePoint <= programs[i].start){
                result++;
                timePoint = programs[i].end;
            }
        }
        return result;
    }
}
