package heap;

import gr.personal.datastructures.heap.implementation.Heap;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 30/9/2017.
 */
public class HeapTest {

    @Test
    public void testInsertHeap(){

        Heap heap = new Heap();

        heap.insert(5);
        int[] correctArray = {5,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(correctArray, heap.retrieveArray());

        heap.insert(3);
        correctArray = new int[]{5,3,0,0,0,0,0,0,0,0};
        assertArrayEquals(correctArray, heap.retrieveArray());

        heap.insert(2);
        correctArray = new int[]{5,3,2,0,0,0,0,0,0,0};
        assertArrayEquals(correctArray, heap.retrieveArray());

        heap.insert(10);
        correctArray = new int[]{10,5,2,3,0,0,0,0,0,0};
        assertArrayEquals(correctArray, heap.retrieveArray());

        heap.insert(4);
        correctArray = new int[]{10,5,2,3,4,0,0,0,0,0};
        assertArrayEquals(correctArray, heap.retrieveArray());

        heap.insert(8);
        correctArray = new int[]{10,5,8,3,4,2,0,0,0,0};
        assertArrayEquals(correctArray, heap.retrieveArray());

        heap.insert(11);
        correctArray = new int[]{11,5,10,3,4,2,8,0,0,0};
        assertArrayEquals(correctArray, heap.retrieveArray());

        heap.insert(1);
        correctArray = new int[]{11,5,10,3,4,2,8,1,0,0};
        assertArrayEquals(correctArray, heap.retrieveArray());

        heap.insert(15);
        correctArray = new int[]{15,11,10,5,4,2,8,1,3,0};
        assertArrayEquals(correctArray, heap.retrieveArray());

        heap.insert(6);
        correctArray = new int[]{15,11,10,5,6,2,8,1,3,4};
        assertArrayEquals(correctArray, heap.retrieveArray());

        heap.insert(7);
        correctArray = new int[]{15,11,10,5,7,2,8,1,3,4,6,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(correctArray, heap.retrieveArray());

    }


    @Test
    public void testMaxExtraction() throws Exception {

        Heap heap = new Heap();

        heap.insert(5);
        heap.insert(3);
        heap.insert(2);
        heap.insert(10);
        heap.insert(4);
        heap.insert(8);
        heap.insert(11);
        heap.insert(1);
        heap.insert(15);
        heap.insert(6);


        int[] correctArray = new int[]{11,6,10,5,4,2,8,1,3,0};
        assertEquals(15, heap.extractMax());
        assertArrayEquals(correctArray, heap.retrieveArray());

        correctArray = new int[]{10,6,8,5,4,2,3,1,0,0};
        assertEquals(11, heap.extractMax());
        assertArrayEquals(correctArray, heap.retrieveArray());

        correctArray = new int[]{8,6,3,5,4,2,1,0,0,0};
        assertEquals(10, heap.extractMax());
        assertArrayEquals(correctArray, heap.retrieveArray());

        correctArray = new int[]{6,5,3,1,4,2,0,0,0,0};
        assertEquals(8, heap.extractMax());
        assertArrayEquals(correctArray, heap.retrieveArray());

        correctArray = new int[]{5,4,3,1,2,0,0,0,0,0};
        assertEquals(6, heap.extractMax());
        assertArrayEquals(correctArray, heap.retrieveArray());

        correctArray = new int[]{4,2,3,1,0,0,0,0,0,0};
        assertEquals(5, heap.extractMax());
        assertArrayEquals(correctArray, heap.retrieveArray());

        correctArray = new int[]{3,2,1,0,0,0,0,0,0,0};
        assertEquals(4, heap.extractMax());
        assertArrayEquals(correctArray, heap.retrieveArray());

        correctArray = new int[]{2,1,0,0,0,0,0,0,0,0};
        assertEquals(3, heap.extractMax());
        assertArrayEquals(correctArray, heap.retrieveArray());

        correctArray = new int[]{1,0,0,0,0,0,0,0,0,0};
        assertEquals(2, heap.extractMax());
        assertArrayEquals(correctArray, heap.retrieveArray());

        correctArray = new int[]{0,0,0,0,0,0,0,0,0,0};
        assertEquals(1, heap.extractMax());
        assertArrayEquals(correctArray, heap.retrieveArray());


    }
}
