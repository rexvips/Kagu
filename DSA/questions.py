"""Curated interview questions/topics for Senior/Staff/Principal engineers (Uber-level).

This is a non-executable syllabus-style class. Each method docstring contains
question prompts and topics to prepare thoroughly. Use as a checklist.
"""

class Questions:
    """Comprehensive prompts across systems, algorithms, and leadership."""

    # ==========================
    # Data Structures & Algorithms
    # ==========================

    def arrays_strings(self):
        """
        - Implement dynamic array, ring buffer, deque; analyze amortized cost.
        - Sliding window patterns: longest substring without repeat, min window substring.
        - Two pointers: 3-sum/4-sum, trapping rain water, container with most water.
        - String transforms: edit distance, wildcard/regex match, KMP, Z-function, rolling hash.
        - Array math: subarray sums (Kadane, prefix sums), product except self, range updates (diff array).
        - Streaming: top-K with heap/reservoir sampling, quantiles (Greenwald–Khanna), approximate distinct (HyperLogLog overview).
        """

    def linked_lists(self):
        """
        - Reverse singly list (iterative/recursive), detect/remove cycle (Floyd).
        - Merge K sorted lists, add two numbers, reorder list, rotate list.
        - Copy list with random pointer, intersection of two lists.
        """

    def stacks_queues(self):
        """
        - Min stack, queue via two stacks, stack via two queues.
        - Monotonic stack/queue problems (next greater element, daily temperatures, histogram area).
        - Rate limiters: token bucket, leaky bucket; implement efficient data structure.
        """

    def trees_graphs(self):
        """
        - BST ops incl. delete; AVL/Red-Black basics; heap vs. BST trade-offs.
        - Trie with prefix search, autocomplete, word break using trie + DP.
        - Graph representations: adjacency list/matrix, edge list; BFS/DFS variants, topological sort (Kahn, DFS), SCC (Kosaraju/Tarjan).
        - Shortest paths: Dijkstra (binary heap, Fibonacci heap trade-offs), A*, Johnson, Bellman-Ford; MST: Kruskal/Prim.
        - LCA (binary lifting, Euler tour + RMQ), union-find with path compression + union by rank.
        - Concurrency-safe graph processing (work stealing, batching) at scale.
        """

    def hashing_heaps(self):
        """
        - Design hash map: open addressing vs chaining, resize strategy, hashDoS mitigations.
        - Consistent hashing and jump hash; sharding strategies in distributed caches.
        - Heaps: binary, binomial, Fibonacci; pairing heap trade-offs in practice.
        - Priority queue with decrease-key and indexable heap implementation.
        """

    def dp_and_math(self):
        """
        - Classic DP: LIS (n log n), knapsack family, coin change, matrix chain multiplication.
        - Digit DP, bitmask DP (TSP), DP on trees, SOS DP, rerooting.
        - Combinatorics/probability: balls-in-bins, coupon collector, Chernoff/Hoeffding bounds intuition.
        - Number theory basics for interviews: gcd, modexp, CRT, Miller–Rabin.
        """

    # ==========================
    # Systems Design & Distributed Systems
    # ==========================

    def api_gateway_ratelimiting(self):
        """
        - Design scalable API gateway with global and per-tenant rate limits (token bucket, sliding window).
        - Multi-dc deployment, colos, failover, health checks, circuit breaker, backpressure.
        - Request classification, retries with jitter, idempotency keys, partial failures.
        - Canarying, progressive delivery, feature flags, config propagation.
        """

    def storage_caches(self):
        """
        - Design multi-tenant KV store: strong vs eventual consistency; read/write paths.
        - Write amplification, LSM trees, compaction, Bloom filters; cold vs hot storage.
        - Caching tiers: client, CDN, edge, regional, service; TTL vs write-through/write-back; cache stampede protections.
        - Cache invalidation strategies at scale, near-cache coherence, versioning, streaming invalidations.
        """

    def realtime_systems(self):
        """
        - Design real-time matching system (e.g., rider-driver marketplace): geospatial indexes (quadtrees, geohash, H3), proximity search.
        - Stream processing: Kafka/Pulsar, exactly-once semantics, watermarking, out-of-order data.
        - Backpressure and flow control end-to-end; consumer group rebalancing strategies.
        - SLOs: tail latency P99/P999, load shedding, overload protection, brownout.
        """

    def observability_resilience(self):
        """
        - Metrics, logs, traces: RED/USE, high-cardinality label strategies, histograms.
        - Incident response: runbooks, automations, auto-remediation, SLO error budgets.
        - Resilience: bulkheads, hedged requests, retries with exponential backoff + jitter.
        - Chaos testing, fault injection, multi-region failure drills, dependency budget.
        """

    def data_platform(self):
        """
        - Batch vs streaming: lakehouse, data mesh, governance, lineage, quality checks.
        - ETL/ELT, compaction, CDC, schema evolution, late data handling, GDPR deletions.
        - Feature store design for ML: point-in-time correctness, online/offline sync.
        - Training/serving: shadow deployments, canary, AB tests, drift detection.
        """

    def search_and_relevance(self):
        """
        - Inverted index, postings lists, BM25; index updates, merge policies, cold starts.
        - Relevance pipelines: candidates, coarse-to-fine rankers, diversity, fairness.
        - Vector search: ANN (HNSW, IVF-Flat, PQ), filters, freshness; hybrid lexical+vector.
        - Online learning, counterfactual evaluation, exploration vs exploitation (bandits), feedback loops.
        """

    # ==========================
    # Scalability, Concurrency, Reliability
    # ==========================

    def concurrency_primitives(self):
        """
        - Threading vs async IO, event loops; structured concurrency.
        - Locks (mutex, RW, semaphore), lock-free structures (CAS), ABA problem, memory ordering basics.
        - Deadlocks (four conditions), detection/avoidance, priority inversion; starvation and fairness.
        - Idempotency and exactly-once processing at-least-once infra.
        """

    def scalable_patterns(self):
        """
        - Sharding, partitioning, load balancing, adaptive concurrency limits.
        - Queue-based backends, fan-out/fan-in, bulk APIs, batching, SEDA, actor model.
        - Workflows/sagas, outbox/inbox, transactional messaging, retries and DLQs.
        - Rate limiting and quotas in multi-tenant environments.
        """

    def reliability_dr(self):
        """
        - Multi-region active-active vs active-passive; RTO/RPO; quorum strategies.
        - Leader election, lease management, fencing tokens; clock skew handling.
        - Data corruption detection, repair, and backup/restore strategies.
        - Capacity planning, failure domains, blast-radius reduction.
        """

    # ==========================
    # Architecture, Leadership, Execution
    # ==========================

    def architectural_thinking(self):
        """
        - RFCs/ADRs, architecture reviews, threat modeling, cost/perf trade-offs.
        - Make vs buy, platformization, multi-year roadmaps, deprecation plans.
        - Modular boundaries, domain-driven design, bounded contexts.
        - Migration strategies with zero-downtime cutovers.
        """

    def org_leadership(self):
        """
        - Drive cross-org initiatives, align stakeholders, influence without authority.
        - Mentoring, leveling up org quality bar, hiring loops, calibration.
        - Incident command, comms during outages, postmortems, blameless culture.
        - Ethical engineering, privacy/security by design.
        """

    def execution_excellence(self):
        """
        - Operating mechanisms: goals, metrics, cadences, reviews.
        - Risk management, staged rollouts, kill switches.
        - Quality: testing strategies (property-based, fuzzing), static/dynamic analysis.
        - Program management partnership, dependencies, critical path, delivery predictability.
        """
