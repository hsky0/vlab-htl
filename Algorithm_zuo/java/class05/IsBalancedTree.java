package class05;

public class IsBalancedTree{

    public static class Node {
    
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static boolean isBalancedTree(Node head){
        return process(head).isBalanced;
    }

    public static class ReturnType{
        public boolean isBalanced;
        public int height;
        public ReturnType(boolean isB, int hei){
            isBalanced = isB;
            height = hei;
        }
    }

    public static ReturnType process(Node x){
        if(x == null){
            return new ReturnType(true, 0);
        }

        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
            && Math.abs(leftData.height - rightData.height) < 2;
        
        return new ReturnType(isBalanced, height);
    }

    public static void main(String[] args) {
        
    }
}