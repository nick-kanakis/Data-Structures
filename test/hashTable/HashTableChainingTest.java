package hashTable;

import gr.personal.datastructures.hashTable.implementation.HashTable;
import gr.personal.datastructures.hashTable.implementation.HashTable;
import gr.personal.datastructures.hashTable.implementation.HashTableChaining;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

/**
 * Created by nkanakis on 9/25/2017.
 */
public class HashTableChainingTest {

    @Test
    public void testInsertAndRetrieve(){
        HashTable table = new HashTableChaining();
        for (int i = 0; i < 100; i++) {
            table.insert(i, "Value of key: "+i);
            assertEquals("Value of key: "+i, table.retrieve(i));
        }
    }

    @Test
    public void testRetrieve(){
        HashTable table = new HashTableChaining();
        assertNull( table.retrieve(1));
    }

    @Test
    public void testDelete(){
        HashTable table = new HashTableChaining();
        for (int i = 0; i < 100; i++) {
            table.insert(i, "Value of key: "+i);
            assertEquals("Value of key: "+i, table.retrieve(i));
        }

        for (int i = 0; i < 100; i++) {
            table.delete(i);
            assertNull( table.retrieve(i));
        }
    }
}
