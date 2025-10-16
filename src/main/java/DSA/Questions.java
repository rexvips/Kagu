package DSA;

/**
 * COMPREHENSIVE DSA INTERVIEW QUESTIONS FOR PRINCIPAL/STAFF SOFTWARE ENGINEER AT UBER
 * 
 * This class contains commented questions covering all important topics for senior engineering positions.
 * Focus areas: System Design thinking, Scalability, Real-time systems, Location-based services, 
 * Distributed systems, and Advanced algorithms.
 * 
 * @author DSA Package
 * @version 1.0
 */
public class Questions {
    
    // ===================================================================================
    // ARRAYS & STRINGS
    // ===================================================================================
    
    // Q1. Two Sum - Find two numbers in array that add up to target
    // Follow-up: What if array is sorted? What about multiple solutions?
    
    // Q2. Three Sum - Find all unique triplets that sum to zero
    // Follow-up: How would you optimize for very large arrays?
    
    // Q3. Container With Most Water - Find two lines that form container with most water
    // Real-world: Similar to Uber's surge pricing calculations across zones
    
    // Q4. Longest Substring Without Repeating Characters
    // Real-world: Useful for parsing unique route segments
    
    // Q5. Group Anagrams - Group strings that are anagrams
    // Follow-up: How would you handle unicode characters?
    
    // Q6. Valid Palindrome - Check if string is palindrome ignoring non-alphanumeric
    // Follow-up: What about checking if it can become palindrome with one deletion?
    
    // Q7. Minimum Window Substring - Find minimum window containing all characters
    // Real-world: Finding optimal delivery routes covering all required stops
    
    // Q8. Sliding Window Maximum - Find maximum in each sliding window
    // Real-world: Peak demand tracking across time windows for dynamic pricing
    
    // Q9. Product of Array Except Self - Without using division
    // Follow-up: How to optimize space complexity?
    
    // Q10. Rotate Array - Rotate array by k steps
    // Follow-up: Multiple approaches and their trade-offs?
    
    // Q11. Meeting Rooms II - Minimum number of conference rooms required
    // Real-world: Vehicle allocation - minimum cars needed to handle all rides
    
    // Q12. Merge Intervals - Merge overlapping intervals
    // Real-world: Consolidating driver availability windows
    
    // Q13. Insert Interval - Insert new interval and merge if needed
    // Real-world: Adding new ride request to driver's schedule
    
    // Q14. Trapping Rain Water - Calculate trapped water between bars
    // Advanced: 2D version for senior positions
    
    // Q15. Longest Consecutive Sequence - Find longest consecutive elements
    // Real-world: Finding continuous route segments without breaks
    
    
    // ===================================================================================
    // LINKED LISTS
    // ===================================================================================
    
    // Q16. Reverse Linked List - Iterative and recursive approaches
    // Follow-up: Reverse in groups of k nodes
    
    // Q17. Detect Cycle in Linked List - Floyd's cycle detection
    // Follow-up: Find the start of the cycle
    
    // Q18. Merge Two Sorted Lists - Merge maintaining sorted order
    // Follow-up: Merge k sorted lists (real-world: merging multiple data streams)
    
    // Q19. Remove Nth Node From End - One pass solution
    
    // Q20. Add Two Numbers - Numbers represented as linked lists
    // Follow-up: What if digits are stored in normal order?
    
    // Q21. Copy List with Random Pointer - Deep copy of complex list
    
    // Q22. LRU Cache - Implement Least Recently Used cache
    // Real-world: Critical for Uber's caching layer for driver/rider data
    // Follow-up: LFU Cache, TTL-based cache
    
    // Q23. Flatten Multilevel Doubly Linked List
    
    
    // ===================================================================================
    // STACKS & QUEUES
    // ===================================================================================
    
    // Q24. Valid Parentheses - Check balanced brackets
    // Follow-up: Generate all valid parentheses combinations
    
    // Q25. Min Stack - Stack supporting getMin in O(1)
    
    // Q26. Evaluate Reverse Polish Notation
    
    // Q27. Largest Rectangle in Histogram
    // Real-world: Optimizing warehouse space utilization
    
