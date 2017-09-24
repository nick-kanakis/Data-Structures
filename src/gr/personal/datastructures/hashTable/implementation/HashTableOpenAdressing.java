package gr.personal.datastructures.hashTable.implementation;

/**
 * Created by Nicolas on 24/9/2017.
 *
 * We have a fixed array of a default size. Collisions will be dealt with Linear probing,
 * This means that when a collision occurs we will search in the next spot for a free space.
 *
 * This may cause clustering issues but Quadratic Probing/ double hashing is beyond the scope
 * of the Implementation
 *
 */
public class HashTableOpenAdressing <K,V> implements HashTable <K,V> {
    @Override
    public void insert(K key, V value) {

    }

    @Override
    public void delete(K key) {

    }

    @Override
    public V retrieve(K key) {
        return null;
    }
}
