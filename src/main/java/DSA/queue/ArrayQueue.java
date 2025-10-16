package DSA.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<T> {
    private Object[] elements;
    private int headIndex;
    private int tailIndex;
    private int size;

    public ArrayQueue() {
        this.elements = new Object[16];
        this.headIndex = 0;
        this.tailIndex = 0;
        this.size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void enqueue(T value) {
        ensureCapacity(size + 1);
        elements[tailIndex] = value;
        tailIndex = (tailIndex + 1) % elements.length;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (size == 0) throw new NoSuchElementException("queue is empty");
        T value = (T) elements[headIndex];
        elements[headIndex] = null;
        headIndex = (headIndex + 1) % elements.length;
        size--;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) throw new NoSuchElementException("queue is empty");
        return (T) elements[headIndex];
    }

    public void clear() {
        for (int i = 0; i < elements.length; i++) elements[i] = null;
        headIndex = tailIndex = size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= elements.length) {
            if (size == elements.length) grow();
            return;
        }
        growTo(minCapacity);
    }

    private void grow() {
        growTo(elements.length * 2);
    }

    private void growTo(int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[(headIndex + i) % elements.length];
        }
        elements = newArray;
        headIndex = 0;
        tailIndex = size;
    }
}
