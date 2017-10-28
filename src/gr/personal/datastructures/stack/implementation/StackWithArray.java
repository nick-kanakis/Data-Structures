package gr.personal.datastructures.stack.implementation;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * Created by Nicolas on 23/9/2017.
 */
public class StackWithArray <Item> implements Stack <Item> {

    private Item[] array;
    //Warning start with -1 and not 0
    private int head = -1;

    public StackWithArray(int size) {
        this.array = (Item[]) new Object[size];
    }

    @Override
    public void push(Item item) {
        if(head == array.length -1)
            throw new IndexOutOfBoundsException();
        head ++;
        array[head] = item;
    }

    @Override
    public Item pop() {
        //Always check the value of the head pointer
        if(head == -1)
            throw new NoSuchElementException();
        Item poppedItem = array[head];
        head --;
        return poppedItem;
    }

    @Override
    public Item peek() {
        if(head == -1)
            throw new NoSuchElementException();
        return array[head];
    }
}
