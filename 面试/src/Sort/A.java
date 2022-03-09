import java.util.*;

public class A{

    public enum Dogs{collie,harrier}

    public static void main(String[] args) {
        int x = 0;
        int y = 10;
        do{
            y--;
            x++;
        }while (x < 5);
        System.out.println(x + ":" + y);
    }

}