package ds;

import javax.management.RuntimeErrorException;

/*
 * A stack that supports getMax() in O(1) time.
 * Approach: Keep an auxiliary stack of current maxima.
 * Space: O(N) in worst case (strictly more nodes to track plateaus of maxima).
 */
public class MySpecialStack {
    // TODO: Implement push/pop/getMax/size with O(1) getMax using an auxiliary
    // structure

    private MyNode top;
    private MyNode maxHead;
    private int max;

    public void push(int data) {
        if (this.top == null) {
            this.top = new MyNode(data);
            this.maxHead = new MyNode(data);
            this.max = data;
            return;
        }

        MyNode newTop = new MyNode(data);
        newTop.setNext(this.top);
        this.top = newTop;
        if (data > this.max) {
            MyNode newMax = new MyNode(data);
            newMax.setNext(this.maxHead);
            this.maxHead = newMax;
            this.max = data;
        }
    }

    public int pop() {
        if (this.top == null) {
            throw new RuntimeException("No node left in stack!");
        }

        MyNode newTop = this.top.getNext();
        int popped = this.top.getData();
        this.top = newTop;

        if (popped == this.max) {
            this.maxHead = this.maxHead.getNext();
            this.max = this.maxHead.getData();
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