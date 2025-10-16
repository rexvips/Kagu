package DSA;

/**
 * Curated interview questions/topics for Senior/Staff/Principal engineers (Uber-level).
 * This is a non-executable syllabus-style class. Each method Javadoc lists
 * prompts and topics to prepare thoroughly. Use as a checklist.
 */
public final class Questions {

    /**
     * Data Structures & Algorithms — Arrays & Strings
     * <ul>
     *   <li>Implement dynamic array, ring buffer, deque; analyze amortized cost.</li>
     *   <li>Sliding window: longest substring without repeat, min window substring.</li>
     *   <li>Two pointers: 3-sum/4-sum, trapping rain water, container with most water.</li>
     *   <li>String transforms: edit distance, wildcard/regex match, KMP, Z-function, rolling hash.</li>
     *   <li>Array math: subarray sums (Kadane, prefix sums), product except self, range updates.</li>
     *   <li>Streaming: top-K with heap/reservoir sampling, quantiles, approximate distinct (HLL).</li>
     * </ul>
     */
    public void arraysStrings() {}

    /**
     * Linked Lists
     * <ul>
     *   <li>Reverse list (iterative/recursive), detect/remove cycle (Floyd).</li>
     *   <li>Merge K sorted lists, add two numbers, reorder/rotate list.</li>
     *   <li>Copy list with random pointer, intersection of two lists.</li>
     * </ul>
     */
    public void linkedLists() {}

    /**
     * Stacks & Queues
     * <ul>
     *   <li>Min stack, queue via two stacks, stack via two queues.</li>
     *   <li>Monotonic stack/queue problems (next greater element, daily temperatures, histogram area).</li>
     *   <li>Rate limiters: token bucket, leaky bucket; implement efficient structure.</li>
     * </ul>
     */
    public void stacksQueues() {}

    /**
     * Trees & Graphs
     * <ul>
     *   <li>BST ops incl. delete; AVL/Red-Black basics; heap vs BST trade-offs.</li>
     *   <li>Trie with prefix search, autocomplete, word break using trie + DP.</li>
     *   <li>Graphs: BFS/DFS, topological sort (Kahn/DFS), SCC (Kosaraju/Tarjan).</li>
     *   <li>Shortest paths: Dijkstra/A*/Johnson/Bellman-Ford; MST: Kruskal/Prim.</li>
     *   <li>LCA (binary lifting, Euler tour + RMQ), union-find with optimizations.</li>
     *   <li>Concurrency-safe graph processing (work stealing, batching) at scale.</li>
     * </ul>
     */
    public void treesGraphs() {}

    /**
     * Hashing & Heaps
     * <ul>
     *   <li>Design hash map: open addressing vs. chaining, resize strategy, hashDoS mitigations.</li>
     *   <li>Consistent hashing and jump hash; sharding strategies in distributed caches.</li>
     *   <li>Heaps: binary, binomial, Fibonacci; pairing heap trade-offs in practice.</li>
     *   <li>Priority queue with decrease-key and indexable heap implementation.</li>
     * </ul>
     */
    public void hashingHeaps() {}

    /**
     * Dynamic Programming & Math
     * <ul>
     *   <li>LIS (n log n), knapsack family, coin change, matrix chain.</li>
     *   <li>Digit DP, bitmask DP (TSP), DP on trees, SOS DP, rerooting.</li>
     *   <li>Combinatorics/probability: balls-in-bins, coupon collector, Chernoff/Hoeffding.</li>
     *   <li>Number theory: gcd, modexp, CRT, Miller–Rabin.</li>
     * </ul>
     */
    public void dpAndMath() {}

    /**
     * Systems Design — API Gateway & Rate Limiting
     * <ul>
     *   <li>Scalable API gateway with global/per-tenant limits (token/sliding window).</li>
     *   <li>Multi-DC deployment, failover, circuit breaker, backpressure.</li>
     *   <li>Retries with jitter, idempotency keys, partial failures.</li>
     *   <li>Canarying, progressive delivery, feature flags, config propagation.</li>
     * </ul>
     */
    public void apiGatewayRateLimiting() {}

    /**
     * Storage & Caches
     * <ul>
     *   <li>Multi-tenant KV store: consistency, read/write paths, LSM trees.</li>
     *   <li>Write amplification, compaction, Bloom filters; cold vs hot storage.</li>
     *   <li>Caching tiers; TTL vs write-through/write-back; stampede protections.</li>
     *   <li>Invalidation strategies, near-cache coherence, versioning, streaming invalidations.</li>
     * </ul>
     */
    public void storageCaches() {}

