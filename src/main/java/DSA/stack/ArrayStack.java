package DSA.stack;

import java.util.NoSuchElementException;

public class ArrayStack<T> {
    private Object[] elements;
    private int size;

    public ArrayStack() {
        this.elements = new Object[16];
        this.size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void push(T value) {
        ensureCapacity(size + 1);
        elements[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) throw new NoSuchElementException("stack is empty");
        T value = (T) elements[--size];
        elements[size] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) throw new NoSuchElementException("stack is empty");
        return (T) elements[size - 1];
    }

    public void clear() {
        for (int i = 0; i < size; i++) elements[i] = null;
        size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= elements.length) return;
        int newCapacity = elements.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }
}
