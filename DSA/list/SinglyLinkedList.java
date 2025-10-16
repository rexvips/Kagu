package DSA.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * A straightforward singly linked list with head/tail tracking.
 */
public final class SinglyLinkedList<T> implements Iterable<T> {
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

    public void addLast(T value) {
        Node<T> n = new Node<>(value);
        if (tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public void addFirst(T value) {
        Node<T> n = new Node<>(value);
        n.next = head;
        head = n;
        if (tail == null) tail = n;
        size++;
    }

    public T popFirst() {
        if (head == null) throw new NoSuchElementException("pop from empty list");
        Node<T> n = head;
        head = n.next;
        if (head == null) tail = null;
        size--;
        return n.value;
    }

    public T popLast() {
        if (head == null) throw new NoSuchElementException("pop from empty list");
        if (head.next == null) {
            T v = head.value;
            head = tail = null;
            size = 0;
            return v;
        }
        Node<T> prev = head;
        Node<T> cur = head.next;
        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;
        tail = prev;
        size--;
        return cur.value;
    }

    public Integer findFirstIndexOf(T value) {
        int idx = 0;
        for (T v : this) {
            if ((v == null && value == null) || (v != null && v.equals(value))) {
                return idx;
            }
            idx++;
        }
        return null;
    }

    public boolean removeFirstOccurrence(T value) {
        Node<T> prev = null;
        Node<T> cur = head;
        while (cur != null) {
            if ((cur.value == null && value == null) || (cur.value != null && cur.value.equals(value))) {
                if (prev == null) {
                    head = cur.next;
                    if (head == null) tail = null;
                } else {
                    prev.next = cur.next;
                    if (prev.next == null) tail = prev;
                }
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> cur = head;
            @Override public boolean hasNext() { return cur != null; }
            @Override public T next() {
                if (cur == null) throw new NoSuchElementException();
                T v = cur.value;
                cur = cur.next;
                return v;
            }
        };
    }

    @Override
    public String toString() {
        StringJoiner j = new StringJoiner(", ", "SinglyLinkedList[", "]");
        for (T t : this) j.add(String.valueOf(t));
        return j.toString();
    }
}
