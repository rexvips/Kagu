package DSA.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 16;

    private Object[] elements;
    private int size;

    public DynamicArray() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public DynamicArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("initialCapacity must be non-negative");
        }
        this.elements = new Object[Math.max(initialCapacity, DEFAULT_CAPACITY)];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int capacity() {
        return elements.length;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        rangeCheck(index);
        return (T) elements[index];
    }

    public void set(int index, T value) {
        rangeCheck(index);
        elements[index] = value;
    }

    public void add(T value) {
        ensureCapacity(size + 1);
        elements[size++] = value;
    }

    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        ensureCapacity(size + 1);
        if (index < size) {
            System.arraycopy(elements, index, elements, index + 1, size - index);
        }
        elements[index] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T removeAt(int index) {
        rangeCheck(index);
        T oldValue = (T) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        maybeShrink();
        return oldValue;
    }

    public boolean remove(T value) {
        int idx = indexOf(value);
        if (idx == -1) return false;
        removeAt(idx);
        return true;
    }

    public int indexOf(T value) {
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (value.equals(elements[i])) return i;
            }
        }
        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                if (cursor >= size) {
                    throw new NoSuchElementException();
                }
                return (T) elements[cursor++];
            }
        };
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= elements.length) return;
        int newCapacity = elements.length == 0 ? DEFAULT_CAPACITY : elements.length * 2;
        while (newCapacity < minCapacity) {
            newCapacity *= 2;
        }
        Object[] newArray = new Object[newCapacity];
        if (size > 0) {
            System.arraycopy(elements, 0, newArray, 0, size);
        }
        elements = newArray;
    }

    private void maybeShrink() {
        int currentCapacity = elements.length;
        if (currentCapacity <= DEFAULT_CAPACITY) return;
        if (size * 4 > currentCapacity) return; // keep load factor >= 0.25
        int newCapacity = Math.max(DEFAULT_CAPACITY, currentCapacity / 2);
        Object[] newArray = new Object[newCapacity];
        if (size > 0) {
            System.arraycopy(elements, 0, newArray, 0, size);
        }
        elements = newArray;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
    }
}
