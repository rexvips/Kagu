package DSA.queue;

/**
 * Queue implementation using circular array
 * Time Complexity: O(1) for enqueue, dequeue, peek
 * Space Complexity: O(n)
 */
public class QueueUsingArray<T> {
    private Object[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    
    public QueueUsingArray() {
        this.capacity = DEFAULT_CAPACITY;
        this.array = new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    /**
     * Add element to rear of queue - O(1)
     */
    public void enqueue(T data) {
        if (isFull()) {
            resize(capacity * 2);
        }
        rear = (rear + 1) % capacity;
        array[rear] = data;
        size++;
    }
    
    /**
     * Remove element from front of queue - O(1)
     */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T data = (T) array[front];
        array[front] = null;
        front = (front + 1) % capacity;
        size--;
        
        // Shrink if needed
        if (size > 0 && size == capacity / 4) {
            resize(capacity / 2);
        }
        
        return data;
    }
    
    /**
     * Get front element without removing - O(1)
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return (T) array[front];
    }
    
    /**
     * Check if queue is empty - O(1)
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Check if queue is full - O(1)
     */
    public boolean isFull() {
        return size == capacity;
    }
    
    /**
     * Get current size - O(1)
     */
    public int size() {
        return size;
    }
    
    /**
     * Resize internal array - O(n)
     */
    private void resize(int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front + i) % capacity];
        }
        array = newArray;
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[(front + i) % capacity]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
