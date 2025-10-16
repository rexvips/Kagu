# DSA Package - Interview Preparation

A comprehensive Data Structures and Algorithms package implemented in Java, specifically designed for preparing for Principal Engineer and Staff Software Engineer positions at companies like Uber.

## 📦 Package Structure

```
DSA/
├── array/
│   └── DynamicArray.java          - Dynamic array with automatic resizing
├── list/
│   ├── SinglyLinkedList.java      - Singly linked list implementation
│   └── DoublyLinkedList.java      - Doubly linked list implementation
├── tree/
│   ├── BinarySearchTree.java      - Binary Search Tree implementation
│   ├── AVLTree.java               - Self-balancing AVL Tree
│   └── Trie.java                  - Prefix Tree for string operations
├── queue/
│   ├── QueueUsingArray.java       - Circular queue using array
│   ├── QueueUsingLinkedList.java  - Queue using linked list
│   ├── PriorityQueueImpl.java     - Priority queue using min heap
│   └── DequeImpl.java             - Double-ended queue
├── stack/
│   ├── StackUsingArray.java       - Stack using dynamic array
│   ├── StackUsingLinkedList.java  - Stack using linked list
│   └── MinStack.java              - Stack with O(1) min retrieval
└── Questions.java                 - 200+ interview questions with Uber focus

```

## 🎯 Features

### 1. **Array Package**
- Dynamic resizing with amortized O(1) insertion
- Automatic shrinking to prevent memory waste
- Generic type support

### 2. **List Package**
- **Singly Linked List**: Forward traversal, O(1) insert at head
- **Doubly Linked List**: Bidirectional traversal, O(1) operations at both ends
- Includes cycle detection, middle element finding, and reversal

### 3. **Tree Package**
- **BST**: Classic binary search tree with all traversals
- **AVL Tree**: Self-balancing with guaranteed O(log n) operations
- **Trie**: Efficient prefix matching for autocomplete features

### 4. **Queue Package**
- **Circular Queue**: Space-efficient implementation
- **Priority Queue**: Min heap based implementation
- **Deque**: Double-ended queue for flexible operations

### 5. **Stack Package**
- Array and linked list based implementations
- **MinStack**: Special stack that tracks minimum in O(1)

## 📚 Questions Class

The `Questions.java` file contains **200+ carefully curated interview questions** organized into categories:

### Question Categories:
1. **Arrays & Strings** (15 questions)
2. **Linked Lists** (8 questions)
3. **Stacks & Queues** (8 questions)
4. **Trees & BST** (14 questions)
5. **Graphs** (15 questions)
6. **Dynamic Programming** (20 questions)
7. **Backtracking** (10 questions)
8. **Heaps & Priority Queues** (10 questions)
9. **Binary Search** (13 questions)
10. **Two Pointers & Sliding Window** (10 questions)
11. **Bit Manipulation** (8 questions)
12. **Math & Geometry** (11 questions)
13. **Design Questions** (16 questions)
14. **Uber-Specific Scenarios** (17 questions)
15. **Advanced Algorithms** (25 questions)

### Uber-Specific Topics:
- Ride-sharing service design
- Nearest drivers algorithm
- ETA calculation
- Dynamic pricing (surge)
- Route optimization
- Geofencing
- Driver-rider matching
- Real-time location tracking
- Rate limiting
- Fraud detection

## 🚀 Getting Started

### Prerequisites
- Java 11 or higher
- Maven (optional, for dependency management)

### Compilation
```bash
# Compile all files
javac -d bin src/main/java/DSA/**/*.java src/main/java/DSA/*.java

# Or using Maven
mvn clean compile
```

### Usage Examples

#### Dynamic Array
```java
DynamicArray<Integer> arr = new DynamicArray<>();
arr.add(1);
arr.add(2);
arr.insert(1, 10);  // [1, 10, 2]
```

#### Binary Search Tree
```java
BinarySearchTree<Integer> bst = new BinarySearchTree<>();
bst.insert(5);
bst.insert(3);
bst.insert(7);
boolean found = bst.search(3);  // true
List<Integer> inorder = bst.inorderTraversal();
```

#### Priority Queue
```java
PriorityQueueImpl<Integer> pq = new PriorityQueueImpl<>();
pq.enqueue(5);
pq.enqueue(2);
pq.enqueue(8);
int min = pq.dequeue();  // 2
```

## 📊 Complexity Analysis

All implementations include:
- Time complexity for each operation
- Space complexity analysis
- Best, average, and worst-case scenarios where applicable

## 🎓 Interview Preparation Strategy

### Phase 1 (Weeks 1-2): Fundamentals
- Master arrays, strings, and linked lists
- Understand basic tree operations
- Practice stack and queue problems

### Phase 2 (Weeks 3-4): Intermediate
- Advanced tree structures (AVL, Trie)
- Graph algorithms (DFS, BFS, Dijkstra)
- Dynamic programming basics

### Phase 3 (Weeks 5-6): Advanced
- Complex DP problems
- System design concepts
- Advanced graph algorithms

### Phase 4 (Weeks 7-8): Uber-Specific
- Location-based algorithms
- Real-time systems
- Distributed systems
- Scale considerations

## 💡 Key Topics for Uber Interviews

### Technical:
1. **Geospatial Algorithms**: K-nearest neighbors, geohashing, quad-trees
2. **Real-time Systems**: Stream processing, WebSocket connections
3. **Distributed Systems**: Sharding, consistent hashing, CAP theorem
4. **Scalability**: Load balancing, caching strategies, database optimization
5. **Graph Algorithms**: Shortest path, route optimization, TSP variants

### System Design Focus Areas:
- Ride matching at scale
- Real-time location tracking
- Surge pricing algorithms
- ETA prediction systems
- Payment processing
- Notification delivery
- Fraud detection

## 🔧 Best Practices

1. **Communication**: Always explain your thought process
2. **Clarification**: Ask about constraints and edge cases
3. **Testing**: Walk through examples and edge cases
4. **Optimization**: Discuss time-space trade-offs
5. **Clean Code**: Use meaningful names and proper formatting
6. **Real-world Connection**: Relate to Uber use cases

## 📖 Additional Resources

- **LeetCode**: Focus on Medium and Hard problems
- **System Design Primer** (GitHub)
- **Grokking the System Design Interview**
- **Uber Engineering Blog**: Real-world architectural insights

## 🤝 Contributing

Feel free to add more implementations or improve existing ones. Follow these guidelines:
- Maintain consistent code style
- Include time and space complexity
- Add meaningful comments
- Test edge cases

## 📝 License

This project is created for educational purposes.

---

**Good luck with your interview preparation! 🚀**

Remember: Consistency is key. Practice daily, understand the concepts deeply, and connect them to real-world Uber scenarios.
