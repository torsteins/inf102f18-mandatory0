package no.uib.ii.inf102.f18.mandatory0;

import java.util.Iterator;

/**
 * A list based on a linked list which supports the "adjoin" -operation in constant time.
 * The adjoin operation glues the provided list to the current list.
 *
 * @author Torstein Strømme
 *
 * @param <E> type of items in list
 */
public class JoinableLinkedList<E> implements Iterable<E> {

    private class Node {
        E payload;
        Node next = null;

        Node(E item) {
            this.payload = item;
        }
    }

    private Node head;
    private Node tail;
    private boolean active = true;

    public JoinableLinkedList(E thing) {
        add(thing);
    }

    /**
     * Add an element to the end of the list
     *
     * @param element element to be added
     */
    public void add(E element) {
        verifyActive();
        if (this.tail == null) {
            this.head = this.tail = new Node(element);
        }
        else {
            this.tail.next = new Node(element);
            this.tail = this.tail.next;
        }
    }

    private void verifyActive() {
        if (!this.active)
            throw new RuntimeException("This JoinableLinkedList is no longer active - perhaps" +
                    " it was adjoined to another JoinableLinkedList.");
    }

    /**
     * adjoin the provided list to the current list.
     *
     * This is done by reference in constant time, gluing the tail
     * of 'this' list to the head of 'that' list; as a consequence,
     * the client should consider 'that' list as garbage, and
     * remove all references to it.
     *
     * To aide the client code not to do something stupid, 'that' list
     * will be destroyed, and any calls on that list will yield an Exception.
     *
     * @param that list to be adjoined.
     */
    public JoinableLinkedList<E> adjoin(JoinableLinkedList<E> that) {
        verifyActive();
        this.tail.next = that.head;
        this.tail = that.tail;
        that.active = false;
        return this;
    }

    public Iterator<E> iterator() {
        verifyActive();
        return new Iterator<E>() {
            Node here = JoinableLinkedList.this.head;
            public boolean hasNext() {
                return here != null;
            }

            public E next() {
                E result = here.payload;
                here = here.next;
                return result;
            }

            public void remove() {
                throw new RuntimeException("remove is not implemented");
            }
        };
    }

}
