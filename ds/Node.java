package ds;

/**
 * This class represents a single node for all data structures in this assignment.
 * Each node holds a piece of String data and a reference to the next node.
 *
 * DO NOT MODIFY THIS FILE.
 */

class Node {
    
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}


