package gr.personal.datastructures.hashTable.implementation;

import java.lang.reflect.Array;

/**
 * Created by Nicolas on 24/9/2017.
 *
 * We have a fixed array of a default size. Collisions will be dealt with Linear probing,
 * This means that when a collision occurs we will search in the next spot for a free space.
 *
 * This may cause clustering issues but Quadratic Probing / double hashing is beyond the scope
 * of this implementation
 *
 * NOTE: Keys MUST be unique!
 */
public class HashTableOpenAddressing<V> implements HashTable <V> {

    public class Entry{
        int key;
        V value;
        boolean deletedFlag;

        public Entry(int key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_BUCKET_SIZE = 20;
    private Entry bucket[];

    public HashTableOpenAddressing(int size) {
        this.bucket = (Entry[]) Array.newInstance(Entry.class, size);
    }

    public HashTableOpenAddressing() {
        this(DEFAULT_BUCKET_SIZE);
    }

    @Override
    public void insert(int key, V value) {
        int hashedKey = hash(key);
        bucket[FindEmptySlotLinearProbing(hashedKey)] = new Entry(key, value);
    }

    @Override
    public void delete(int key) {
        int hashedKey = hash(key);
        int slot = FindValueLinearProbing(hashedKey, key);
        if (slot == -1)
            return ;
        bucket[slot].deletedFlag = true;
    }

    @Override
    public V retrieve(int key) {
        int hashedKey = hash(key);
        int slot = FindValueLinearProbing(hashedKey, key);
        if (slot == -1)
            return null;
        return (V) bucket[slot].value;
    }

    public int size(){
        int count = 0;
        for (int i = 0; i < bucket.length; i++) {
            if(bucket[i] !=null && !bucket[i].deletedFlag)
                count++;
        }
        return count;
    }

    //A pretty naive implementation of hash function
    private int hash(int key){
        return key % bucket.length;
    }

    private int FindEmptySlotLinearProbing(int startingPoint){
        for (int i = startingPoint; i < bucket.length + startingPoint; i++) {
            int probedPosition = i % bucket.length;
            if(bucket[probedPosition] == null || bucket[probedPosition].deletedFlag)
                return probedPosition;
        }
        throw new IndexOutOfBoundsException();
    }

    private int FindValueLinearProbing(int startingPoint, int key){
        for (int i = startingPoint; i < bucket.length + startingPoint; i++) {
            int probedPosition = i % bucket.length;

            if(bucket[probedPosition] == null)
                return -1;

            if(bucket[probedPosition].key == key)
                return probedPosition;
        }
        throw new IndexOutOfBoundsException();
    }
}
