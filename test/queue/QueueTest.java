package queue;

import gr.personal.datastructures.queue.implementation.Queue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 23/9/2017.
 */
public class QueueTest {

    @Test
    public void testEnqueue() throws Exception {
        Queue<Integer> queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1,(int) queue.dequeue());
        assertEquals(2,(int) queue.dequeue());
        queue.enqueue(3);
        queue.enqueue(4);
        assertEquals(3,(int) queue.dequeue());
        assertEquals(4,(int) queue.dequeue());
    }

    @Test
    public void testDequeue() throws Exception {
        Queue<Integer> queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        assertEquals(1,(int) queue.dequeue());
        assertEquals(2,(int) queue.dequeue());
        assertEquals(3,(int) queue.dequeue());
        assertEquals(4,(int) queue.dequeue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDequeueOutOfBound() throws Exception {
        Queue<Integer> queue = new Queue();
        queue.dequeue();

    }


    @Test
    public void testPeek() throws Exception {
        Queue<Integer> queue = new Queue();
        queue.enqueue(1);
        assertEquals(1,(int) queue.peek());
        queue.enqueue(2);
        assertEquals(1,(int) queue.peek());
    }

    @Test
    public void testEmpty() throws Exception {
        Queue<Integer> queue = new Queue();
        assertEquals(true, queue.isEmpty());
        queue.enqueue(1);
        assertEquals(false, queue.isEmpty());
    }
}
