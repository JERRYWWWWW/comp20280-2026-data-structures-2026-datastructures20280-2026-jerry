package project20280.list;

public class LinkedStack<E> {
    // 内部节点类
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n) { element = e; next = n; }
    }

    private Node<E> head = null; // 栈顶
    private int size = 0;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void push(E e) {
        head = new Node<>(e, head); // 新节点指向旧head，并成为新head
        size++;
    }

    public E pop() {
        if (isEmpty()) return null;
        E answer = head.element;
        head = head.next; // head指向下一个节点
        size--;
        return answer;
    }

    public E top() {
        if (isEmpty()) return null;
        return head.element;
    }
}