package hashTable;

import gr.personal.datastructures.hashTable.implementation.HashTable;
import gr.personal.datastructures.hashTable.implementation.HashTableChaining;
import gr.personal.datastructures.hashTable.implementation.HashTableOpenAddressing;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

/**
 * Created by nkanakis on 9/25/2017.
 */
public class HashTableOpenAddressingTest {

    @Test
    public void testInsertAndRetrieve(){
        HashTableOpenAddressing table = new HashTableOpenAddressing(10);
        for (int i = 13; i < 23; i++) {
            table.insert(i, "Value of key: "+i);
            assertEquals("Value of key: "+i, table.retrieve(i));
        }
        assertEquals(10, table.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertOutOfBound(){
        HashTableOpenAddressing table = new HashTableOpenAddressing(9);
        for (int i = 0; i < 10; i++) {
            table.insert(i, "Value of key: "+i);
        }
    }

    @Test
    public void testRetrieve(){
        HashTable table = new HashTableOpenAddressing();
        assertNull( table.retrieve(1));
    }


    @Test
    public void testDelete(){
        HashTableOpenAddressing table = new HashTableOpenAddressing(100);
        for (int i = 0; i < 100; i++) {
            table.insert(i, "Value of key: "+i);
            assertEquals("Value of key: "+i, table.retrieve(i));
        }

        for (int i = 0; i < 100; i++) {
            table.delete(i);
        }
        assertEquals(0, table.size());

    }
}
