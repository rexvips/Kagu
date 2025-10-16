package DSA.stack;

import java.util.NoSuchElementException;

public class LinkedStack<T> {
    private static final class Node<T> {
        T value;
        Node<T> next;
        Node(T value) { this.value = value; }
    }

    private Node<T> top;
    private int size;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if (top == null) throw new NoSuchElementException("stack is empty");
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public T peek() {
        if (top == null) throw new NoSuchElementException("stack is empty");
        return top.value;
    }

    public void clear() {
        top = null;
        size = 0;
    }
}
