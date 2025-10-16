package DSA.array;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * A simple dynamic array with manual resizing and O(1) amortized append/pop.
 */
public final class DynamicArray<T> implements Iterable<T> {
    private static final int MIN_CAPACITY = 4;

    private Object[] elements;
    private int size;

    public DynamicArray() {
        this.elements = new Object[MIN_CAPACITY];
        this.size = 0;
    }

    public DynamicArray(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("initialCapacity must be positive");
        }
        int cap = Math.max(initialCapacity, MIN_CAPACITY);
        this.elements = new Object[cap];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T value) {
        ensureCapacityForAdd();
        elements[size++] = value;
    }

    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("pop from empty DynamicArray");
        }
        int idx = --size;
        @SuppressWarnings("unchecked")
        T value = (T) elements[idx];
        elements[idx] = null;
        shrinkIfNeeded();
        return value;
    }

    public T get(int index) {
        checkIndex(index);
        @SuppressWarnings("unchecked")
        T value = (T) elements[index];
        return value;
    }

    public void set(int index, T value) {
        checkIndex(index);
        elements[index] = value;
    }

    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("insert index out of range: " + index);
        }
        ensureCapacityForAdd();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = value;
        size++;
    }

    public T removeAt(int index) {
        checkIndex(index);
        @SuppressWarnings("unchecked")
        T value = (T) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        shrinkIfNeeded();
        return value;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
        shrinkIfNeeded();
    }

    private void ensureCapacityForAdd() {
        if (size == elements.length) {
            resize(elements.length * 2);
        }
    }

    private void shrinkIfNeeded() {
        int cap = elements.length;
        if (cap > MIN_CAPACITY && size <= cap / 4) {
            resize(Math.max(MIN_CAPACITY, cap / 2));
        }
    }

    private void resize(int newCapacity) {
        Object[] next = new Object[newCapacity];
        System.arraycopy(elements, 0, next, 0, size);
        elements = next;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out of range: " + index);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;
            @Override
            public boolean hasNext() { return cursor < size; }
            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                @SuppressWarnings("unchecked") T v = (T) elements[cursor++];
                return v;
            }
        };
    }

    @Override
    public String toString() {
        StringJoiner j = new StringJoiner(", ", "DynamicArray[", "]");
        for (T t : this) j.add(String.valueOf(t));
        return j.toString();
    }
}
