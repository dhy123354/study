package com.类加载器;

public class ClassloaderDemo {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);

        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

    }
}
