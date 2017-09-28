package tree;

import gr.personal.datastructures.trees.AVLTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by nkanakis on 9/28/2017.
 */
public class AVLTreeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testInsert() throws Exception {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(10,"10");
        avlTree.insert(20,"20");
        avlTree.insert(30,"30");
        avlTree.insert(40,"40");
        avlTree.insert(50,"50");
        avlTree.insert(25,"25");

        avlTree.preOrder();
        assertEquals("30,20,10,25,40,50,", outContent.toString());

    }

}
