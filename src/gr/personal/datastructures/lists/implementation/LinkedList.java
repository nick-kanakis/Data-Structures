package gr.personal.datastructures.lists.implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 21/9/2017.
 *
 * Linked List API
 * ----------------------------------------------
 *
 *  boolean isEmpty()                   // returns true if list is empty, false otherwise.
 *  int     size()                      // returns the length of list in integer.
 *  void    add(Item item)      	    // append an item in the last of list.
 *  void    add(Item item, int index)   //append an item at the given index in the list.
 *  Item    get(int index)              // returns the item at the given index from the list.
 *  boolean remove(int index)	        // remove the node and return true at the given index from the list.
 *
 */
public class LinkedList<Item> {

    private Node head;

    public class Node{
        Item value;
        Node nextNode;

        public Node(Item value) {
            this.value = value;
        }

        public Node() {
        }
    }

    public LinkedList() {
        head = new Node();
    }


    public boolean isEmpty(){
        if (head == null || head.value ==null)
            return true;
        return false;
    }

    public int size(){
        if (head == null || head.value ==null)
            return 0;
        Node tempNode = head;
        int sizeCount = 1;
        while(tempNode.nextNode !=null){
            tempNode = tempNode.nextNode;
            sizeCount++;
        }
        return sizeCount;
    }

    public void add(Item value){
        Node lastNode = head;
        Node addedNode = new Node(value);

        if(head == null){
            head = addedNode;
            return;
        }

        if(head.value == null){
            head.value = value;
            return;
        }

        while(lastNode.nextNode !=null){
            lastNode = lastNode.nextNode;
        }
        lastNode.nextNode = addedNode;
    }

    public void add(Item value, int index) {
        validateIndex(index);

        Node addedNode = new Node(value);

        if(index == 0){
            addedNode.nextNode = head;
            head = addedNode;
            //DO NOT FORGET THE RETURN!
            return;
        }

        Node beforeIndexNode = head;
        for (int i = 0; i < index - 1; i++) {
            beforeIndexNode = beforeIndexNode.nextNode;
        }

        addedNode.nextNode = beforeIndexNode.nextNode;
        beforeIndexNode.nextNode = addedNode;
    }

    public Item get(int index) {
        validateIndex(index);

        Node currentNode = head;
        for (int i = 0; i < index ; i++) {
            if(currentNode == null)
                throw new IndexOutOfBoundsException();
            currentNode = currentNode.nextNode;
        }
        return currentNode.value;
    }

    public void remove(int index){
        validateIndex(index);

        if(index == 0)
            head = head.nextNode;

        Node previousNode = head;
        Node toBeDeletedNode = head;
        for (int i = 0; i < index ; i++) {
            if(toBeDeletedNode == null)
                throw new IndexOutOfBoundsException();
            previousNode = toBeDeletedNode;
            toBeDeletedNode = toBeDeletedNode.nextNode;
        }

        previousNode.nextNode = toBeDeletedNode.nextNode;
    }

    private void validateIndex(int index){
        if(index<0 || index >size())
            throw new IndexOutOfBoundsException();
    }

    public List<Item> returnValues(){
        Node tempNode = head;
        ArrayList<Item> result = new ArrayList<>();

        while(tempNode.nextNode !=null){
            result.add(tempNode.value);
            tempNode = tempNode.nextNode;
        }
        result.add(tempNode.value);
        return result;
    }
}
