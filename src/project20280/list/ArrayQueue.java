package project20280.list;

public class ArrayQueue<E> {
    private E[] data;
    private int f = 0; // 队头索引
    private int sz = 0; // 当前元素个数

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() { return sz; }
    public boolean isEmpty() { return sz == 0; }

    public void enqueue(E e) throws IllegalStateException {
        if (sz == data.length) throw new IllegalStateException("Queue is full");
        int avail = (f + sz) % data.length; // 计算队尾的下一个空位
        data[avail] = e;
        sz++;
    }

    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length; // 循环移动队头指针
        sz--;
        return answer;
    }

    public E first() {
        if (isEmpty()) return null;
        return data[f];
    }
}