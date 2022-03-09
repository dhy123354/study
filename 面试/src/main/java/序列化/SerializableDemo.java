package 序列化;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) {
        //Initializes The Object
        User user = new User();
        user.setName("cosen");
        user.setAge(22);
        System.out.println(user);
        //Write Obj to File
        try (FileOutputStream fos = new FileOutputStream("tempFile");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Read Obj from File
        File file = new File("tempFile");
        try (ObjectInputStream ois = new ObjectInputStream(new
                FileInputStream(file))) {
            User newUser = (User)ois.readObject();
            System.out.println(newUser);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
