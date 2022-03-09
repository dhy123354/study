package 数据结构基础.Stack;

public class Mian {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(11);
        stack.push(12);
        stack.push(12);
        stack.push(121);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
