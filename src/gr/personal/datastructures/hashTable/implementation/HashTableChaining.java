package gr.personal.datastructures.hashTable.implementation;

import com.sun.org.apache.regexp.internal.RE;

import java.lang.reflect.Array;

/**
 * Created by Nicolas on 24/9/2017.
 *
 * We have a fixed array of a default size. Each cell of the array is a pointer to
 * the head of a linked list.
 *
 * NOTE: integers MUST be unique!
 */
public class HashTableChaining<V> implements HashTable<V> {

    public class Entry{
        int key;
        V value;

        public Entry(int key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public class Node{
        Entry entry;
        Node next;

        public Node(int key, V value) {
            this.entry = new Entry(key, value);
        }

        public Node() {
        }
    }

    private static final int DEFAULT_BUCKET_SIZE = 10;
    private Node bucket[];

    public HashTableChaining(int size) {
        this.bucket = (Node[]) Array.newInstance(Node.class, size);
    }

    public HashTableChaining() {
        this(DEFAULT_BUCKET_SIZE);
    }

    @Override
    public void insert(int key, V value) {
        int hashedKey = hash(key);

        Node newNode = new Node(key, value);

        if(bucket[hashedKey] == null) {
            bucket[hashedKey] = newNode;
            return;
        }
        Node currentRoot = bucket[hashedKey];

        bucket[hashedKey] = newNode;
        newNode.next = currentRoot;

        /*
        There is no need to insert it in the end of the list
        Insert in in the front so the time will be: O(1)

        while(currentRoot.next != null){
            currentRoot = currentRoot.next;
        }
        currentRoot.next = new Node(key, value);*/
    }

    @Override
    public void delete(int key) {
        int hashedKey = hash(key);

        if(bucket[hashedKey] == null)
            return;

        if(bucket[hashedKey].entry.key == key){
            bucket[hashedKey] = bucket[hashedKey].next;
            return;
        }

        Node previousNode = bucket[hashedKey];
        Node toBeDeleted = bucket[hashedKey].next;

        while(toBeDeleted != null){
            if(toBeDeleted.entry.key == key){
                previousNode.next = toBeDeleted.next;
                return;
            }
            previousNode = toBeDeleted;
            toBeDeleted = toBeDeleted.next;
        }
    }

    @Override
    public V retrieve(int key) {
        int hashedKey = hash(key);
        Node currentNode = bucket[hashedKey];

        if(bucket[hashedKey] == null)
            return null;

        while(currentNode != null){
            if(currentNode.entry.key == key)
                return currentNode.entry.value;
            currentNode = currentNode.next;
        }
        return null;
    }

    //A pretty naive implementation of hash function
    private int hash(int key){
        return key % bucket.length;
    }
}
