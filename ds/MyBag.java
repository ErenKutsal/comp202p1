package ds;

/**
 * In Operation: CipherSift, you need to remember which 4-character prefixes
 * (quads)
 * you've seen to speed up pattern detection. Implement a simple Bag using a
 * singly linked list to support add and contains operations.
 */
public class MyBag {

    private Node head;

    /**
     * Adds a new data element to the bag by inserting at the head of the list.
     */
    public void add(String data) {
        if (head == null) {
            this.head = new Node(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.setNext(this.head);
        this.head = newNode;
    }

    /**
     * Checks whether the provided data already exists in the bag.
     * Return true on the first match; otherwise false after traversal.
     */
    public boolean contains(String data) {
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getData().equals(data)) {
                return true;
            }

            currentNode = currentNode.getNext();
        }

        return false;
    }
}
