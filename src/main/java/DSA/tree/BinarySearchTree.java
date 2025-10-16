package DSA.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<K extends Comparable<K>, V> implements Iterable<K> {
    private static final class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;
        Node(K key, V value) { this.key = key; this.value = value; }
    }

    private static final class Box<T> { T value; }

    private Node<K, V> root;
    private int size;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("key must not be null");
        Node<K, V> curr = root;
        while (curr != null) {
            int cmp = key.compareTo(curr.key);
            if (cmp == 0) return curr.value;
            curr = cmp < 0 ? curr.left : curr.right;
        }
        return null;
    }

    public boolean containsKey(K key) { return get(key) != null || containsKeyNode(root, key); }

    private boolean containsKeyNode(Node<K, V> node, K key) {
        if (key == null) throw new IllegalArgumentException("key must not be null");
        Node<K, V> curr = node;
        while (curr != null) {
            int cmp = key.compareTo(curr.key);
            if (cmp == 0) return true;
            curr = cmp < 0 ? curr.left : curr.right;
        }
        return false;
    }

    public V put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("key must not be null");
        if (root == null) {
            root = new Node<>(key, value);
            size = 1;
            return null;
        }
        Node<K, V> parent = null;
        Node<K, V> curr = root;
        int cmp = 0;
        while (curr != null) {
            parent = curr;
            cmp = key.compareTo(curr.key);
            if (cmp == 0) {
                V old = curr.value;
                curr.value = value;
                return old;
            } else if (cmp < 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        Node<K, V> node = new Node<>(key, value);
        if (cmp < 0) parent.left = node; else parent.right = node;
        size++;
        return null;
    }

    public V remove(K key) {
        if (key == null) throw new IllegalArgumentException("key must not be null");
        Box<V> removed = new Box<>();
        root = delete(root, key, removed);
        return removed.value;
    }

    private Node<K, V> delete(Node<K, V> node, K key, Box<V> removed) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key, removed);
        } else if (cmp > 0) {
            node.right = delete(node.right, key, removed);
        } else {
            removed.value = node.value;
            if (node.left == null) { size--; return node.right; }
            if (node.right == null) { size--; return node.left; }
            Node<K, V> successor = minNode(node.right);
            node.key = successor.key;
            node.value = successor.value;
            node.right = delete(node.right, successor.key, new Box<V>());
        }
        return node;
    }

    public K minKey() {
        if (root == null) throw new NoSuchElementException("tree is empty");
        return minNode(root).key;
    }

    public K maxKey() {
        if (root == null) throw new NoSuchElementException("tree is empty");
        Node<K, V> curr = root;
        while (curr.right != null) curr = curr.right;
        return curr.key;
    }

    public int height() { return height(root); }

    private int height(Node<K, V> node) {
        if (node == null) return -1; // height of empty tree
        int lh = height(node.left);
        int rh = height(node.right);
        return 1 + Math.max(lh, rh);
    }

    public void clear() { root = null; size = 0; }

    private Node<K, V> minNode(Node<K, V> node) {
        Node<K, V> curr = node;
        while (curr.left != null) curr = curr.left;
        return curr;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private final Deque<Node<K, V>> stack = new ArrayDeque<>();
            private Node<K, V> current = root;
            {
                pushLeft(current);
            }

            private void pushLeft(Node<K, V> node) {
                Node<K, V> n = node;
                while (n != null) {
                    stack.push(n);
                    n = n.left;
                }
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public K next() {
                if (!hasNext()) throw new NoSuchElementException();
                Node<K, V> node = stack.pop();
                if (node.right != null) pushLeft(node.right);
                return node.key;
            }
        };
    }
}
