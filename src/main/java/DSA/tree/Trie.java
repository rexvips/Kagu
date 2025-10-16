package DSA.tree;

import java.util.*;

/**
 * Trie (Prefix Tree) implementation for efficient string operations
 * Time Complexity: O(m) for insert, search, startsWith where m is key length
 * Space Complexity: O(ALPHABET_SIZE * N * M) where N is number of keys, M is average key length
 */
public class Trie {
    
    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        
        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
    
    private TrieNode root;
    private int size;
    
    public Trie() {
        root = new TrieNode();
        size = 0;
    }
    
    /**
     * Insert a word into the trie - O(m) where m is word length
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        
        if (!current.isEndOfWord) {
            current.isEndOfWord = true;
            size++;
        }
    }
    
    /**
     * Search for a word in the trie - O(m)
     */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord;
    }
    
    /**
     * Check if any word in the trie starts with the given prefix - O(m)
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }
        
        return searchNode(prefix) != null;
    }
    
    /**
     * Helper method to search for a node
     */
    private TrieNode searchNode(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return null;
            }
            current = current.children.get(ch);
        }
        return current;
    }
    
    /**
     * Delete a word from the trie - O(m)
     */
    public boolean delete(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        
        boolean deleted = deleteRec(root, word, 0);
        if (deleted) {
            size--;
        }
        return deleted;
    }
    
    private boolean deleteRec(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) {
                return false;
            }
            current.isEndOfWord = false;
            return current.children.isEmpty();
        }
        
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        
        boolean shouldDeleteCurrentNode = deleteRec(node, word, index + 1);
        
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.isEmpty() && !current.isEndOfWord;
        }
        
        return false;
    }
    
    /**
     * Get all words with given prefix - O(p + n) where p is prefix length, n is number of nodes
     */
    public List<String> getAllWordsWithPrefix(String prefix) {
        List<String> words = new ArrayList<>();
        TrieNode node = searchNode(prefix);
        
        if (node != null) {
            collectWords(node, prefix, words);
        }
        
        return words;
    }
    
    private void collectWords(TrieNode node, String currentWord, List<String> words) {
        if (node.isEndOfWord) {
            words.add(currentWord);
        }
        
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            collectWords(entry.getValue(), currentWord + entry.getKey(), words);
        }
    }
    
    /**
     * Get all words in the trie
     */
    public List<String> getAllWords() {
        return getAllWordsWithPrefix("");
    }
    
    /**
     * Find longest common prefix of all words - O(n * m)
     */
    public String longestCommonPrefix() {
        if (size == 0) {
            return "";
        }
        
        StringBuilder prefix = new StringBuilder();
        TrieNode current = root;
        
        while (current.children.size() == 1 && !current.isEndOfWord) {
            Map.Entry<Character, TrieNode> entry = current.children.entrySet().iterator().next();
            prefix.append(entry.getKey());
            current = entry.getValue();
        }
        
        return prefix.toString();
    }
    
    /**
     * Count words with given prefix
     */
    public int countWordsWithPrefix(String prefix) {
        TrieNode node = searchNode(prefix);
        if (node == null) {
            return 0;
        }
        return countWords(node);
    }
    
    private int countWords(TrieNode node) {
        int count = node.isEndOfWord ? 1 : 0;
        for (TrieNode child : node.children.values()) {
            count += countWords(child);
        }
        return count;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public String toString() {
        return "Trie with " + size + " words: " + getAllWords();
    }
}
