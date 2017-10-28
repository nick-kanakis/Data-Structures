package gr.personal.datastructures.queue.implementation;


import java.util.NoSuchElementException;

/**
 * Created by Nicolas on 23/9/2017.
 * Linked List API
 * ----------------------------------------------
 *
 *  boolean isEmpty()                   // returns true if queue is empty, false otherwise.
 *  void    enqueue(Item item)      	// append an item in the queue.
 *  Item    dequeue()                   // returns & removes the item from the front of the queue.
 *  Item    peek()                      // returns the item from the front of the queue.
 *
 *  Enqueue: New elements are always added to the end
 *  Dequeue: Elements are removed from the head.
 */
public class Queue<Item> {

    private Node head;
    private Node tail;

    public class Node{
        Item value;
        Node nextNode;

        public Node(Item value) {
            this.value = value;
        }

        public Node() {
        }
    }

    public void enqueue(Item item){
        if(tail ==null){
            tail = new Node(item);
            head = tail ;
            return;
        }
        if(tail.value == null){
            tail.value = item;
            head = tail ;
            return;
        }

        Node newTail = new Node(item);
        tail.nextNode = newTail;
        tail = newTail;
    }

    public Item dequeue(){

        if(head == null || head.value ==null)
            throw new IndexOutOfBoundsException();

        Item toBeReturned = head.value;

        // WARNING: If only one element in queue head==tail, both pointers must be null not only the head.
        if(tail == head){
            tail = null;
            head = null;
            return toBeReturned;
        }

        head = head.nextNode;
        return toBeReturned;
    }

    public Item peek(){

        if(head == null || head.value ==null)
            throw new IndexOutOfBoundsException();

        return head.value;

    }

    public boolean isEmpty(){

        if(head == null || head.value ==null)
            return true;
        return false;
    }
}
