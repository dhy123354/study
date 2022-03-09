package JVM;

import java.lang.ref.Reference;

public class PhantomReferenceTest {

    //当前类对象的声明
    public static  PhantomReferenceTest obj;
    //引用队列
    static Reference<PhantomReferenceTest> phantomQueue = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("调用当前类的finalize方法");
        obj = this;
    }

    public static void main(String[] args) {

    }
}
