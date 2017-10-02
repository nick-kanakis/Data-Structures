package gr.personal.datastructures.graphs.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nkanakis on 10/2/2017.
 */
public class UndirectedGraph<V> {

    class Node {
        private V value;
        private int key;
        List<Integer> neighbors;

        public Node(int key, V value) {
            this.value = value;
            this.key = key;
            neighbors = new ArrayList<>();
        }
    }

    private Map<Integer, Node> vertices = new HashMap<>();

    public void addNode(int key, V value) {
        Node newNode = new Node(key,value);
        vertices.put(key, newNode);
    }

    public void addEdge(int key1, int key2) {
        Node node1 = vertices.get(key1);
        Node node2 = vertices.get(key2);

        if(node1 == null || node2 == null)
            return;

        node1.neighbors.add(key2);
        node2.neighbors.add(key1);

    }

    public void removeNode(Integer key) {
        if(!nodeExists(key))
            return;

        Node toBeRemovedNode = vertices.get(key);

        for (Integer child : toBeRemovedNode.neighbors) {
            //retrieve actual neighbor node and delete any reference of the toBeRemovedNode
            vertices.get(child).neighbors.remove(key);
        }
        vertices.remove(key);
    }

    /*
    * When working with hashmap use Integer instead of int as keys. Because integer are used as indexes!
    * */

    public void removeEdge(Integer key1, Integer key2) {
        Node node1 = vertices.get(key1);
        Node node2 = vertices.get(key2);

        if(node1 == null || node2 == null)
            return;

        node1.neighbors.remove(key2);
        node2.neighbors.remove(key1);
    }

    public List<V> retrieveNeighbors(Integer key) {
        if(!nodeExists(key))
            return new ArrayList<>();

        ArrayList<V> neighborValues = new ArrayList<>();

        Node node = vertices.get(key);
        for (Integer neighborKey: node.neighbors ) {
            neighborValues.add(vertices.get(neighborKey).value);
        }
        return neighborValues;
    }

    public V getNodeValue(int key) {
        if(!nodeExists(key))
            return null;

        return vertices.get(key).value;
    }

    public boolean nodeExists(Integer key) {
        if(vertices.containsKey(key))
            return true;
        return false;
    }
}
