package class05;

public class PaperFolding {
    
    public static void printAllFolds(int N){
        printProcess(1, N, true);  // 第一次调用头节点，头节点为凹
    }

    // 递归过程，来到某一节点
    // i是节点的层数，N是一共的层数，down == true 表示凹，down == false 表示凸
    public static void printProcess(int i, int N, boolean down){
        if(i > N){
            return;
        }

        printProcess(i + 1, N, true);       // 左子树的头节点都是凹
        System.out.print(down ? "凹" + " ": "凸" + " ");
        printProcess(i + 1, N, false);
    }



    public static void main(String[] args) {
        int N = 4;
        printAllFolds(N);
        System.out.println();
    }
}
