package 数据结构2.回溯;

public class Queues2 {
    public static void main(String[] args) {
        new Queues2().placeQueue(8);
    }

    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] queens;
    /**
     * 标记着某一列是否有皇后
     */
    boolean[] cols;
    /**
     * 标记着某一斜线上是否有皇后（左上角 -> 右下角）
     */
    boolean[] leftTop;
    /**
     * 标记着某一斜线上是否有皇后（右上角 -> 左下角）
     */
    boolean[] rightTop;
    /**
     * 一共有多少种摆法
     */
    int ways;

    void placeQueue(int n){
        if (n < 1) return;
        queens = new int[n];
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
        place(0);
        System.out.println(n + "皇后一共有" + ways + "种摆法");
    }

    /**
     * 从 row 行开始摆放
     * @param row 行开始摆放
     */
    void place(int row){
        if (row == cols.length){
            ways++;
            show();
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            //剪枝
            if (cols[col]) continue;
            int ltIndex = row - col + cols.length - 1;
            if (leftTop[ltIndex]) continue;
            int rtIndex = row +col;
            if (rightTop[rtIndex]) continue;

            queens[row] = col;
            cols[col] = true;
            leftTop[ltIndex] = true;
            rightTop[rtIndex] = true;
            place(row + 1);
            /**
             * boolen类型的回溯需要重置
             */
            cols[col] = false;
            leftTop[ltIndex] = false;
            rightTop[rtIndex] = false;
        }
    }

    void show(){
        for (int i = 0; i < cols.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (queens[i] == j){
                    System.out.print("1 ");
                }else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
}