    // Q28. Daily Temperatures - Next warmer temperature
    
    // Q29. Implement Queue using Stacks
    
    // Q30. Design Circular Queue/Buffer
    // Real-world: Managing streaming location updates from drivers
    
    // Q31. Sliding Window Maximum using Deque
    
    
    // ===================================================================================
    // TREES & BINARY SEARCH TREES
    // ===================================================================================
    
    // Q32. Binary Tree Inorder Traversal - Recursive and Iterative
    // Follow-up: Morris traversal (O(1) space)
    
    // Q33. Binary Tree Level Order Traversal
    // Follow-up: Zigzag level order traversal
    
    // Q34. Maximum Depth of Binary Tree
    
    // Q35. Validate Binary Search Tree
    // Follow-up: What about duplicate values?
    
    // Q36. Lowest Common Ancestor - BST and Binary Tree versions
    // Real-world: Finding common route segments between trips
    
    // Q37. Serialize and Deserialize Binary Tree
    // Real-world: Critical for distributed caching and data transfer
    
    // Q38. Binary Tree Maximum Path Sum
    
    // Q39. Construct Binary Tree from Preorder and Inorder Traversal
    
    // Q40. Kth Smallest Element in BST
    // Follow-up: What if BST is modified frequently?
    
    // Q41. Vertical Order Traversal of Binary Tree
    
    // Q42. Binary Tree Right Side View
    
    // Q43. Count Complete Tree Nodes - Better than O(n)
    
    // Q44. Implement Trie (Prefix Tree)
    // Real-world: Autocomplete for addresses, location search
    // Follow-up: Add and Search Word with wildcards
    
    // Q45. Word Search II - Find all words from dictionary in board
    // Real-world: Location name matching in geographic grid
    
    
    // ===================================================================================
    // GRAPHS & ADVANCED TREES
    // ===================================================================================
    
    // Q46. Number of Islands - DFS/BFS approaches
    // Real-world: Service area segmentation for Uber
    
    // Q47. Clone Graph - Deep copy of graph
    
    // Q48. Course Schedule - Cycle detection in directed graph
    // Real-world: Dependency resolution in microservices
    
    // Q49. Course Schedule II - Topological sort
    
    // Q50. Word Ladder - Shortest transformation sequence
    
    // Q51. Network Delay Time - Dijkstra's algorithm
    // Real-world: Finding shortest paths in city road network
    
    // Q52. Cheapest Flights Within K Stops
    // Real-world: Multi-hop route optimization
    
    // Q53. Minimum Spanning Tree - Prim's and Kruskal's
    // Real-world: Optimal road network design
    
    // Q54. Critical Connections in Network (Bridges)
    // Real-world: Identifying critical road segments
    
    // Q55. Alien Dictionary - Topological sort
    
    // Q56. Graph Valid Tree - Check if graph forms valid tree
    
    // Q57. Connected Components in Undirected Graph
    // Real-world: Grouping nearby drivers into clusters
    
    // Q58. Shortest Path in Binary Matrix
    
    // Q59. Redundant Connection - Find edge that creates cycle
    
    // Q60. Minimum Height Trees - Find roots that minimize tree height
    
    
    // ===================================================================================
    // DYNAMIC PROGRAMMING
    // ===================================================================================
    
    // Q61. Climbing Stairs - Basic DP introduction
    
    // Q62. House Robber - Cannot rob adjacent houses
    // Follow-up: Houses arranged in circle, houses in binary tree
    
    // Q63. Coin Change - Minimum coins to make amount
    // Follow-up: Number of ways to make change
    
    // Q64. Longest Increasing Subsequence
    // Follow-up: O(n log n) solution using binary search
    
    // Q65. Longest Common Subsequence
    // Follow-up: Print the actual sequence
    
    // Q66. Edit Distance - Minimum operations to convert string
    // Real-world: Address matching with typos
    
    // Q67. Word Break - Can string be segmented into dictionary words
    // Follow-up: Word Break II - return all possible segmentations
    
    // Q68. Decode Ways - Number of ways to decode string
    
