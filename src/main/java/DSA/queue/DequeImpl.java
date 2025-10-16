package DSA.queue;

/**
 * Double-ended Queue (Deque) implementation using doubly linked list
 * Time Complexity: O(1) for all operations
 * Space Complexity: O(n)
 */
public class DequeImpl<T> {
    
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    private Node<T> front;
    private Node<T> rear;
    private int size;
    
    public DequeImpl() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    
    /**
     * Add element at front - O(1)
     */
    public void addFront(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }
    
    /**
     * Add element at rear - O(1)
     */
    public void addRear(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        size++;
    }
    
    /**
     * Remove element from front - O(1)
     */
    public T removeFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        } else {
            front.prev = null;
        }
        size--;
        return data;
    }
    
    /**
     * Remove element from rear - O(1)
     */
    public T removeRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        T data = rear.data;
        rear = rear.prev;
        if (rear == null) {
            front = null;
        } else {
            rear.next = null;
        }
        size--;
        return data;
    }
    
    /**
     * Get front element - O(1)
     */
    public T peekFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        return front.data;
    }
    
    /**
     * Get rear element - O(1)
     */
    public T peekRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        return rear.data;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = front;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
