package gr.personal.datastructures.lists.implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 21/9/2017.
 *
 * Linked List API
 * ----------------------------------------------
 *
 *  void    add(Item item)      	    // append an item in the last of list.
 *  boolean isEmpty()                   // returns true if list is empty, false otherwise.
 *  int     size()                      // returns the length of list in integer.
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

    //Add new node at the end.
    public void add(Item value){
        Node lastNode;
        Node addedNode = new Node(value);

        if(head ==null){
            head = addedNode;
            return;
        }

        if(head.value == null){
            head.value = value;
            return;
        }

        lastNode = returnLastNode(head);
        lastNode.nextNode = addedNode;
    }

    private Node returnLastNode(Node head){
        Node tempNode = head;
        while(tempNode.nextNode !=null){
            tempNode = tempNode.nextNode;
        }
        return tempNode;
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