    // Q69. Unique Paths - Paths from top-left to bottom-right
    // Follow-up: With obstacles, minimum path sum
    
    // Q70. Jump Game - Can reach end of array
    // Follow-up: Minimum jumps needed
    
    // Q71. Maximum Subarray - Kadane's algorithm
    // Follow-up: Maximum subarray with at most k negative numbers
    
    // Q72. Best Time to Buy and Sell Stock - Multiple variations
    // Follow-up: With cooldown, with transaction fee, k transactions
    
    // Q73. Partition Equal Subset Sum - 0/1 Knapsack variant
    
    // Q74. Target Sum - Number of ways to reach target
    
    // Q75. Regular Expression Matching
    // Follow-up: Wildcard matching
    
    // Q76. Interleaving String
    
    // Q77. Distinct Subsequences
    
    // Q78. Maximum Product Subarray
    
    // Q79. Palindrome Partitioning II - Minimum cuts
    
    // Q80. Burst Balloons - Complex DP
    
    
    // ===================================================================================
    // BACKTRACKING
    // ===================================================================================
    
    // Q81. Permutations - Generate all permutations
    // Follow-up: Permutations with duplicates
    
    // Q82. Combinations - Generate all k-size combinations
    // Follow-up: Combination Sum variations
    
    // Q83. Subsets - Generate all subsets (power set)
    // Follow-up: Subsets with duplicates
    
    // Q84. Letter Combinations of Phone Number
    
    // Q85. Generate Parentheses - All valid combinations
    
    // Q86. Palindrome Partitioning - All possible partitions
    
    // Q87. Word Search - Find word in 2D board
    
    // Q88. N-Queens - Place n queens on n×n board
    // Follow-up: N-Queens II - just count solutions
    
    // Q89. Sudoku Solver
    
    // Q90. Restore IP Addresses
    
    
    // ===================================================================================
    // HEAPS & PRIORITY QUEUES
    // ===================================================================================
    
    // Q91. Kth Largest Element in Array
    // Follow-up: Kth largest in stream (online algorithm)
    
    // Q92. Top K Frequent Elements
    // Real-world: Most popular destinations, surge pricing zones
    
    // Q93. Find Median from Data Stream
    // Real-world: Real-time fare calculation with streaming data
    
    // Q94. Merge K Sorted Lists
    // Real-world: Merging sorted ride requests from multiple zones
    
    // Q95. Task Scheduler - Schedule tasks with cooldown
    // Real-world: Driver dispatch with rest requirements
    
    // Q96. Meeting Rooms II - Minimum rooms needed
    
    // Q97. Reorganize String - No adjacent same characters
    
    // Q98. K Closest Points to Origin
    // Real-world: Finding nearest available drivers
    // Follow-up: Updates in real-time as drivers move
    
    // Q99. Ugly Number II - Numbers with only factors 2, 3, 5
    
    // Q100. Employee Free Time - Free intervals across all schedules
    // Real-world: Finding driver availability gaps
    
    
    // ===================================================================================
    // BINARY SEARCH
    // ===================================================================================
    
    // Q101. Binary Search - Classic implementation
    
    // Q102. Search in Rotated Sorted Array
    // Follow-up: With duplicates
    
    // Q103. Find Minimum in Rotated Sorted Array
    
    // Q104. Search a 2D Matrix
    
    // Q105. Find Peak Element
    
    // Q106. First and Last Position in Sorted Array
    
    // Q107. Sqrt(x) - Integer square root
    
    // Q108. Valid Perfect Square
    
    // Q109. Median of Two Sorted Arrays - O(log(min(m,n)))
    // Advanced: Critical for senior positions
    
    // Q110. Split Array Largest Sum
    // Real-world: Load balancing across servers
    
    // Q111. Koko Eating Bananas - Binary search on answer
    
    // Q112. Capacity To Ship Packages Within D Days
    
    // Q113. Minimum Number of Days to Make m Bouquets
    
    
    // ===================================================================================
    // TWO POINTERS & SLIDING WINDOW
    // ===================================================================================
    
    // Q114. Remove Duplicates from Sorted Array
    
    // Q115. Move Zeroes to End
    
    // Q116. Container With Most Water
    
