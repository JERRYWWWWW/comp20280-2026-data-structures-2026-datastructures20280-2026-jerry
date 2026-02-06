package project20280.list;

public class ArrayDeque<E> {
    private E[] data;
    private int f = 0; // 队头索引
    private int sz = 0; // 大小

    public ArrayDeque(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() { return sz; }
    public boolean isEmpty() { return sz == 0; }

    // 在前端添加
    public void addFirst(E e) {
        if (sz == data.length) throw new IllegalStateException("Deque is full");
        // 向后倒退一格，如果小于0则绕到数组末尾
        f = (f - 1 + data.length) % data.length;
        data[f] = e;
        sz++;
    }

    // 在后端添加 (同 Queue enqueue)
    public void addLast(E e) {
        if (sz == data.length) throw new IllegalStateException("Deque is full");
        int avail = (f + sz) % data.length;
        data[avail] = e;
        sz++;
    }

    // 移除前端 (同 Queue dequeue)
    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }

    // 移除后端
    public E removeLast() {
        if (isEmpty()) return null;
        // 计算最后一个元素的索引
        int last = (f + sz - 1) % data.length;
        E answer = data[last];
        data[last] = null;
        sz--;
        // 注意：removeLast 不需要移动 f，只需要减小 size
        return answer;
    }
}