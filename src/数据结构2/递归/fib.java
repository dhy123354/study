package 数据结构2.递归;

public class fib {
    int fib(int n){
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    int fib1(int n){
        if (n <= 2)return 1;
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        return fib1(n,array);
    }

    int fib1(int n, int[] array){
        if (array[n] == 0){
            array[n] = fib1(n - 1,array) + fib1(n - 2,array);
        }
        return  array[n];
    }

    int fib2(int n) {
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[2] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    //使用滚动数组的条件：1.每次运算只需要用到数组中的连续几个元素，可以使用滚动数组
    int fib3(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i % 2] = array[(i - 1) % 2] + array[(i - 2) % 2];
        }
        return array[n % 2];
    }

    /*
     * 4 % 2 = 0  0b100 & 0b001 = 0
     * 3 % 2 = 1  0b011 & 0b001 = 1
     * 5 % 2 = 1  0b101 & 0b001 = 1
     * 6 % 2 = 0  0b110 & 0b001 = 0
     */
    int fib3_1(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i & 1] = array[(i - 1) & 1] + array[(i - 2) & 1];
        }
        return array[n % 2];
    }

    int fib4(int n) {
        if (n <= 2) return 1;
        int first = 1;
        int second = 1;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

    int fib5(int n){
        return fib5(n,1,1);
    }

    int fib5(int n, int first, int second){
        if (n <= 1) return first;
        return fib5(n - 1,second, first + second);
    }
    public static void main(String[] args) {
        fib fib = new fib();
        Times.test("fib0",() ->{
            System.out.println(fib.fib(10));
        });

        Times.test("fib1",() ->{
            System.out.println(fib.fib1(10));
        });

        System.out.println(fib.fib2(10));

        Times.test("fib1",() ->{
            System.out.println(fib.fib3(10));
        });

        Times.test("fib1",() ->{
            System.out.println(fib.fib3_1(10));
        });

        Times.test("fib1",() ->{
            System.out.println(fib.fib4(10));
        });

        Times.test("fib5",() ->{
            System.out.println(fib.fib5(10));
        });
    }
}
