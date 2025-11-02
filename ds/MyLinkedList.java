package ds;

public class MyLinkedList {
    /**
     * Simplified linked list for the cryptanalysis storyline.
     * Implement basic operations: add, get, size, and optimized duplicate
     * detection.
     */
    private Node head;
    private int size = 0;

    public MyLinkedList() {
        this.head = null;
    }

    /** Adds a new node with the specified data at the end of the list. */
    public void add(String data) {
        if (size == 0) {
            this.head = new Node(data);
            size = 1;
            return;
        }

        // Go to the tail
        Node currentNode = this.head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        /*
         * for (int i = 0; i < size - 1; i++) {
         * currentNode = currentNode.getNext();
         * }
         */
        currentNode.setNext(new Node(data));
        this.size++;
    }

    /** Returns the data of the node at the specified index. */
    public String get(int index) {
        if (index >= this.size) {
            return null;
        }

        Node currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getData();
    }

    /** Returns the number of elements in the list. */
    public int size() {
        return this.size;
    }

    /*
     * Brute-force quad duplicate detection.
     * - Iterate i from 0..size-1, j from i+1..size-1
     * - Extract first 4 chars of data (quad) and compare
     * - Return formatted success string when found; otherwise not found
     */
    public String findDuplicateQuadsBruteForce() {
        boolean found = false;
        String foundString = null;
        Node firstNode = this.head;
        Node secondNode = this.head;
        for (int i = 0; i < this.size - 2; i++) {
            String firstString = firstNode.getData().substring(0, 4);
            secondNode = firstNode.getNext();
            for (int j = i; j < this.size - 1; j++) {
                String secondString = secondNode.getData().substring(0, 4);
                if (firstString.equals(secondString)) {
                    found = true;
                    foundString = firstString;
                    // return "Duplicate found: ".concat(firstString);
                }

                secondNode = secondNode.getNext();
            }

            firstNode = firstNode.getNext();
        }

        if (found) {
            return "Duplicate found: ".concat(foundString);
        } else {
            return "No duplicates found.";
        }
    }

    /*
     * Optimized duplicate quad detection using MyBag.
     * - Create MyBag and scan once
     * - On each element, compute quad and check bag.contains(quad)
     * - If seen, return success; else add to bag
     */
    public String findDuplicateQuadsOptimized() {
        MyBag bag = new MyBag();
        Node currentNode = this.head;
        while (currentNode != null) {
            String data = currentNode.getData().substring(0, 4);
            if (bag.contains(data)) {
                return "Duplicate found: ".concat(data);
            }

            bag.add(data);
            currentNode = currentNode.getNext();
        }

        return "No duplicates found.";
    }

    /*
     * COMPLEXITY ANALYSIS SECTION
     * 
     * After implementing both methods, run the benchmarks and fill in your
     * analysis:
     * 
     * findDuplicateQuadsBruteForce Complexity: O(n^2)
     * findDuplicateQuadsOptimized Complexity: O(n^2)
     * 
     * Explanation: Both of the complexities have the worst case O(n^2) where
     * n is the size of the Linked List. Brute force has a nested loop, so
     * it is n^2. Optimized search does not have a nested loop, but
     * it has a for loop which contains a MyBag lookup (which is O(n)) in each
     * iteration so it is also O(n^2). But overall optimized one is faster since
     * it returns when it finds a duplicate.
     * 
     * Report your timing results from the benchmarks here:
     * N=32: brute(earlyDup)= 0.019 ms, brute(noDup)= 0.018 ms,
     * opt(earlyDup)= 0.019ms, opt(noDup)= 0.012 ms
     * N=1024: brute(earlyDup)= 0.144 ms, brute(noDup)= 0.116 ms,
     * opt(earlyDup)= 0.114 ms, opt(noDup)= 0.114 ms
     * N=4096: brute(earlyDup)= 0.357 ms, brute(noDup)= skipped (estimated 1.856)
     * ms,
     * opt(earlyDup)= 0.351 ms, opt(noDup)= 0.342 ms
     * N=16384: brute(earlyDup)= 1.05 ms, brute(noDup)= skipped (estimated 29.696)
     * ms,
     * opt(earlyDup)= 0.316 ms, opt(noDup)= 0.273 ms
     * 
     * (I found the estimated values by multiplying by 16 the previous benchmarks
     * for the
     * same tests. Because value N is quadrupled so the worst case should be 16
     * times the previous one.)
     */
}
