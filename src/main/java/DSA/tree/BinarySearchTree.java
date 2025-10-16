package DSA.tree;

import java.util.*;

/**
 * Binary Search Tree implementation
 * Time Complexity: Average O(log n), Worst O(n) for operations
 * Space Complexity: O(n)
 */
public class BinarySearchTree<T extends Comparable<T>> {
    
    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        
        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    private Node<T> root;
    private int size;
    
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }
    
    /**
     * Insert element - O(log n) average, O(n) worst
     */
    public void insert(T data) {
        root = insertRec(root, data);
        size++;
    }
    
    private Node<T> insertRec(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }
        
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insertRec(node.left, data);
        } else if (cmp > 0) {
            node.right = insertRec(node.right, data);
        }
        // If equal, don't insert (no duplicates)
        
        return node;
    }
    
    /**
     * Search for element - O(log n) average, O(n) worst
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
    
    /**
     * Delete element - O(log n) average, O(n) worst
     */
    public void delete(T data) {
        root = deleteRec(root, data);
        size--;
    }
    
    private Node<T> deleteRec(Node<T> node, T data) {
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
            
            // Case 1: Leaf node
            if (node.left == null && node.right == null) {
                return null;
            }
            
            // Case 2: One child
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            
            // Case 3: Two children
            // Find inorder successor (minimum in right subtree)
            T minValue = findMin(node.right);
            node.data = minValue;
            node.right = deleteRec(node.right, minValue);
        }
        
        return node;
    }
    
    /**
     * Find minimum element - O(log n) average
     */
    public T findMin() {
        if (root == null) {
            throw new NoSuchElementException("Tree is empty");
        }
        return findMin(root);
    }
    
    private T findMin(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }
    
    /**
     * Find maximum element - O(log n) average
     */
    public T findMax() {
        if (root == null) {
            throw new NoSuchElementException("Tree is empty");
        }
        return findMax(root);
    }
    
    private T findMax(Node<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }
    
    /**
     * Inorder traversal (Left, Root, Right) - O(n)
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
    
    /**
     * Preorder traversal (Root, Left, Right) - O(n)
     */
    public List<T> preorderTraversal() {
        List<T> result = new ArrayList<>();
        preorderRec(root, result);
        return result;
    }
    
    private void preorderRec(Node<T> node, List<T> result) {
        if (node != null) {
            result.add(node.data);
            preorderRec(node.left, result);
            preorderRec(node.right, result);
        }
    }
    
    /**
     * Postorder traversal (Left, Right, Root) - O(n)
     */
    public List<T> postorderTraversal() {
        List<T> result = new ArrayList<>();
        postorderRec(root, result);
        return result;
    }
    
    private void postorderRec(Node<T> node, List<T> result) {
        if (node != null) {
            postorderRec(node.left, result);
            postorderRec(node.right, result);
            result.add(node.data);
        }
    }
    
    /**
     * Level order traversal (BFS) - O(n)
     */
    public List<T> levelOrderTraversal() {
        List<T> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            result.add(node.data);
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        
        return result;
    }
    
    /**
     * Get height of tree - O(n)
     */
    public int height() {
        return heightRec(root);
    }
    
    private int heightRec(Node<T> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }
    
    /**
     * Check if tree is balanced - O(n)
     */
    public boolean isBalanced() {
        return isBalancedRec(root) != -1;
    }
    
    private int isBalancedRec(Node<T> node) {
        if (node == null) {
            return 0;
        }
        
        int leftHeight = isBalancedRec(node.left);
        if (leftHeight == -1) return -1;
        
        int rightHeight = isBalancedRec(node.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public String toString() {
        return inorderTraversal().toString();
    }
}
