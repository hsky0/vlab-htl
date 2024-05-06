package class08;

import java.util.Stack;

// 使用递归方法逆序一个栈并且不申请额外的数据结构
public class Code04_ReverseStackUsingRecursive {
    

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = f(stack);       // f函数可将栈底元素
        reverse(stack);
        stack.push(i);
    }

    public static int f(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
        

    }

    public static void PrintStack(Stack<Integer> stack){
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static Stack<Integer> copyStack(Stack<Integer> stack){
        Stack<Integer> res = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        while (!stack2.isEmpty()) {
            int temp = stack2.pop();
            stack.push(temp);
            res.push(temp);
        }
        return res;
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Stack<Integer> copyStack = copyStack(stack);
        PrintStack(copyStack);


        System.out.println("=======================");
        reverse(stack);
        PrintStack(stack);
    }
}
