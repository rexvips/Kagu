package DSA.list;

/**
 * Doubly Linked List implementation
 * Time Complexity: O(1) for insertFirst, insertLast, deleteFirst, deleteLast; O(n) for search
 * Space Complexity: O(n)
 */
public class DoublyLinkedList<T> {
    
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
    
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * Insert at the beginning - O(1)
     */
    public void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    /**
     * Insert at the end - O(1)
     */
    public void insertLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    /**
     * Insert at specific position - O(n)
     */
    public void insertAt(int position, T data) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        if (position == 0) {
            insertFirst(data);
            return;
        }
        if (position == size) {
            insertLast(data);
            return;
        }
        
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }
    
    /**
     * Delete first node - O(1)
     */
    public T deleteFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        T data = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }
    
    /**
     * Delete last node - O(1)
     */
    public T deleteLast() {
        if (tail == null) {
            throw new RuntimeException("List is empty");
        }
        T data = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }
    
    /**
     * Delete node at specific position - O(n)
     */
    public T deleteAt(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        if (position == 0) {
            return deleteFirst();
        }
        if (position == size - 1) {
            return deleteLast();
        }
        
        Node<T> current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        
        T data = current.data;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return data;
    }
    
    /**
     * Search for element - O(n)
     */
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Get element at position - O(n)
     */
    public T get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        
        Node<T> current;
        // Optimize by starting from head or tail
        if (position < size / 2) {
            current = head;
            for (int i = 0; i < position; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > position; i--) {
                current = current.prev;
            }
        }
        return current.data;
    }
    
    /**
     * Reverse the linked list - O(n)
     */
    public void reverse() {
        Node<T> current = head;
        Node<T> temp = null;
        
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        
        if (temp != null) {
            tail = head;
            head = temp.prev;
        }
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public String toString() {
        if (head == null) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" <-> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
