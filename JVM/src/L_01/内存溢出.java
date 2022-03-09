package L_01;

public class 内存溢出 {
    /**
     * 演示栈内存溢出 java.lang.StackOverflowError
     * -Xss256k 可以通过栈内存参数 设置栈内存大小
     */
        private static int count;

        public static void main(String[] args) {
            try {
                method1();
            } catch (Throwable e) {
                e.printStackTrace();
                System.out.println(count);
            }
        }

        private static void method1() {
            count++;// 统计栈帧个数
            method1();// 方法无限递归，不断产生栈帧 到虚拟机栈
        }
}
