package DSA.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements Iterable<T> {
    private static final class Node<T> {
        T value;
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
        head = node;
        if (tail == null) tail = node;
        size++;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void insertAt(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("index: " + index);
        if (index == 0) { addFirst(value); return; }
        if (index == size) { addLast(value); return; }
        Node<T> prev = nodeAt(index - 1);
        Node<T> node = new Node<>(value);
        node.next = prev.next;
        prev.next = node;
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
        if (head == null) tail = null;
        size--;
        return value;
    }

    public T removeLast() {
        if (tail == null) throw new NoSuchElementException("list is empty");
        if (size == 1) return removeFirst();
        Node<T> prev = nodeAt(size - 2);
        T value = tail.value;
        prev.next = null;
        tail = prev;
        size--;
        return value;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index: " + index);
        if (index == 0) return removeFirst();
        Node<T> prev = nodeAt(index - 1);
        T value = prev.next.value;
        prev.next = prev.next.next;
        if (index == size - 1) tail = prev;
        size--;
        return value;
    }

    public boolean remove(T value) {
        if (head == null) return false;
        if ((value == null && head.value == null) || (value != null && value.equals(head.value))) {
            removeFirst();
            return true;
        }
        Node<T> prev = head;
        Node<T> curr = head.next;
        while (curr != null) {
            if ((value == null && curr.value == null) || (value != null && value.equals(curr.value))) {
                prev.next = curr.next;
                if (curr == tail) tail = prev;
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
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
        Node<T> curr = head;
        for (int i = 0; i < index; i++) curr = curr.next;
        return curr;
    }
}
