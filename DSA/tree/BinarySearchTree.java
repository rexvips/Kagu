package DSA.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Unbalanced Binary Search Tree with insert, contains, delete, and traversals.
 */
public final class BinarySearchTree<T> {
    private static final class Node<T> {
        T key;
        Node<T> left;
        Node<T> right;
        Node(T key) { this.key = key; }
    }

    private Node<T> root;
    private int size;
    private final Comparator<? super T> comparator;

    public BinarySearchTree() { this(null); }

    public BinarySearchTree(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public boolean contains(T value) {
        Node<T> n = root;
        while (n != null) {
            int c = compare(value, n.key);
            if (c == 0) return true;
            n = (c < 0) ? n.left : n.right;
        }
        return false;
    }

    public void insert(T value) {
        root = insertRec(root, value);
    }

    private Node<T> insertRec(Node<T> node, T value) {
        if (node == null) {
            size++;
            return new Node<>(value);
        }
        int c = compare(value, node.key);
        if (c < 0) node.left = insertRec(node.left, value);
        else if (c > 0) node.right = insertRec(node.right, value);
        // ignore duplicates
        return node;
    }

    public boolean remove(T value) {
        int before = size;
        root = removeRec(root, value);
        return size < before;
    }

    private Node<T> removeRec(Node<T> node, T value) {
        if (node == null) return null;
        int c = compare(value, node.key);
        if (c < 0) node.left = removeRec(node.left, value);
        else if (c > 0) node.right = removeRec(node.right, value);
        else {
            // delete this node
            if (node.left == null) { size--; return node.right; }
            if (node.right == null) { size--; return node.left; }
            // replace with inorder successor (smallest in right subtree)
            Node<T> succParent = node;
            Node<T> succ = node.right;
            while (succ.left != null) { succParent = succ; succ = succ.left; }
            node.key = succ.key;
            if (succParent.left == succ) succParent.left = succ.right; else succParent.right = succ.right;
            // size already decremented when actual node removed; mimic by decrement here
            size--;
        }
        return node;
    }

    public List<T> inorder() { List<T> out = new ArrayList<>(); inorderRec(root, out); return out; }
    public List<T> preorder() { List<T> out = new ArrayList<>(); preorderRec(root, out); return out; }
    public List<T> postorder() { List<T> out = new ArrayList<>(); postorderRec(root, out); return out; }

    private void inorderRec(Node<T> n, List<T> out) {
        if (n == null) return;
        inorderRec(n.left, out);
        out.add(n.key);
        inorderRec(n.right, out);
    }

    private void preorderRec(Node<T> n, List<T> out) {
        if (n == null) return;
        out.add(n.key);
        preorderRec(n.left, out);
        preorderRec(n.right, out);
    }

    private void postorderRec(Node<T> n, List<T> out) {
        if (n == null) return;
        postorderRec(n.left, out);
        postorderRec(n.right, out);
        out.add(n.key);
    }

    public void clear() {
        root = null;
        size = 0;
    }

    private int compare(T a, T b) {
        if (comparator != null) return comparator.compare(a, b);
        @SuppressWarnings("unchecked")
        Comparable<? super T> ca = (Comparable<? super T>) a;
        return ca.compareTo(b);
    }

    @Override
    public String toString() {
        StringJoiner j = new StringJoiner(", ", "BinarySearchTree[", "]");
        for (T t : inorder()) j.add(String.valueOf(t));
        return j.toString();
    }
}