    // Q117. 3Sum Closest
    
    // Q118. Trapping Rain Water
    
    // Q119. Sort Colors (Dutch National Flag)
    
    // Q120. Minimum Window Substring
    
    // Q121. Longest Substring with At Most K Distinct Characters
    // Real-world: Analyzing route diversity
    
    // Q122. Fruit Into Baskets
    
    // Q123. Subarrays with K Different Integers
    
    
    // ===================================================================================
    // BIT MANIPULATION
    // ===================================================================================
    
    // Q124. Single Number - Find element appearing once
    // Follow-up: Single Number II (appears 3 times), III (two singles)
    
    // Q125. Number of 1 Bits (Hamming Weight)
    
    // Q126. Counting Bits - Count 1s for numbers 0 to n
    
    // Q127. Reverse Bits
    
    // Q128. Missing Number - Find missing from 0 to n
    
    // Q129. Sum of Two Integers - Without + operator
    
    // Q130. Bitwise AND of Numbers Range
    
    // Q131. Maximum XOR of Two Numbers
    
    
    // ===================================================================================
    // MATH & GEOMETRY
    // ===================================================================================
    
    // Q132. Happy Number - Detect cycle in sum of squared digits
    
    // Q133. Factorial Trailing Zeroes
    
    // Q134. Excel Sheet Column Number
    
    // Q135. Pow(x, n) - Implement power function
    
    // Q136. Divide Two Integers - Without *, /, or %
    
    // Q137. Fraction to Recurring Decimal
    
    // Q138. Valid Number - String represents valid number
    
    // Q139. Rectangle Overlap
    // Real-world: Geofencing, checking if service areas overlap
    
    // Q140. Largest Rectangle in Histogram
    
    // Q141. Maximal Rectangle - In binary matrix
    
    // Q142. Line Reflection - Check if points reflect across vertical line
    
    
    // ===================================================================================
    // DESIGN QUESTIONS (CRITICAL FOR PRINCIPAL/STAFF LEVEL)
    // ===================================================================================
    
    // Q143. Design LRU Cache
    // Real-world: Core caching mechanism for driver/rider sessions
    
    // Q144. Design LFU Cache
    
    // Q145. Design HashMap
    
    // Q146. Design HashSet
    
    // Q147. Design Circular Queue
    
    // Q148. Design Hit Counter
    // Real-world: Rate limiting for API calls
    
    // Q149. Design Time-Based Key-Value Store
    // Real-world: Versioned configuration management
    
    // Q150. Design Min Stack
    
    // Q151. Design Max Stack
    
    // Q152. Design Twitter (News Feed)
    // Real-world: Similar to Uber's activity feed
    
    // Q153. Design Search Autocomplete System
    // Real-world: Address autocomplete in Uber app
    
    // Q154. Design File System
    
    // Q155. Design In-Memory File System
    
    // Q156. Design Log Storage System
    
    // Q157. Design Rate Limiter
    // Real-world: API throttling, preventing abuse
    
    // Q158. Design Leaderboard
    // Real-world: Driver ranking system
    
    
    // ===================================================================================
    // UBER-SPECIFIC & REAL-WORLD SCENARIOS
    // ===================================================================================
    
    // Q159. Design Ride-Sharing Service
    // Components: Rider matching, driver dispatch, pricing, ETA calculation
    // Follow-up: Handle surge pricing, pool matching, scheduling rides
    
    // Q160. Nearest Drivers Problem
    // Given lat/long, find K nearest available drivers
    // Follow-up: Real-time updates as drivers move, geohashing, quad-trees
    
    // Q161. ETA Calculation
    // Calculate estimated time of arrival considering traffic
    // Follow-up: Real-time updates, historical data, machine learning
    
    // Q162. Dynamic Pricing (Surge)
    // Implement surge pricing based on supply-demand
    // Follow-up: Geographical zones, time-based pricing
    
    // Q163. Route Optimization
    // Optimize route for multiple stops (TSP variant)
    // Real-world: Uber Pool, food delivery with multiple pickups
    
    // Q164. Geofencing
    // Detect if location is within polygon boundary
    // Real-world: Service area boundaries, airport geofences
    
