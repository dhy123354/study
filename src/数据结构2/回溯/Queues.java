package 数据结构2.回溯;
//思路一 ———— 暴力检索
//从64个格子里面选出8个格子，检查每一种摆法的可行性
//一共有44亿种
//思路二 ————根据题意减小暴力程度
//每一行只能放一个皇后所以共有16777215种摆法，检查每一种可行性
import java.awt.color.ColorSpace;
import java.util.List;

public class Queues {
    public static void main(String[] args) {
        new Queues().placeQueue(4);
    }

    /*
    *   数组索引是行号，数组元素是列号
     */
     int[] cols;
     int ways;

     void placeQueue(int n){
        if (n < 1) return;
        cols = new int[n];
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
            if (isValid(row,col)){
                cols[row] = col;
                place(row + 1);
            }
        }
    }

    /**
     * 判断第row行第cols列是否可以摆放皇后
     * @param row
     * @param col
     * @return
     */
    boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 第col列已经有皇后
            if (cols[i] == col) {
                System.out.println("[" + row + "][" + col + "]=false");
                return false;
            }
            // 第i行的皇后跟第row行第col列格子处在同一斜线上
            if (row - i == Math.abs(col - cols[i])) {
                System.out.println("[" + row + "][" + col + "]=false");
                return false;
            }
        }
        System.out.println("[" + row + "][" + col + "]=true");
        return true;
    }

    void show(){
        for (int i = 0; i < cols.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (cols[i] == j){
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
