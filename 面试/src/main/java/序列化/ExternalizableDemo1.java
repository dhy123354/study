package 序列化;

import java.io.*;

public class ExternalizableDemo1 {
    public static void main(String[] args) {
        User02 user02 = new User02();
        user02.setName("丁慧源");
        user02.setAge(22);
        System.out.println(user02);
        try {
            ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oss.writeObject(user02);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("tempFile");
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            User02 newUser02 = (User02) ois.readObject();
            System.out.println(newUser02);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}