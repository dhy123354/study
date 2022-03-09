package 数据结构基础.Stack;

//缩容

public class ArrayList2<E> {
    /**
     * 元素的数量
     */
    private int size;
    /**
     * 所有的元素
     */
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList2(int capaticy) {
        capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
        elements =  (E[]) new Object[capaticy];
    }

    public ArrayList2() {
        this(DEFAULT_CAPACITY);
    }
    public void add(E element){
        add(size,element);
    }
    public void clear(){
        for (int i = 1;i<size;i++){
            elements[i] = null;
        }
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if (size==0) return true;
        else return false;
    }
    public boolean contains(int element){
        return false;
    }

    public E get(int index){
        rangeCheck(index);
        return elements[index];//O(1)
    }
    public E set(int index,E element){
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity ) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElement = (E[]) new Object[newCapacity];
        for (int i =0;i<size;i++){
            newElement[i] = elements[i];
        }
        elements = newElement;

        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    private void trim(){
        int capacity = elements.length;
        int newcapacity = capacity>>1;
        if (size >=(capacity>>1)||capacity<=DEFAULT_CAPACITY){
            return;
        }

        E[] newelement = (E[]) new Object[newcapacity];
        for (int i =0;i<size;i++){
            newelement[i] = elements[i];
        }
        elements = newelement;
        System.out.println(capacity + "缩容为：" + newcapacity);

    }
    /*
           最好O（n）
           最坏O（1）
           平均O（n）
    */
    public void add(int index,E element){
        rangeCheck(index);

        ensureCapacity(size+1);
        for (int i= size;i>index;i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
        return ;
    }//O(n)n是数据规模，此处n就是size


    public E remove(int index){
        //rangeCheck(index);
        trim();
        E oldElement = elements[index];
        for (int i =index ;i<size;i++){
            elements[i] = elements[i+1];
        }
        size--;
        elements[size] = null;
        return oldElement;
    }
    public int indexOf(E element){
        for (int i =0;i<size;i++){
            if (elements.equals(element))
                return i;
        }
        return -1;
    }



    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(",[");


        for (int i = 0 ;i<size;i++){

            if (i != 0){
                string.append(",");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }

    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }
}