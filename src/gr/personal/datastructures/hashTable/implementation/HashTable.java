package gr.personal.datastructures.hashTable.implementation;

/**
 * Created by Nicolas on 24/9/2017.
 */
public interface HashTable<V> {

    void insert(int key, V value);
    void delete(int key);
    V retrieve(int key);
}
