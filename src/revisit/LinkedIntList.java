package revisit;

public class LinkedIntList {

    private ListNode<Integer> front;
    private int size; // indicates the number of nodes in our list

    public LinkedIntList() {
        front = null;
        // do I need to initialize size here? Yes/No Java will default front to null & size to 0 for us
        size = 0;
    }

    public LinkedIntList(int val) {

        front = new ListNode<>(val, null);
        size++; // or size = 1
    }

    public void addFront(int val) {
        front = new ListNode<>(val, front);
        size++;
    }

    public void addEnd(int val) {
        // where should we increment size?
        if (front == null) {
            addFront(val);
        } else {
            ListNode<Integer> current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode<>(val);
            size++;
        }
    }

    public int removeFront() {
        if (front == null) {
            throw new IllegalStateException("no node to remove.");
        } else {
            int removed = front.data;
            front = front.next;
            size--;
            return removed;
        }
    }


    public int removeEnd() {

        if (front == null) {
            throw new IllegalStateException("no node to remove");
        }

        int removed = front.data;

        if (front.next == null) {
            front = null;
        } else {
            ListNode<Integer> current = front;

            while (current.next.next != null) {
                current = current.next;
            }

            removed = current.next.data;
            current.next = null;
        }
        size--;
        return removed;

    }

    public boolean contains(int val) {
        ListNode<Integer> current = front;
        while (current != null) {
            if (current.data == val) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }


    public String toString() {
        if (front == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[" + front.data);
        ListNode<Integer> current = front.next;

        while (current != null) {
            result.append("," + current.data);
            current = current.next;
        }

        result.append("]");
        return result.toString();
    }

    public void add(int index, int val) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }

        // if adding to front index ==
        if(index == 0){
            addFront(val);
        } else {
            // traverse to the node before the index
            // 33 --> 17 --> 88 --> 98 --> null
            //       curr
            // 33 --> 17 --> 101 --> 88 --> 98 --> null
            // add(2,101)
            // initialize current
            ListNode<Integer> current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            // create node
            ListNode<Integer> insert = new ListNode<>(val, current.next);
            // get teh insert node into the linked list
            current.next = insert;

            size++;
        }
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }

        // traverse the LinkedList & stop at one before the last
        // index - for loop
        // front --> 33 --> 17 --> 18 --> 34 --> null
        // index     0      1       2      3
        //                        curr
        // get(3) returns 34
        ListNode<Integer> current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        // outside the for loop
        // current will be on the index node
        return current.data;

    }

    // TODO: write the logic for remove()
    public int remove(int index) {
        // if the list is currently empty
        if(this.size == 0){
            throw new IllegalStateException("No nodes to remove!");
        }
        // if the index is out of bounds
        if(this.size < index){
            throw new IndexOutOfBoundsException("Not enough nodes!\nIndex is: " + index + ", but the list is only: " + size);
        }


        return -1;
    }

    // TODO: write the logic for set()
    public void set(int index, int val) {
        // if the list is currently empty
        if(this.size == 0){
            throw new IllegalStateException("No nodes to remove!");
        }
        // if the index is out of bounds
        if(this.size < index){
            throw new IndexOutOfBoundsException("Not enough nodes!\nIndex is: " + index + ", but the list is only: " + size);
        }

    }
























}