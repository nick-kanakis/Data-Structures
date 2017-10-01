package trie;

import gr.personal.datastructures.trie.implementation.Trie;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nicolas on 1/10/2017.
 */
public class TrieTest {

    @Test
    public void testInsert() throws Exception {
        Trie trie = new Trie();

        trie.insert("Doggy");
        assertTrue(trie.searchWord("Doggy"));

        trie.insert("Dogs");
        assertTrue(trie.searchWord("Dogs"));

        trie.insert("Dog");
        assertTrue(trie.searchWord("Dog"));
        assertTrue(trie.searchPrefix("Do"));


    }

    @Test
    public void testDelete() throws Exception {
        Trie trie = new Trie();
        trie.insert("DOG");
        assertTrue(trie.searchWord("DOG"));
        trie.insert("DOGS");
        assertTrue(trie.searchWord("DOGS"));
        trie.insert("DOGGY");
        assertTrue(trie.searchWord("DOGGY"));

        trie.deleteWord("DOG");
        assertFalse(trie.searchWord("DOG"));
        assertTrue(trie.searchWord("DOGS"));
        assertTrue(trie.searchWord("DOGGY"));

        trie.deleteWord("DOGGY");
        assertFalse(trie.searchWord("DOGGY"));
        assertTrue(trie.searchWord("DOGS"));

        trie.deleteWord("DOGS");
        assertFalse(trie.searchWord("DOGS"));
        assertFalse(trie.searchWord("DOG"));
        assertFalse(trie.searchWord("DOGGY"));
    }
}
