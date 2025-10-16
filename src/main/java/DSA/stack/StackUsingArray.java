package DSA.stack;

import java.util.Arrays;

/**
 * Stack implementation using dynamic array
 * Time Complexity: O(1) amortized for push, O(1) for pop and peek
 * Space Complexity: O(n)
 */
public class StackUsingArray<T> {
    private Object[] array;
    private int top;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    
    public StackUsingArray() {
        this.capacity = DEFAULT_CAPACITY;
        this.array = new Object[capacity];
        this.top = -1;
    }
    
    public StackUsingArray(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.top = -1;
    }
    
    /**
     * Push element onto stack - O(1) amortized
     */
    public void push(T data) {
        if (top == capacity - 1) {
            resize(capacity * 2);
        }
        array[++top] = data;
    }
    
    /**
     * Pop element from stack - O(1)
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T data = (T) array[top];
        array[top--] = null;
        
        // Shrink if needed
        if (top > 0 && top == capacity / 4) {
            resize(capacity / 2);
        }
        
        return data;
    }
    
    /**
     * Get top element without removing - O(1)
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return (T) array[top];
    }
    
    /**
     * Check if stack is empty - O(1)
     */
    public boolean isEmpty() {
        return top == -1;
    }
    
    /**
     * Get current size - O(1)
     */
    public int size() {
        return top + 1;
    }
    
    /**
     * Clear the stack - O(1)
     */
    public void clear() {
        Arrays.fill(array, 0, top + 1, null);
        top = -1;
    }
    
    /**
     * Resize internal array - O(n)
     */
    private void resize(int newCapacity) {
        capacity = newCapacity;
        array = Arrays.copyOf(array, capacity);
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(array[i]);
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
