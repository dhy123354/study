package 面试;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String[] split = sc.nextLine().split(",");
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[0]);
            }

        }
    }
}

class Singing{

    private static Singing singing = null;
    private static String name;

    private Singing(String name){
        this.name = name;
    }

    public void display(String name){
        if (singing == null){
            synchronized (Singing.class){
                if (singing == null){
                    singing = new Singing(name);
                }
            }
        }
    }
}