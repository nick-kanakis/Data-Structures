package gr.personal.datastructures.stack.implementation;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * Created by Nicolas on 23/9/2017.
 */
public class StackWithArray <Item> implements Stack <Item> {

    private Item[] array;
    private int head = 0;

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
        if(head == 0)
            throw new NoSuchElementException();
        Item poppedItem = array[head];
        array[head] = null;
        head --;
        return poppedItem;
    }

    @Override
    public Item peek() {
        if(head == 0)
            throw new NoSuchElementException();
        return array[head];
    }
}
