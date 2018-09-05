package no.uib.ii.inf102.f18.mandatory0;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for SortableArrayList
 */
public class SortableArrayListTest extends TestCase {
    private ISortableList<Integer> iList;

    /**
     * Create the test case. Can do some setup here which
     * is common for everyone
     *
     * @param testName name of the test case
     */
    public SortableArrayListTest( String testName )
    {
        super( testName );
        iList = new SortableArrayList<Integer>();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SortableArrayListTest.class );
    }

    /**
     * Sanity test 1
     */
    public void testSanity1() {
        // Add three elements - access them. List is then [1, 3, 4]
        iList.add(1);
        iList.add(3);
        iList.add(4);

        assertEquals(1, (int) iList.get(0));
        assertEquals(4, (int) iList.get(2));
        assertEquals(3,  iList.size());

        // Insert an element in position 1. List is then [1, 6, 3, 4]
        iList.add(1, 6);
        assertEquals(6, (int) iList.get(1));
        assertEquals(4, (int) iList.get(3));
        assertEquals(4, iList.size());

        // Remove an element in position 2. List is then [1, 6, 4]
        assertEquals(3, (int) iList.remove(2));
        assertEquals(4, (int) iList.get(2));
        assertEquals(3, iList.size());
        assertFalse(iList.isEmpty());

        // Clear the data structure. List is now empty
        iList.clear();
        assertEquals(0, iList.size());
        assertTrue(iList.isEmpty());
    }
    
    /**
     * Sanity test 2
     */
    public void testSanity2() {
        // Add some elements. The list is then [1, 4, 3, 9, 0]
        iList.add(1);
        iList.add(4);
        iList.add(3);
        iList.add(9);
        iList.add(0);

        // Sort the list. The list is then [0, 1, 3, 4, 9]
        iList.sort();

        // Convert to array.
        Integer[] arr = new Integer[5];
        arr = iList.toArray(arr);

        assertEquals("[0, 1, 3, 4, 9]", Arrays.toString(arr));

        // Loop over to check that iterator matches
        int i = 0;
        for (Integer x : iList) {
            assertEquals(arr[i++], x);
        }
    }
}
