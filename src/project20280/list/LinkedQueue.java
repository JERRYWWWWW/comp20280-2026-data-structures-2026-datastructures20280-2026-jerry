package project20280.list;

public class LinkedQueue<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n) { element = e; next = n; }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void enqueue(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest; // 如果之前为空，头也是它
        } else {
            tail.next = newest; // 旧尾指向新节点
        }
        tail = newest; // 更新尾指针
        size++;
    }

    public E dequeue() {
        if (isEmpty()) return null;
        E answer = head.element;
        head = head.next;
        size--;
        if (size == 0) {
            tail = null; // 必须处理：如果队列空了，tail也要置空
        }
        return answer;
    }

    public E first() {
        if (isEmpty()) return null;
        return head.element;
    }
}