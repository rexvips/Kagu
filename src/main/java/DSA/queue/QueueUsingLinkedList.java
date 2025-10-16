package DSA.queue;

/**
 * Queue implementation using linked list
 * Time Complexity: O(1) for enqueue, dequeue, peek
 * Space Complexity: O(n)
 */
public class QueueUsingLinkedList<T> {
    
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<T> front;
    private Node<T> rear;
    private int size;
    
    public QueueUsingLinkedList() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    
    /**
     * Add element to rear of queue - O(1)
     */
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    
    /**
     * Remove element from front of queue - O(1)
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }
    
    /**
     * Get front element without removing - O(1)
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }
    
    /**
     * Check if queue is empty - O(1)
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Get current size - O(1)
     */
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
