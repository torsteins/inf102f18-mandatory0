package no.uib.ii.inf102.f18.mandatory0;

/**
 * The ISortableList interface is inspired by the java.util.List interface
 * (see https://docs.oracle.com/javase/8/docs/api/java/util/List.html), but
 * is not as comprehensive.
 *
 * However, it requires that the class has a sorting
 * method, and the list must consist of comparable objects.
 *
 */
public interface ISortableList<E extends Comparable<E>> extends Iterable<E> {

    /**
     * Add the item at the end of the list
     *
     * @param element item to be added
     */
    void add(E element);


    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index index
     * @param element item
     */
    void add(int index, E element);


    /**
     * Clear all elements from the list
     */
    void clear();


    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index
     * @return element at the index
     */
    E get(int index);


    /**
     * Returns true if this list contains no elements.
     *
     * @return true if list is empty, false otherwise
     */
    boolean isEmpty();


    /**
     * Removes and returns the element at the specified position in this list.
     *
     * @param index index of element to be removed
     * @return the removed element
     */
    E remove(int index);


    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    int size();


    /**
     * Sort this list according to the natural order of the elements
     */
    void sort();


    /**
     * Will fill the provided array with all of the elements in this list in proper
     * sequence. If the array is not large enough, an IndexOutOfBoundesException is
     * thrown. If the array is larger than the list, it will be padded with null
     * at the end.
     *
     * @return an array containing all of the elements in this list in proper sequence
     */
    E[] toArray(E[] a);
}
