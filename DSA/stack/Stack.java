package DSA.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * A simple LIFO stack backed by ArrayList.
 */
public final class Stack<T> implements Iterable<T> {
    private final ArrayList<T> data = new ArrayList<>();

    public int size() { return data.size(); }
    public boolean isEmpty() { return data.isEmpty(); }

    public void push(T value) { data.add(value); }

    public T pop() {
        int n = data.size();
        if (n == 0) throw new NoSuchElementException("pop from empty stack");
        return data.remove(n - 1);
    }

    public T peek() {
        int n = data.size();
        if (n == 0) throw new NoSuchElementException("peek from empty stack");
        return data.get(n - 1);
    }

    public void clear() { data.clear(); }

    @Override
    public Iterator<T> iterator() { return data.iterator(); }

    @Override
    public String toString() {
        StringJoiner j = new StringJoiner(", ", "Stack[", "]");
        for (T t : data) j.add(String.valueOf(t));
        return j.toString();
    }
}
