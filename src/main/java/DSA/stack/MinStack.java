package DSA.stack;

import java.util.Stack;

/**
 * Stack that supports retrieving minimum element in O(1) time
 * Time Complexity: O(1) for all operations
 * Space Complexity: O(n)
 */
public class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    /**
     * Push element onto stack - O(1)
     */
    public void push(int data) {
        mainStack.push(data);
        
        if (minStack.isEmpty() || data <= minStack.peek()) {
            minStack.push(data);
        }
    }
    
    /**
     * Pop element from stack - O(1)
     */
    public int pop() {
        if (mainStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        
        int data = mainStack.pop();
        if (data == minStack.peek()) {
            minStack.pop();
        }
        
        return data;
    }
    
    /**
     * Get top element - O(1)
     */
    public int peek() {
        if (mainStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return mainStack.peek();
    }
    
    /**
     * Get minimum element - O(1)
     */
    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return minStack.peek();
    }
    
    public boolean isEmpty() {
        return mainStack.isEmpty();
    }
    
    public int size() {
        return mainStack.size();
    }
}