    // Q165. Driver-Rider Matching
    // Optimal matching algorithm considering distance, rating, time
    // Follow-up: Hungarian algorithm, bipartite matching
    
    // Q166. Trip Splitting (Uber Pool)
    // Match riders going in same direction
    // Follow-up: Minimize detour, maximize vehicle utilization
    
    // Q167. Heatmap Generation
    // Generate demand heatmap from ride requests
    // Real-world: Surge pricing zones visualization
    
    // Q168. Location Tracking System
    // Store and query driver locations efficiently
    // Follow-up: S2 geometry, geohashing, spatial indexing
    
    // Q169. Rate Limiting System
    // Implement distributed rate limiter
    // Real-world: Preventing API abuse, DOS protection
    
    // Q170. Real-time Data Pipeline
    // Process streaming location updates from millions of drivers
    // Follow-up: Apache Kafka, stream processing, windowing
    
    // Q171. Fraud Detection
    // Detect fraudulent trips or fake GPS locations
    // Follow-up: Pattern matching, anomaly detection
    
    // Q172. Notification Service
    // Send notifications to drivers/riders at scale
    // Follow-up: Priority queuing, retry logic, delivery guarantees
    
    // Q173. Payment Processing
    // Handle payment transactions, refunds, splits
    // Follow-up: Idempotency, distributed transactions
    
    // Q174. Driver Availability Prediction
    // Predict driver supply in next hour
    // Follow-up: Time series forecasting, seasonality
    
    // Q175. Route Clustering
    // Cluster similar routes for analytics
    // Real-world: Identify popular corridors for optimization
    
    
    // ===================================================================================
    // ADVANCED ALGORITHMS (PRINCIPAL/STAFF LEVEL)
    // ===================================================================================
    
    // Q176. Segment Tree
    // Range queries and updates
    // Real-world: Range-based analytics on trip data
    
    // Q177. Fenwick Tree (Binary Indexed Tree)
    // Prefix sum queries
    
    // Q178. Union Find (Disjoint Set)
    // Connected components, cycle detection
    // Real-world: Service area connectivity
    
    // Q179. Suffix Array & LCP
    // String matching, pattern search
    
    // Q180. KMP String Matching
    
    // Q181. Rabin-Karp Algorithm
    
    // Q182. Boyer-Moore String Search
    
    // Q183. Aho-Corasick Algorithm
    // Multiple pattern matching
    // Real-world: Content filtering, keyword matching
    
    // Q184. Manacher's Algorithm
    // Longest palindromic substring in O(n)
    
    // Q185. Z-Algorithm
    // Linear time pattern matching
    
    // Q186. Skip List
    // Probabilistic data structure
    
    // Q187. Bloom Filter
    // Space-efficient membership testing
    // Real-world: Checking if driver ID exists
    
    // Q188. Count-Min Sketch
    // Frequency estimation in streams
    // Real-world: Tracking popular destinations
    
    // Q189. HyperLogLog
    // Cardinality estimation
    // Real-world: Unique user counts at scale
    
    // Q190. Consistent Hashing
    // Distributed load balancing
    // Real-world: Sharding strategy for databases
    
    // Q191. Reservoir Sampling
    // Random sampling from stream
    
    // Q192. Fisher-Yates Shuffle
    // Random permutation
    
    // Q193. Convex Hull
    // Graham scan, Jarvis march
    // Real-world: Service area boundary calculation
    
    // Q194. Line Sweep Algorithm
    // Computational geometry
    // Real-world: Finding overlapping trips
    
    // Q195. Closest Pair of Points
    // Divide and conquer approach
    
    // Q196. Voronoi Diagram
    // Spatial partitioning
    // Real-world: Service area division among drivers
    
    // Q197. R-Tree / Quad-Tree
    // Spatial indexing
    // Real-world: Efficient location queries
    
    // Q198. K-D Tree
    // K-dimensional search
    // Real-world: Multi-attribute driver matching
    
    // Q199. Heavy Hitters (Misra-Gries)
    // Finding frequent items in stream
    
