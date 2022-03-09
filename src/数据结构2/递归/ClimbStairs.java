package 数据结构2.递归;

public class ClimbStairs {
    int climbStairs1(int n){
        if (n <= 2) return n;
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    //优化
    int climbStairs(int n){
        if (n <= 2) return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();

        Times.test("climbStairs1",() ->{
            System.out.println(climbStairs.climbStairs1(10));
        });

        Times.test("climbStairs0",() ->{
            System.out.println(climbStairs.climbStairs(10));
        });
    }
}
