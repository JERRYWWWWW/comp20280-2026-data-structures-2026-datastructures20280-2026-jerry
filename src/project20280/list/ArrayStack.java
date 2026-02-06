package project20280.list;

public class ArrayStack<E> {
    public static final int CAPACITY = 1000; // 默认容量
    private E[] data;
    private int t = -1; // 栈顶索引，空栈时为-1

    public ArrayStack() { this(CAPACITY); }
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() { return t + 1; }
    public boolean isEmpty() { return t == -1; }

    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e; // 先增加索引，再存值
    }

    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null; // 帮助垃圾回收
        t--; // 降低栈顶索引
        return answer;
    }

    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }
}