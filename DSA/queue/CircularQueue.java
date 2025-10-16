package DSA.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Circular queue with dynamic resizing and O(1) amortized operations.
 */
public final class CircularQueue<T> implements Iterable<T> {
    private static final int MIN_CAPACITY = 8;

    private Object[] elements;
    private int head;
    private int tail;
    private int size;

    public CircularQueue() {
        this.elements = new Object[MIN_CAPACITY];
    }

    public CircularQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be positive");
        this.elements = new Object[Math.max(capacity, MIN_CAPACITY)];
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void enqueue(T value) {
        ensureCapacityForAdd();
        elements[tail] = value;
        tail = (tail + 1) % elements.length;
        size++;
    }

    public T dequeue() {
        if (size == 0) throw new NoSuchElementException("dequeue from empty queue");
        @SuppressWarnings("unchecked") T value = (T) elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        shrinkIfNeeded();
        return value;
    }

    public T peek() {
        if (size == 0) throw new NoSuchElementException("peek from empty queue");
        @SuppressWarnings("unchecked") T value = (T) elements[head];
        return value;
    }

    public void clear() {
        for (int i = 0; i < elements.length; i++) elements[i] = null;
        head = tail = size = 0;
    }

    private void ensureCapacityForAdd() {
        if (size == elements.length) resize(elements.length * 2);
    }

    private void shrinkIfNeeded() {
        int cap = elements.length;
        if (cap > MIN_CAPACITY && size > 0 && size <= cap / 4) resize(Math.max(MIN_CAPACITY, cap / 2));
    }

    private void resize(int newCapacity) {
        Object[] next = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            next[i] = elements[(head + i) % elements.length];
        }
        elements = next;
        head = 0;
        tail = size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int seen = 0;
            @Override public boolean hasNext() { return seen < size; }
            @Override public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                @SuppressWarnings("unchecked") T v = (T) elements[(head + seen) % elements.length];
                seen++;
                return v;
            }
        };
    }

    @Override
    public String toString() {
        StringJoiner j = new StringJoiner(", ", "CircularQueue[", "]");
        for (T t : this) j.add(String.valueOf(t));
        return j.toString();
    }
}
