package no.uib.ii.inf102.f18.mandatory0;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * @author Torstein Strømme
 */
public class SortableLinkedList<E extends Comparable<E>> implements ISortableList<E>{

    private class Node {
        private Node next;
        private E payload;

        private Node(E payload) {
            this.payload = payload;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void add(E element) {
        if (this.size == 0) {
            this.head = new Node(element);
            this.tail = this.head;
        }
        else {
            // Adding to end of list - using a tail pointer
            this.tail.next = new Node(element);
            this.tail = this.tail.next;
        }
        this.size++;
    }

    public void add(int index, E element) {
        Node node = new Node(element);
        if (index == 0) {
            node.next = this.head;
            this.head = node;
        }
        else {
            Node prior = getNode(index - 1);
            node.next = prior.next;
            prior.next = node;
        }
        this.size++;
    }

    private Node getNode(int index) {
        verifyIndexInRange(index);
        Node node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private final void verifyIndexInRange(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException(String.format("index=%d, size=%d", index, this.size));
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public E get(int index) {
        return getNode(index).payload;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E remove(int index) {
        verifyIndexInRange(index);
        E res = null;

        if (index == 0) {
            res = this.head.payload;
            this.head = this.head.next;
        }
        else {
            Node prior = getNode(index - 1);
            res = prior.next.payload;
            prior.next = prior.next.next;
        }

        this.size--;
        return res;
    }

    public int size() {
        return this.size;
    }

    public void sort() {
        sort(this.head, this.size);
        this.tail = this.getNode(this.size-1);
    }

    /**
     * Merge sort routine - pretty much exactly the recursive merge sort from lecture, but
     * adjusted to the linked-list representation:
     *
     *    *  a sub-list is represented as a pair (start, len), which means that we should sort
     *       the list starting at the start node and going len steps forward.
     *
     *    *  in order to find the midpoint, we need to walk through the linked list one step at
     *       a time, as opposed to simply calculating an index (like we did with arrays). This
     *       takes time proportional to the length of the sub-list we are sorting; luckily,
     *       this does not increase the asymptotic (big-O) runtime, since we do linear work
     *       in the merge step anyways.
     *
     * @param start Node indicating the first node to sort
     * @param len number of nodes to sort
     */
    private void sort(Node start, int len) {
        if (len <= 1) return;

        int mid = len / 2;
        Node rightStart = start;
        for (int i = 0; i < mid; i++) {
            rightStart = rightStart.next;
        }

        sort(start, mid);
        sort(rightStart, len - mid);

        merge(start, mid, rightStart, len - mid);
    }


    private void merge(Node start, int llen, Node rstart, int rlen) {
        /*
        Stuff from the outside is pointing to the node 'start', so our final merged result must
        begin in that node. We first make a copy of the start node, then we fill the start node
        with the correct data - treating the first iteration of the merge loop as a special case
        */
        Node lstart = new Node(start.payload);
        lstart.next = start.next;
        start.next = null;

        if (lstart.payload.compareTo(rstart.payload) < 0) {
            start.payload = lstart.payload;
            lstart = lstart.next;
            llen--;
        }
        else {
            start.payload = rstart.payload;
            rstart = rstart.next;
            rlen--;
        }

        // The merge loop: Always pick the lower one of lstart and rstart,
        // append it to the chain we're building.
        while (llen > 0 && rlen > 0) {
            if (lstart.payload.compareTo(rstart.payload) < 0) {
                start.next = lstart;
                start = start.next;
                lstart = lstart.next;
                llen--;
            }
            else {
                start.next = rstart;
                start = start.next;
                rstart = rstart.next;
                rlen--;
            }
        }

        while (llen > 0) {
            start.next = lstart;
            start = start.next;
            lstart = lstart.next;
            llen--;
        }

        while (rlen > 0) {
            start.next = rstart;
            start = start.next;
            rstart = rstart.next;
            rlen--;
        }

        start.next = rstart;
    }

    public E[] toArray(E[] a) {
        if (a.length < this.size) {
            a = (E[]) Array.newInstance(a.getClass(), this.size);
        }

        int i = 0;
        for (E x : this) {
            a[i++] = x;
        }

        return a;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node here = SortableLinkedList.this.head;

            public boolean hasNext() {
                return this.here != null;
            }

            public E next() {
                E result = here.payload;
                here = here.next;
                return result;
            }

            public void remove() {
                throw new RuntimeException("not implemented");
            }
        };
    }
}
