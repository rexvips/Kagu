package DSA.tree;

import java.util.*;

/**
 * AVL Tree (Self-Balancing Binary Search Tree) implementation
 * Time Complexity: O(log n) for all operations (insert, delete, search)
 * Space Complexity: O(n)
 */
public class AVLTree<T extends Comparable<T>> {
    
    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        int height;
        
        Node(T data) {
            this.data = data;
            this.height = 0;
        }
    }
    
    private Node<T> root;
    private int size;
    
    public AVLTree() {
        this.root = null;
        this.size = 0;
    }
    
    /**
     * Get height of node
     */
    private int height(Node<T> node) {
        return node == null ? -1 : node.height;
    }
    
    /**
     * Update height of node
     */
    private void updateHeight(Node<T> node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }
    
    /**
     * Get balance factor of node
     */
    private int getBalance(Node<T> node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }
    
    /**
     * Right rotation
     */
    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.left;
        Node<T> T2 = x.right;
        
        // Perform rotation
        x.right = y;
        y.left = T2;
        
        // Update heights
        updateHeight(y);
        updateHeight(x);
        
        return x;
    }
    
    /**
     * Left rotation
     */
    private Node<T> rotateLeft(Node<T> x) {
        Node<T> y = x.right;
        Node<T> T2 = y.left;
        
        // Perform rotation
        y.left = x;
        x.right = T2;
        
        // Update heights
        updateHeight(x);
        updateHeight(y);
        
        return y;
    }
    
    /**
     * Insert element - O(log n)
     */
    public void insert(T data) {
        root = insertRec(root, data);
        size++;
    }
    
    private Node<T> insertRec(Node<T> node, T data) {
        // Normal BST insertion
        if (node == null) {
            return new Node<>(data);
        }
        
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insertRec(node.left, data);
        } else if (cmp > 0) {
            node.right = insertRec(node.right, data);
        } else {
            // Duplicate keys not allowed
            return node;
        }
        
        // Update height
        updateHeight(node);
        
        // Get balance factor
        int balance = getBalance(node);
        
        // Left Left Case
        if (balance > 1 && data.compareTo(node.left.data) < 0) {
            return rotateRight(node);
        }
        
        // Right Right Case
        if (balance < -1 && data.compareTo(node.right.data) > 0) {
            return rotateLeft(node);
        }
        
        // Left Right Case
        if (balance > 1 && data.compareTo(node.left.data) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        
        // Right Left Case
        if (balance < -1 && data.compareTo(node.right.data) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        
        return node;
    }
    
    /**
     * Delete element - O(log n)
     */
    public void delete(T data) {
        root = deleteRec(root, data);
        size--;
    }
    
    private Node<T> deleteRec(Node<T> node, T data) {
        // Normal BST deletion
        if (node == null) {
            return null;
        }
        
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = deleteRec(node.left, data);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, data);
        } else {
            // Node to be deleted found
            
            // Node with one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            
            // Node with two children
            T minValue = findMin(node.right);
            node.data = minValue;
            node.right = deleteRec(node.right, minValue);
        }
        
        if (node == null) {
            return null;
        }
        
        // Update height
        updateHeight(node);
        
        // Get balance factor
        int balance = getBalance(node);
        
        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }
        
        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        
        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }
        
        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        
        return node;
    }
    
    /**
     * Search for element - O(log n)
     */
    public boolean search(T data) {
        return searchRec(root, data);
    }
    
    private boolean searchRec(Node<T> node, T data) {
        if (node == null) {
            return false;
        }
        
        int cmp = data.compareTo(node.data);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return searchRec(node.left, data);
        } else {
            return searchRec(node.right, data);
        }
    }
    
    private T findMin(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }
    
    /**
     * Inorder traversal - O(n)
     */
    public List<T> inorderTraversal() {
        List<T> result = new ArrayList<>();
        inorderRec(root, result);
        return result;
    }
    
    private void inorderRec(Node<T> node, List<T> result) {
        if (node != null) {
            inorderRec(node.left, result);
            result.add(node.data);
            inorderRec(node.right, result);
        }
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int height() {
        return height(root);
    }
    
    @Override
    public String toString() {
        return inorderTraversal().toString();
    }
}
