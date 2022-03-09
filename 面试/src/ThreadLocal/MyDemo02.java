public class MyDemo02 {
    public  static ThreadLocal<String> t1 = new ThreadLocal<>();

    private String content;

    public  String getContent() {
        return t1.get();
    }

    public void setContent(String content) {
        t1.set(content);
    }

    public static void main(String[] args) {
        MyDemo02 myDemo01 = new MyDemo02();
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                myDemo01.setContent(Thread.currentThread().getName() + "的数据");
                System.out.println("---------------------");
                System.out.println(Thread.currentThread().getName() + "-->" + myDemo01.getContent());
            },"线程" + i).start();
        }
    }
}
