package stack;

import gr.personal.datastructures.stack.implementation.Stack;
import gr.personal.datastructures.stack.implementation.StackWithArray;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 23/9/2017.
 */
public class StackWithArrayTest  {

    @Test
    public void testPush(){
        Stack<Integer> stack = new StackWithArray<>(5);
        stack.push(1);
        assertEquals(1, (int) stack.peek());
        stack.push(2);
        assertEquals(2,(int)  stack.peek());
        stack.push(3);
        assertEquals(3, (int) stack.peek());
        stack.push(4);
        assertEquals(4, (int) stack.peek());
        stack.push(5);
        assertEquals(5, (int) stack.peek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testStackOverflow(){
        Stack<Integer> stack = new StackWithArray<>(1);
        stack.push(1);
        stack.push(2);
    }

    @Test
    public void testPop(){
        Stack<Integer> stack = new StackWithArray<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(4, (int) stack.pop());
        assertEquals(3, (int) stack.pop());
        assertEquals(2, (int) stack.pop());
        assertEquals(1, (int) stack.pop());
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyStackPoping(){
        Stack<Integer> stack = new StackWithArray<>(1);
        stack.pop();
    }

    @Test
    public void testPeek(){
        Stack<Integer> stack = new StackWithArray<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(4, (int) stack.peek());
        stack.pop();
        assertEquals(3, (int) stack.peek());
        stack.pop();
        assertEquals(2, (int) stack.peek());
        stack.pop();
        assertEquals(1, (int) stack.peek());
    }

}