    // Q200. Online Algorithms
    // Decisions without future knowledge
    // Real-world: Real-time driver dispatch
    
    
    // ===================================================================================
    // SYSTEM DESIGN CONSIDERATIONS (BEHAVIORAL/ARCHITECTURAL)
    // ===================================================================================
    
    /*
     * SCALABILITY QUESTIONS:
     * - How would you scale the matching algorithm to 100M concurrent users?
     * - Design sharding strategy for rider/driver data
     * - Handle hot partitions in geographical distribution
     * - Database choice: SQL vs NoSQL for different components
     * 
     * RELIABILITY & FAULT TOLERANCE:
     * - Handle service failures gracefully
     * - Implement circuit breakers and retry logic
     * - Data replication and consistency models (CAP theorem)
     * - Disaster recovery and backup strategies
     * 
     * PERFORMANCE:
     * - Caching strategies at different layers
     * - CDN for static content
     * - Database query optimization and indexing
     * - Asynchronous processing and message queues
     * 
     * MONITORING & OBSERVABILITY:
     * - Metrics collection and alerting
     * - Distributed tracing
     * - Log aggregation
     * - Performance profiling
     * 
     * SECURITY:
     * - Authentication and authorization
     * - Data encryption (at rest and in transit)
     * - PII handling and GDPR compliance
     * - Rate limiting and DDoS protection
     * 
     * DATA CONSISTENCY:
     * - Eventual consistency vs strong consistency
     * - Distributed transactions (2PC, Saga pattern)
     * - Event sourcing and CQRS
     * 
     * REAL-TIME SYSTEMS:
     * - WebSocket connections at scale
     * - Message broker selection (Kafka, RabbitMQ)
     * - Stream processing (Flink, Storm)
     * 
     * GEOSPATIAL:
     * - Coordinate systems and projections
     * - Distance calculations (Haversine formula)
     * - Spatial databases (PostGIS)
     * - Map matching and GPS accuracy
     */
    
    
    // ===================================================================================
    // CODING BEST PRACTICES FOR INTERVIEWS
    // ===================================================================================
    
    /*
     * 1. COMMUNICATE: Think out loud, explain your approach
     * 2. ASK CLARIFICATIONS: Input constraints, edge cases, expected output format
     * 3. START WITH BRUTE FORCE: Then optimize
     * 4. ANALYZE COMPLEXITY: Time and space complexity
     * 5. TEST YOUR CODE: Walk through with examples
     * 6. CONSIDER EDGE CASES: Empty input, single element, duplicates, negatives
     * 7. CLEAN CODE: Meaningful variable names, proper formatting
     * 8. OPTIMIZE: Discuss trade-offs between time, space, and code complexity
     * 9. SCALABILITY: How would solution work with massive data?
     * 10. REAL-WORLD: Connect to actual Uber use cases when relevant
     */
    
    
    // ===================================================================================
    // PREPARATION STRATEGY
    // ===================================================================================
    
    /*
     * PHASE 1 (Weeks 1-2): Fundamentals
     * - Arrays, Strings, Linked Lists
     * - Stacks, Queues
     * - Basic Trees and BST
     * - Hashing
     * 
     * PHASE 2 (Weeks 3-4): Intermediate
     * - Advanced Trees (AVL, Trie)
     * - Graphs (DFS, BFS, Shortest Path)
     * - Dynamic Programming basics
     * - Backtracking
     * 
     * PHASE 3 (Weeks 5-6): Advanced
     * - Advanced DP problems
     * - Complex graph algorithms
     * - Design problems
     * - System design basics
     * 
     * PHASE 4 (Weeks 7-8): Uber-Specific
     * - Location-based problems
     * - Real-time systems
     * - Distributed systems
     * - System design deep dive
     * 
     * PRACTICE PLATFORMS:
     * - LeetCode (focus on Medium and Hard)
     * - System Design Primer (GitHub)
     * - Grokking the System Design Interview
     * - Uber Engineering Blog
     * 
     * MOCK INTERVIEWS:
     * - Practice with peers
     * - Use platforms like Pramp, Interviewing.io
     * - Time yourself (45 minutes per problem)
     */
}
