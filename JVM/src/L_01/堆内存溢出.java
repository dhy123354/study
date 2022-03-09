package L_01;

import java.util.ArrayList;
import java.util.List;

public class 堆内存溢出 {
    /**
     * 演示堆内存溢出 java.lang.OutOfMemoryError: Java heap space
     * -Xmx8m 最大堆空间的jvm虚拟机参数，默认是4g
     */
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();// new 一个list 存入堆中-------- list的有效范围  ---------
            String a = "hello";
            while (true) {// 不断地向list 中添加 a
                list.add(a); // hello, hellohello, hellohellohellohello ...
                a = a + a;  // hellohellohellohello
                i++;
            }//------------------------------------------------------------------ list的有效范围  ---------
        } catch (Throwable e) {// list 使用结束，被jc 垃圾回收
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
