package DSA.array;

import java.util.Arrays;

/**
 * Dynamic Array implementation with automatic resizing
 * Time Complexity: O(1) amortized for append, O(n) for insert/delete at arbitrary position
 * Space Complexity: O(n)
 */
public class DynamicArray<T> {
    private Object[] array;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicArray() {
        this.capacity = DEFAULT_CAPACITY;
        this.array = new Object[capacity];
        this.size = 0;
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.size = 0;
    }

    /**
     * Add element at the end - O(1) amortized
     */
    public void add(T element) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        array[size++] = element;
    }

    /**
     * Insert element at specific index - O(n)
     */
    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == capacity) {
            resize(capacity * 2);
        }
        // Shift elements to the right
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    /**
     * Remove element at specific index - O(n)
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedElement = (T) array[index];
        // Shift elements to the left
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null; // Prevent memory leak
        
        // Shrink if needed
        if (size > 0 && size == capacity / 4) {
            resize(capacity / 2);
        }
        return removedElement;
    }

    /**
     * Get element at specific index - O(1)
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }

    /**
     * Set element at specific index - O(1)
     */
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        array[index] = element;
    }

    /**
     * Get current size - O(1)
     */
    public int size() {
        return size;
    }

    /**
     * Check if array is empty - O(1)
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clear the array - O(1)
     */
    public void clear() {
        Arrays.fill(array, 0, size, null);
        size = 0;
    }

    /**
     * Resize internal array - O(n)
     */
    private void resize(int newCapacity) {
        capacity = newCapacity;
        array = Arrays.copyOf(array, capacity);
    }

    /**
     * Get current capacity
     */
    public int capacity() {
        return capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