    /**
     * Real-time Systems
     * <ul>
     *   <li>Real-time matching (e.g., rider-driver): quadtrees/geohash/H3, proximity search.</li>
     *   <li>Stream processing: exactly-once, watermarking, out-of-order data.</li>
     *   <li>Backpressure and flow control; consumer group rebalancing.</li>
     *   <li>SLOs: tail latency P99/P999, load shedding, overload protection.</li>
     * </ul>
     */
    public void realtimeSystems() {}

    /**
     * Observability & Resilience
     * <ul>
     *   <li>Metrics/logs/traces: RED/USE, high-cardinality labels, histograms.</li>
     *   <li>Incident response: runbooks, auto-remediation, SLO error budgets.</li>
     *   <li>Resilience: bulkheads, hedged requests, retries with backoff + jitter.</li>
     *   <li>Chaos testing, fault injection, multi-region failure drills.</li>
     * </ul>
     */
    public void observabilityResilience() {}

    /**
     * Data Platform
     * <ul>
     *   <li>Batch vs streaming: lakehouse, data mesh, governance, lineage.</li>
     *   <li>ETL/ELT, compaction, CDC, schema evolution, GDPR deletions.</li>
     *   <li>Feature store for ML: point-in-time correctness, online/offline sync.</li>
     *   <li>Serving: shadow, canary, AB tests, drift detection.</li>
     * </ul>
     */
    public void dataPlatform() {}

    /**
     * Search & Relevance
     * <ul>
     *   <li>Inverted index, BM25; index updates, merge policies, cold starts.</li>
     *   <li>Relevance pipelines: candidates to rankers; diversity, fairness.</li>
     *   <li>Vector search: ANN (HNSW, IVF, PQ), hybrid lexical+vector; freshness.</li>
     *   <li>Online learning, counterfactual evaluation, exploration vs exploitation.</li>
     * </ul>
     */
    public void searchAndRelevance() {}

    /**
     * Concurrency Primitives
     * <ul>
     *   <li>Threading vs async IO; structured concurrency.</li>
     *   <li>Locks, lock-free (CAS), ABA, memory ordering basics.</li>
     *   <li>Deadlocks, priority inversion, starvation, fairness.</li>
     *   <li>Idempotency and exactly-once on at-least-once infra.</li>
     * </ul>
     */
    public void concurrencyPrimitives() {}

    /**
     * Scalable Patterns
     * <ul>
     *   <li>Sharding, partitioning, load balancing, adaptive concurrency limits.</li>
     *   <li>Queues, fan-out/fan-in, bulk APIs, batching, SEDA, actor model.</li>
     *   <li>Workflows/sagas, outbox/inbox, transactional messaging, DLQs.</li>
     *   <li>Rate limiting and quotas in multi-tenant environments.</li>
     * </ul>
     */
    public void scalablePatterns() {}

    /**
     * Reliability & DR
     * <ul>
     *   <li>Active-active vs active-passive; RTO/RPO; quorums.</li>
     *   <li>Leader election, leases, fencing tokens; clock skew.</li>
     *   <li>Data corruption detection/repair; backup/restore strategies.</li>
     *   <li>Capacity planning, failure domains, blast-radius reduction.</li>
     * </ul>
     */
    public void reliabilityDr() {}

    /**
     * Architecture & Leadership
     * <ul>
     *   <li>RFCs/ADRs, threat modeling, cost/perf trade-offs.</li>
     *   <li>Make vs buy, platformization, roadmaps, deprecation plans.</li>
     *   <li>DDD, bounded contexts, modular boundaries; migrations with zero-downtime cutovers.</li>
     * </ul>
     */
    public void architecturalThinking() {}

    /**
     * Org Leadership
     * <ul>
     *   <li>Drive cross-org initiatives, align stakeholders, influence without authority.</li>
     *   <li>Mentoring, raising quality bar, hiring loops, calibration.</li>
     *   <li>Incident command, comms during outages, postmortems.</li>
     *   <li>Ethical engineering, privacy/security by design.</li>
     * </ul>
     */
    public void orgLeadership() {}

    /**
     * Execution Excellence
     * <ul>
     *   <li>Operating mechanisms: goals, metrics, cadences, reviews.</li>
     *   <li>Risk management, staged rollouts, kill switches.</li>
     *   <li>Quality: property-based/fuzzing, static/dynamic analysis.</li>
     *   <li>Program management partnership, dependencies, delivery predictability.</li>
     * </ul>
     */
    public void executionExcellence() {}
}
