package no.uib.ii.inf102.f18.mandatory0;

import java.util.Iterator;

/**
 * This is an example of a class implementing the ISortable Interface.
 * Many of the implementation details in this are quite silly and
 * dangerous (may easily throw IndexOutOfBoundExceptions), but at
 * least it pass some small sanity tests
 *
 * @author Torstein Strømme
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class SortableArrayList<E extends Comparable<E>> implements ISortableList<E> {

    private Comparable[] arr = new Comparable[100];
    private int size = 0;


    public void add(E element) {
        this.add(this.size, element);
    }

    public void add(int index, E element) {
        // Move stuff around
        for (int i = this.size; i > index; i--) {
            this.arr[i] = this.arr[i-1];
        }
        this.arr[index] = element;
        this.size++;
    }

    public void clear() {
        this.size = 0;
    }

    public E get(int index) {
        return (E) this.arr[index];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E remove(int index) {
        E res = (E) this.arr[index];
        // Move stuff around
        for (int i = index; i < this.size; i++) {
            this.arr[i] = this.arr[i+1];
        }
        this.size--;
        return res;
    }

    public int size() {
        return this.size;
    }

    public void sort() {
        // I have no idea what I am doing
        int n = this.size - 1;
        int i = n * this.size;
        while (--i >= 0) {
            if (this.arr[i % n].compareTo(this.arr[(i % n) + 1]) > 0) {
                Comparable tmp = this.arr[i % n];
                this.arr[i % n] = this.arr[(i % n) + 1];
                this.arr[(i % n) + 1] = tmp;
            }
        }
    }

    public E[] toArray(E[] a) {
        for (int i = 0; i < this.size; i++) {
            a[i] = (E) this.arr[i];
        }
        return a;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = 0;

            public boolean hasNext() {
                return this.i < SortableArrayList.this.size;
            }

            public E next() {
                return (E) SortableArrayList.this.arr[this.i++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }
}
