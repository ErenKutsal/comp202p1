package ds;

/*
 * A stack that supports getMax() in O(1) time.
 * Approach: Keep an auxiliary stack of current maxima.
 * Space: O(N) in worst case (strictly more nodes to track plateaus of maxima).
 */
public class MySpecialStack {
    // TODO: Implement push/pop/getMax/size with O(1) getMax using an auxiliary
    // structure

    private MyNode top;
    private int max;

    public void push(int data) {
        if (this.top == null) {
            this.top = new MyNode(data);
            this.max = data;
            return;
        }

        MyNode newTop = new MyNode(data);
        newTop.setNext(this.top);
        this.top = newTop;
        if (data > this.max) {
            this.max = data;
        }
    }

    public int pop() {
        MyNode newTop = this.top.getNext();
        int popped = this.top.getData();
        this.top = newTop;

        MyNode currentNode = this.top;
        this.max = currentNode.getData();
        while ((currentNode = currentNode.getNext()) != null) {
            int data = currentNode.getData();
            if (data > this.max) {
                this.max = data;
            }

        }

        return popped;
    }

    public int getMax() {
        return this.max;
    }

    // Note: No size() method needed for simplified version
}

class MyNode {

    private int data;
    private MyNode next;

    public MyNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;

    }

    public MyNode getNext() {
        return this.next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }
}
