package DSA.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {
    private static final class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;
        Node(T value) { this.value = value; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        if (head != null) head.prev = node;
        head = node;
        if (tail == null) tail = node;
        size++;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        node.prev = tail;
        if (tail != null) tail.next = node;
        tail = node;
        if (head == null) head = node;
        size++;
    }

    public void insertAt(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("index: " + index);
        if (index == 0) { addFirst(value); return; }
        if (index == size) { addLast(value); return; }
        Node<T> curr = nodeAt(index);
        Node<T> node = new Node<>(value);
        node.prev = curr.prev;
        node.next = curr;
        curr.prev.next = node;
        curr.prev = node;
        size++;
    }

    public T get(int index) {
        return nodeAt(index).value;
    }

    public void set(int index, T value) {
        nodeAt(index).value = value;
    }

    public T removeFirst() {
        if (head == null) throw new NoSuchElementException("list is empty");
        T value = head.value;
        head = head.next;
        if (head != null) head.prev = null; else tail = null;
        size--;
        return value;
    }

    public T removeLast() {
        if (tail == null) throw new NoSuchElementException("list is empty");
        T value = tail.value;
        tail = tail.prev;
        if (tail != null) tail.next = null; else head = null;
        size--;
        return value;
    }

    public T removeAt(int index) {
        Node<T> node = nodeAt(index);
        T value = node.value;
        unlink(node);
        return value;
    }

    public boolean remove(T value) {
        for (Node<T> n = head; n != null; n = n.next) {
            if ((value == null && n.value == null) || (value != null && value.equals(n.value))) {
                unlink(n);
                return true;
            }
        }
        return false;
    }

    public int indexOf(T value) {
        int index = 0;
        for (Node<T> n = head; n != null; n = n.next) {
            if ((value == null && n.value == null) || (value != null && value.equals(n.value))) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> cursor = head;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public T next() {
                if (cursor == null) throw new NoSuchElementException();
                T value = cursor.value;
                cursor = cursor.next;
                return value;
            }
        };
    }

    private Node<T> nodeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index: " + index);
        Node<T> curr;
        if (index < size / 2) {
            curr = head;
            for (int i = 0; i < index; i++) curr = curr.next;
        } else {
            curr = tail;
            for (int i = size - 1; i > index; i--) curr = curr.prev;
        }
        return curr;
    }

    private void unlink(Node<T> node) {
        Node<T> prev = node.prev;
        Node<T> next = node.next;
        if (prev != null) prev.next = next; else head = next;
        if (next != null) next.prev = prev; else tail = prev;
        size--;
    }
}
