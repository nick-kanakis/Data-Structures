package lists;

import gr.personal.datastructures.lists.implementation.LinkedList;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 21/9/2017.
 */


public class LinkedListTest  {

    @Test
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

    @Test
    public void testIsEmpty(){
        LinkedList<Integer> list = new LinkedList();
        assertEquals(true, list.isEmpty());

        list.add(1);
        assertEquals(false, list.isEmpty());
    }

    @Test
    public void testSize(){
        LinkedList<Integer> list = new LinkedList();
        assertEquals(0, list.size());

        list.add(1);
        assertEquals(1, list.size());

        list.add(1);
        assertEquals(2, list.size());
    }

    @Test
    public void testAddWithIndex(){

        LinkedList<Integer> list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.add(5,2);
        assertEquals(5, list.size());

        ArrayList<Integer> expectedResults = new ArrayList();
        expectedResults.add(1);
        expectedResults.add(2);
        expectedResults.add(5);
        expectedResults.add(3);
        expectedResults.add(4);

        List<Integer> results = list.returnValues();
        for (int i = 0; i < expectedResults.size(); i++) {
            assertEquals(expectedResults.get(i), results.get(i));
        }
    }

    @Test
    public void testAddWithIndexToBeginning(){

        LinkedList<Integer> list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.add(5,0);
        assertEquals(5, list.size());

        ArrayList<Integer> expectedResults = new ArrayList();
        expectedResults.add(5);
        expectedResults.add(1);
        expectedResults.add(2);
        expectedResults.add(3);
        expectedResults.add(4);

        List<Integer> results = list.returnValues();
        for (int i = 0; i < expectedResults.size(); i++) {
            assertEquals(expectedResults.get(i), results.get(i));
        }
    }

    @Test
    public void testAddWithIndexToEnd(){

        LinkedList<Integer> list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.add(5,3);
        assertEquals(5, list.size());

        ArrayList<Integer> expectedResults = new ArrayList();
        expectedResults.add(1);
        expectedResults.add(2);
        expectedResults.add(3);
        expectedResults.add(5);
        expectedResults.add(4);

        List<Integer> results = list.returnValues();
        for (int i = 0; i < expectedResults.size(); i++) {
            assertEquals(expectedResults.get(i), results.get(i));
        }
    }

    @Test
    public void testGet(){
        LinkedList<Integer> list = new LinkedList();
        list.add(1);
        assertEquals(1, list.get(0).intValue());
        list.add(2);
        assertEquals(2, list.get(1).intValue());
        list.add(3);
        assertEquals(3, list.get(2).intValue());
        list.add(4);
        assertEquals(4, list.get(3).intValue());
    }

    @Test
    public void testRemove(){
        LinkedList<Integer> list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.remove(1);

        ArrayList<Integer> expectedResults = new ArrayList();
        expectedResults.add(1);
        expectedResults.add(3);
        expectedResults.add(4);

        List<Integer> results = list.returnValues();
        for (int i = 0; i < expectedResults.size(); i++) {
            assertEquals(expectedResults.get(i), results.get(i));
        }
    }

    @Test
    public void testRemoveBeginning(){
        LinkedList<Integer> list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.remove(0);

        ArrayList<Integer> expectedResults = new ArrayList();
        expectedResults.add(2);
        expectedResults.add(3);
        expectedResults.add(4);

        List<Integer> results = list.returnValues();
        for (int i = 0; i < expectedResults.size(); i++) {
            assertEquals(expectedResults.get(i), results.get(i));
        }
    }

    @Test
    public void testRemoveEnd(){
        LinkedList<Integer> list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.remove(3);

        ArrayList<Integer> expectedResults = new ArrayList();
        expectedResults.add(1);
        expectedResults.add(2);
        expectedResults.add(3);

        List<Integer> results = list.returnValues();
        for (int i = 0; i < expectedResults.size(); i++) {
            assertEquals(expectedResults.get(i), results.get(i));
        }
    }
}
