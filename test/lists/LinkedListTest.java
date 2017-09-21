package lists;

import gr.personal.datastructures.lists.implementation.LinkedList;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 21/9/2017.
 */


public class LinkedListTest extends TestCase {

    public void testAdd(){

        ArrayList<Integer> expectedResults = new ArrayList();
        expectedResults.add(1);
        expectedResults.add(2);
        expectedResults.add(3);

        LinkedList<Integer> list = new LinkedList();
        for (Integer tempInt: expectedResults ) {
            list.add(tempInt);
        }
        List<Integer> results = list.returnValues();

        assertEquals(expectedResults.size(), results.size());

        for (int i = 0; i < expectedResults.size(); i++) {
            assertEquals(expectedResults.get(i), results.get(i));
        }
    }
}
