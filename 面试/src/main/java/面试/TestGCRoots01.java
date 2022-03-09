package 面试;


import java.util.*;

public class TestGCRoots01 {

    private byte[] memory = new byte[8 * 10 * 1024 * 1024];

    public static void main(String[] args) {
        method01();
        System.out.println("返回main方法");
        System.gc();
        System.out.println("第二次GC完成");
    }

    public static void method01() {
        TestGCRoots01 t = new TestGCRoots01();
        System.gc();
        System.out.println("第一次GC完成");
    }
}
