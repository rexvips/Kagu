package DSA.stack;

/**
 * Stack implementation using linked list
 * Time Complexity: O(1) for push, pop, and peek
 * Space Complexity: O(n)
 */
public class StackUsingLinkedList<T> {
    
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<T> top;
    private int size;
    
    public StackUsingLinkedList() {
        this.top = null;
        this.size = 0;
    }
    
    /**
     * Push element onto stack - O(1)
     */
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }
    
    /**
     * Pop element from stack - O(1)
     */
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }
    
    /**
     * Get top element without removing - O(1)
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }
    
    /**
     * Check if stack is empty - O(1)
     */
    public boolean isEmpty() {
        return top == null;
    }
    
    /**
     * Get current size - O(1)
     */
    public int size() {
        return size;
    }
    
    /**
     * Clear the stack - O(1)
     */
    public void clear() {
        top = null;
        size = 0;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = top;
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
