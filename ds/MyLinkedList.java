package ds;

public class MyLinkedList {
    /**
     * Simplified linked list for the cryptanalysis storyline. 
     * Implement basic operations: add, get, size, and optimized duplicate detection.
     */
    private Node head;
    private int size = 0;

    public MyLinkedList() {
        this.head = null;
    }

    /** Adds a new node with the specified data at the end of the list. */
    public void add(String data) {
        // TODO: Append new node to the tail of the list and increment size
    }

    /** Returns the data of the node at the specified index. */
    public String get(int index) {
        // TODO: Validate index, traverse and return data at index
        return null;
    }

    /** Returns the number of elements in the list. */
    public int size() {
        // TODO: return size
        return 0;
    }

    /*
     * Brute-force quad duplicate detection.
     * - Iterate i from 0..size-1, j from i+1..size-1
     * - Extract first 4 chars of data (quad) and compare
     * - Return formatted success string when found; otherwise not found
     */
    public String findDuplicateQuadsBruteForce() {
        // TODO: Implement nested loops to search for duplicate quads
        return "No duplicates found.";
    }

    /*
     * Optimized duplicate quad detection using MyBag.
     * - Create MyBag and scan once
     * - On each element, compute quad and check bag.contains(quad)
     * - If seen, return success; else add to bag
     */
    public String findDuplicateQuadsOptimized() {
        // TODO: Use MyBag to track seen quads; return as soon as duplicate found
        return "No duplicates found.";
    }

    /*
     * COMPLEXITY ANALYSIS SECTION
     * 
     * After implementing both methods, run the benchmarks and fill in your analysis:
     * 
     * findDuplicateQuadsBruteForce Complexity: ___
     * findDuplicateQuadsOptimized Complexity: ___
     * 
     * Explanation: ___
     * 
     * Report your timing results from the benchmarks here:
     * N=32: brute(earlyDup)=___ms, brute(noDup)=___ms, opt(earlyDup)=___ms, opt(noDup)=___ms
     * N=1024: brute(earlyDup)=___ms, brute(noDup)=___ms, opt(earlyDup)=___ms, opt(noDup)=___ms
     * N=4096: brute(earlyDup)=___ms, brute(noDup)=___ms, opt(earlyDup)=___ms, opt(noDup)=___ms
     * N=16384: brute(earlyDup)=___ms, brute(noDup)=___ms, opt(earlyDup)=___ms, opt(noDup)=___ms
     * 
     */
}
