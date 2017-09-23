package gr.personal.datastructures.stack.implementation;

import java.util.NoSuchElementException;

/**
 * Created by Nicolas on 23/9/2017.
 */
public class StackWithLinkedList<Item> implements Stack<Item>{

    private class Node{
        Item value;
        Node next;

        public Node(Item value) {
            this.value = value;
        }

        public Node() {
        }
    }

    private Node head;

    public StackWithLinkedList() {
        head = new Node();
    }

    @Override
    public void push(Item item) {

        if(head == null){
            head = new Node(item);
        }

        if(head.value==null){
            head.value = item;
            return;
        }

        Node newHead = new Node(item);
        newHead.next = head;
        head = newHead;
    }

    @Override
    public Item pop() {
        if(head == null || head.value==null)
            throw new NoSuchElementException();

        Node toBeRemoved = head;
        head = head.next;
        return toBeRemoved.value;
    }

    @Override
    public Item peek() {
        if(head == null || head.value==null)
            throw new NoSuchElementException();

        return head.value;
    }
}
