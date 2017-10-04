package gr.personal.datastructures.stack.implementation;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * Created by Nicolas on 23/9/2017.
 */
public class StackWithArray <Item> implements Stack <Item> {

    private Item[] array;
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
