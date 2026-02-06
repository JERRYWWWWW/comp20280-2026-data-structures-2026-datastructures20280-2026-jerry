package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {

    private static class Node<E> {
        private final E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e, Node<E> p, Node<E> n) {
            data = e;
            prev = p;
            next = n;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }


        public void setNext(Node<E> n) {
            next = n;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }
    }


    private final Node<E> head;
    private final Node<E> tail;
    private int size = 0;

    public DoublyLinkedList() {
        head = new Node<>(null, null, null);      // header
        tail = new Node<>(null, head, null);     // trailer 的 prev 指向 head
        head.setNext(tail);                      // head 的 next 指向 tail
    }


    private void addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) {
        if (i < 0 || i >= size) return null;
        Node<E> curr = head.getNext();
        for (int j = 0; j < i; j++) curr = curr.getNext();
        return curr.getData();
    }

    @Override
    public void add(int i, E e) {
        if (i <= 0) addFirst(e);
        else if (i >= size) addLast(e);
        else {
            Node<E> curr = head.getNext();
            for (int j = 0; j < i; j++) curr = curr.getNext();

            addBetween(e, curr.getPrev(), curr);
        }
    }

    @Override
    public E remove(int i) {
        if (i < 0 || i >= size) return null;
        Node<E> curr = head.getNext();
        for (int j = 0; j < i; j++) curr = curr.getNext();
        return remove(curr);
    }


    private E remove(Node<E> n) {
        Node<E> pred = n.getPrev();
        Node<E> succ = n.getNext();
        pred.setNext(succ);
        succ.setPrev(pred);
        size--;
        return n.getData();
    }

    @Override
    public void addFirst(E e) {
        addBetween(e, head, head.getNext());
    }

    @Override
    public void addLast(E e) {
        addBetween(e, tail.getPrev(), tail);
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(head.getNext());
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(tail.getPrev());
    }

    public E first() {
        if (isEmpty()) return null;
        return head.getNext().getData();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getPrev().getData();
    }

    private class DoublyLinkedListIterator implements Iterator<E> {
        private Node<E> curr = head.getNext();

        @Override
        public boolean hasNext() {
            return curr != tail;
        }

        @Override
        public E next() {
            E res = curr.getData();
            curr = curr.getNext();
            return res;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = head.getNext();
        while (curr != tail) {
            sb.append(curr.getData());
            curr = curr.getNext();
            if (curr != tail) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(-1);
        System.out.println("Initial: " + ll); // [2, 1, 0, -1]

        ll.removeFirst();
        System.out.println("After removeFirst: " + ll); // [1, 0, -1]

        ll.removeLast();
        System.out.println("After removeLast: " + ll); // [1, 0]

        for (Integer e : ll) {
            System.out.println("value: " + e);
        }
    }
}