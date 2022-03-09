package com;

public class Demo {
    public static Demo demo = new Demo();
    int a = 0;
    boolean flag = false;

    public  void method01(){
        a = 1;
        flag = true;
    }

    public void method02(){
        if (flag){
            a = a + 5;
            System.out.println("******reValue:" + a);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                demo.method01();
            },String.valueOf(i)).start();
            new Thread(()->{
                demo.method02();
            },String.valueOf(i)).start();
        }
    }
}
