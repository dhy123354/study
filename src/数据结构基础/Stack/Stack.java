package 数据结构基础.Stack;

public class Stack<E>  {
    private ArrayList<E> list =  new ArrayList<E>();
    public boolean isEmpty(){
        return list.isEmpty();
    }

    public E pop(){
        return list.remove(list.size-1);
    }

    public void push(E element){
        list.add(element);
    }

    public int size(){
        return list.size;
    }
}
