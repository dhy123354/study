package JVM;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.IOException;
import java.util.*;

public class 异步模式之生产者_消费者 {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(6);
        for (int i = 0; i < 10; i++) {
            int id = i;
            new Thread(()->{
                System.out.println("下载了.....");
                List<String> response = new ArrayList<>();
                response.add("1");
                response.add("2");
                response.add("3");
                System.out.println("try put message:" + id);
                messageQueue.put(new Message(id,response));
            },"生产者" + i).start();
        }

        new Thread(() -> {
            while (true) {
                Message message = messageQueue.take();
                List<String> response = (List<String>) message.getMessage();
                System.out.println("take message({}): [{}] lines" + message.getId() + response.size());
            }
        }, "消费者").start();

    }
}

class Message{
    private int id;
    private Object message;

    public Message(int id,Object message){
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}

class MessageQueue{
    private LinkedList<Message> queue;
    private int capacity;

    public MessageQueue(int capacity){
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public Message take(){
        synchronized (queue){
            while (queue.isEmpty()){
                System.out.println("没货了，wait");
                try {
                    queue.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            Message message = queue.removeFirst();
            queue.notifyAll();
            return message;
        }
    }

    public void put(Message message){
        synchronized (queue){
            while (queue.size() == capacity){
                System.out.println("库存已达到上限，wait");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.addLast(message);
                queue.notifyAll();
            }
        }
    }
}