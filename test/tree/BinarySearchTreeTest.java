package tree;

import gr.personal.datastructures.trees.BinarySearchTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

/**
 * Created by nkanakis on 9/27/2017.
 */
public class BinarySearchTreeTest {

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
    public void testInsert() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();

        bst.insert(10, "10");
        bst.insert(20, "20");
        bst.insert(5, "5");
        bst.insert(15, "15");
        bst.insert(14, "14");
        bst.insert(25, "25");
        bst.insert(6, "6");
        bst.insert(3, "3");
        bst.insert(16, "16");

        assertEquals("10", bst.retrieve(10));
        assertEquals("20", bst.retrieve(20));
        assertEquals("5", bst.retrieve(5));
        assertEquals("15", bst.retrieve(15));
        assertEquals("14", bst.retrieve(14));
        assertEquals("25", bst.retrieve(25));
        assertEquals("6", bst.retrieve(6));
        assertEquals("3", bst.retrieve(3));
        assertEquals("16", bst.retrieve(16));

    }

    @Test
    public void testRetrieveEmptyTree() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        assertNull(bst.retrieve(10));
    }


    @Test
    public void testPreOrder() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();

        bst.insert(10, "10");
        bst.insert(20, "20");
        bst.insert(5, "5");
        bst.insert(15, "15");
        bst.insert(14, "14");
        bst.insert(25, "25");
        bst.insert(6, "6");
        bst.insert(3, "3");
        bst.insert(16, "16");

        bst.printPreOrder();
        assertEquals("10,5,3,6,20,15,14,16,25,", outContent.toString());

    }

    @Test
    public void testPostOrder() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();

        bst.insert(10, "10");
        bst.insert(20, "20");
        bst.insert(5, "5");
        bst.insert(15, "15");
        bst.insert(14, "14");
        bst.insert(25, "25");
        bst.insert(6, "6");
        bst.insert(3, "3");
        bst.insert(16, "16");

        bst.printPostOrder();
        assertEquals("3,6,5,14,16,15,25,20,10,", outContent.toString());

    }

    @Test
    public void testInOrder() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();

        bst.insert(10, "10");
        bst.insert(20, "20");
        bst.insert(5, "5");
        bst.insert(15, "15");
        bst.insert(14, "14");
        bst.insert(25, "25");
        bst.insert(6, "6");
        bst.insert(3, "3");
        bst.insert(16, "16");

        bst.printInOrder();
        assertEquals("3,5,6,10,14,15,16,20,25,", outContent.toString());

    }

    @Test
    public void testDeleteLeaf() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();

        bst.insert(10, "10");
        bst.insert(20, "20");
        bst.insert(5, "5");
        bst.insert(15, "15");
        bst.insert(14, "14");
        bst.insert(25, "25");
        bst.insert(6, "6");
        bst.insert(3, "3");
        bst.insert(16, "16");

        bst.delete(14);
        bst.printInOrder();
        assertEquals("3,5,6,10,15,16,20,25,", outContent.toString());
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();

        bst.insert(10, "10");
        bst.insert(20, "20");
        bst.insert(5, "5");
        bst.insert(15, "15");
        bst.insert(14, "14");
        bst.insert(25, "25");
        bst.insert(6, "6");
        bst.insert(3, "3");
        bst.insert(16, "16");
        bst.insert(30, "30");

        bst.delete(25);
        bst.printInOrder();
        assertEquals("3,5,6,10,14,15,16,20,30,", outContent.toString());
    }

    @Test
    public void testDeleteNodeWithTwoChildWithLeftMostNodes() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();

        bst.insert(10, "10");
        bst.insert(5, "5");
        bst.insert(50, "50");
        bst.insert(14, "14");
        bst.insert(60, "60");
        bst.insert(65, "65");
        bst.insert(55, "55");
        bst.insert(54, "54");
        bst.insert(58, "58");

        bst.delete(50);
        bst.printInOrder();
        assertEquals("5,10,14,54,55,58,60,65,", outContent.toString());
    }

    @Test
    public void testDeleteNodeWithTwoChildWithoutLeftMostNodes() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();

        bst.insert(10, "10");
        bst.insert(5, "5");
        bst.insert(50, "50");
        bst.insert(14, "14");
        bst.insert(60, "60");
        bst.insert(65, "65");
        bst.insert(63, "63");
        bst.insert(70, "70");

        bst.delete(50);
        bst.printInOrder();
        assertEquals("5,10,14,60,63,65,70,", outContent.toString());
    }

}
