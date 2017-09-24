package gr.personal.datastructures.hashTable.implementation;

/**
 * Created by Nicolas on 24/9/2017.
 */
public interface HashTable<K,V> {

    void insert(K key, V value);
    void delete(K key);
    V retrieve(K key);
}
