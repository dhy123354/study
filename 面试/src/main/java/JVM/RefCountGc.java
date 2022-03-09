package JVM;

public class RefCountGc {
    //这个成员属性的唯一作用就是占用一定内存
    private byte[] bigSize = new byte[5*1024*1024];
    //引用
    Object reference = null;

    public static void main(String[] args) {

        RefCountGc obj1 = new RefCountGc();
        RefCountGc obj2 = new RefCountGc();

        obj1.reference = obj2;
        obj2.reference = obj1;

        obj1 = null;
        obj2 = null;
        //显示的执行垃圾收集行为，判断obj1 和 obj2是否被回收？
        System.gc();
    }

}
