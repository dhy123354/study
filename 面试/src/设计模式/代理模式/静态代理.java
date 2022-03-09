package 代理模式;

public class 静态代理 {

    public static void main(String[] args) {
        ProxySubject subject = new ProxySubject(new RealSubject());
        subject.visit();
    }
}

interface Subject{
    void visit();
}

class RealSubject implements Subject{
    private String name = "丁慧源";
    @Override
    public void visit() {
        System.out.println(name);
    }
}

class ProxySubject implements Subject{
    private Subject subject;
    public ProxySubject(Subject subject){
        this.subject = subject;
    }

    @Override
    public void visit() {
        subject.visit();
    }
}
