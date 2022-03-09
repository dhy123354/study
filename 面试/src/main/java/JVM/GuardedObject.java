package JVM;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class GuardedObject {

    private int id;

    public GuardedObject(int id){
        this.id = id;
    }

    public int getId(){return id;};

    private Object response;

    public Object get(long timeout){
        synchronized (this){
            long begin = System.currentTimeMillis();
            long passedTime = 0;
            while (response == null){
                long waitTime = timeout - passedTime;
                if (timeout - passedTime <= 0){
                    break;
                }
                try {
                    this.wait(waitTime);
                }catch (Exception e){
                    e.printStackTrace();
                }
                passedTime = System.currentTimeMillis() - begin;
            }
            return response;
        }
    }

    public void complete(Object response){
        synchronized (this){
            this.response = response;
            this.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new People().start();
        }
        Thread.sleep(1000);
        for (Integer id : MailBoxes.getIds()) {
            new Postman(id,":内容" + id).start();
        }
    }
}

class MailBoxes{
    private static Map<Integer,GuardedObject> boxes = new Hashtable<>();

    private static int id = 1;

    //产生唯一性的id
    private static synchronized int generateId(){
        return id++;
    }

    public static GuardedObject getGuardedObject(int id) {
        return boxes.remove(id);
    }
    public static GuardedObject createGuardedObject() {
        GuardedObject go = new GuardedObject(generateId());
        boxes.put(go.getId(), go);
        return go;
    }
    public static Set<Integer> getIds() {
        return boxes.keySet();
    }
}

class People extends Thread{
    @Override
    public void run() {
        //收信
        GuardedObject guardedObject = MailBoxes.createGuardedObject();
        System.out.println("开始收信 Id：" + guardedObject.getId());
        Object mail = guardedObject.get(5000);
        System.out.println("收到信 Id：" + guardedObject.getId() + "内容：" + mail);
    }
}

class Postman extends Thread {
    private int id;
    private String mail;
    public Postman(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }
    @Override
    public void run() {
        GuardedObject guardedObject = MailBoxes.getGuardedObject(id);
        System.out.println("送信 Id：" + id + "内容：" + mail);
        guardedObject.complete(mail);
    }
}
