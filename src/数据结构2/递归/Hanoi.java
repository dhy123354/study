package 数据结构2.递归;

public class Hanoi {
    /**
     * 将 no 号盘子从 from 移动到 to
     * @param
     * @param from
     * @param to
     */
    void move(int i ,String from ,String to){
        System.out.println(i + "号盘子：" + from + "->" + to);
    }

    /**
     * 将 n 个碟子从 p1 挪动到 p3
     * @param p2 中间的柱子
     */
    void hanoi(int n, String p1, String p2 ,String p3){
        if (n <= 1) {
            move(n,p1,p3);
            return;
        }

        hanoi(n - 1, p1 , p3, p2);
        move(n,p1,p3);
        hanoi(n - 1, p2, p1, p3);
    }

    public static void main(String[] args) {
        new Hanoi().hanoi(3,"A","B","C");
    }
}
