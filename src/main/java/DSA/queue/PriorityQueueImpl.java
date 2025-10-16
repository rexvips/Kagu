package DSA.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Priority Queue implementation using Min Heap
 * Time Complexity: O(log n) for enqueue and dequeue, O(1) for peek
 * Space Complexity: O(n)
 */
public class PriorityQueueImpl<T extends Comparable<T>> {
    private List<T> heap;
    private Comparator<T> comparator;
    
    public PriorityQueueImpl() {
        this.heap = new ArrayList<>();
        this.comparator = null;
    }
    
    public PriorityQueueImpl(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }
    
    /**
     * Add element to priority queue - O(log n)
     */
    public void enqueue(T data) {
        heap.add(data);
        heapifyUp(heap.size() - 1);
    }
    
    /**
     * Remove and return highest priority element - O(log n)
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Priority Queue is empty");
        }
        
        T root = heap.get(0);
        T lastElement = heap.remove(heap.size() - 1);
        
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
        
        return root;
    }
    
    /**
     * Get highest priority element without removing - O(1)
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Priority Queue is empty");
        }
        return heap.get(0);
    }
    
    /**
     * Heapify up operation - O(log n)
     */
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (compare(heap.get(index), heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }
    
    /**
     * Heapify down operation - O(log n)
     */
    private void heapifyDown(int index) {
        while (true) {
            int smallest = index;
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            
            if (leftChild < heap.size() && compare(heap.get(leftChild), heap.get(smallest)) < 0) {
                smallest = leftChild;
            }
            
            if (rightChild < heap.size() && compare(heap.get(rightChild), heap.get(smallest)) < 0) {
                smallest = rightChild;
            }
            
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }
    
    /**
     * Compare two elements
     */
    private int compare(T a, T b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        }
        return a.compareTo(b);
    }
    
    /**
     * Swap elements at two indices
     */
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    public int size() {
        return heap.size();
    }
    
    @Override
    public String toString() {
        return heap.toString();
    }
}
