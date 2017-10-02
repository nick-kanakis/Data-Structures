package Graphs;

import gr.personal.datastructures.graphs.implementation.DirectedGraph;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by nkanakis on 10/2/2017.
 */
public class DirectedGraphTest {

    @Test
    public void testInsert() throws Exception {
        DirectedGraph<String> graph = new DirectedGraph<>();
        List<String> neighbors = new ArrayList<>();

        graph.addNode(1, "1");
        graph.addNode(2, "2");
        graph.addNode(3, "3");
        graph.addNode(4, "4");
        graph.addNode(5, "5");
        graph.addNode(6, "6");
        graph.addNode(7, "7");
        graph.addNode(8, "8");

        assertTrue(graph.nodeExists(1));
        assertTrue(graph.nodeExists(2));
        assertTrue(graph.nodeExists(3));
        assertTrue(graph.nodeExists(4));
        assertTrue(graph.nodeExists(5));
        assertTrue(graph.nodeExists(6));
        assertTrue(graph.nodeExists(7));
        assertTrue(graph.nodeExists(8));

        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,6);
        graph.addEdge(5,6);
        graph.addEdge(6,7);
        graph.addEdge(7,8);
        graph.addEdge(8,1);
        graph.addEdge(8,2);

        neighbors = graph.retrieveNeighbors(1);
        assertArrayEquals(new String[]{"2","3"}, neighbors.toArray(new String[neighbors.size()]));

        neighbors = graph.retrieveNeighbors(2);
        assertArrayEquals(new String[]{"3"}, neighbors.toArray(new String[neighbors.size()]));

        neighbors = graph.retrieveNeighbors(3);
        assertArrayEquals(new String[]{"4","5"}, neighbors.toArray(new String[neighbors.size()]));

        neighbors = graph.retrieveNeighbors(4);
        assertArrayEquals(new String[]{"6"}, neighbors.toArray(new String[neighbors.size()]));

        neighbors = graph.retrieveNeighbors(5);
        assertArrayEquals(new String[]{"6"}, neighbors.toArray(new String[neighbors.size()]));

        neighbors = graph.retrieveNeighbors(6);
        assertArrayEquals(new String[]{"7"}, neighbors.toArray(new String[neighbors.size()]));

        neighbors = graph.retrieveNeighbors(7);
        assertArrayEquals(new String[]{"8"}, neighbors.toArray(new String[neighbors.size()]));

        neighbors = graph.retrieveNeighbors(8);
        assertArrayEquals(new String[]{"1","2"}, neighbors.toArray(new String[neighbors.size()]));
    }

    @Test
    public void testDelete() throws Exception {
        DirectedGraph<String> graph = new DirectedGraph<>();
        List<String> neighbors = new ArrayList<>();

        graph.addNode(1, "1");
        graph.addNode(2, "2");
        graph.addNode(3, "3");
        graph.addNode(4, "4");
        graph.addNode(5, "5");
        graph.addNode(6, "6");
        graph.addNode(7, "7");
        graph.addNode(8, "8");

        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,6);
        graph.addEdge(5,6);
        graph.addEdge(6,7);
        graph.addEdge(7,8);
        graph.addEdge(8,1);
        graph.addEdge(8,2);


        graph.removeEdge(8,2);
        neighbors = graph.retrieveNeighbors(8);
        assertArrayEquals(new String[]{"1"}, neighbors.toArray(new String[neighbors.size()]));

        graph.removeEdge(1,3);
        neighbors = graph.retrieveNeighbors(1);
        assertArrayEquals(new String[]{"2"}, neighbors.toArray(new String[neighbors.size()]));

        graph.removeNode(5);
        assertFalse(graph.nodeExists(5));

        neighbors = graph.retrieveNeighbors(3);
        assertArrayEquals(new String[]{"4"}, neighbors.toArray(new String[neighbors.size()]));

    }
}
