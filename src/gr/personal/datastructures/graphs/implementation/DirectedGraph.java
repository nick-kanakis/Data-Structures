package gr.personal.datastructures.graphs.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nkanakis on 10/2/2017.
 */
public class DirectedGraph<V> {

    class Node{
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

    public void addNode(int key, V value){
        if(vertices.containsKey(key))
            return;
        Node newNode = new Node(key,value);
        vertices.put(key, newNode);
    }

    public void removeNode(int key){
        deleteAllReferencesOfNode(key);
        vertices.remove(key);
    }

    private void deleteAllReferencesOfNode(Integer key){
        for (Node node : vertices.values() ) {
            if(node.neighbors.contains(key))
                node.neighbors.remove(key);
        }
    }

    public void addEdge(int sourceKey, int destinationKey){
        Node sourceNode = vertices.get(sourceKey);

        if(sourceNode == null || !nodeExists(destinationKey))
            return;
        sourceNode.neighbors.add(destinationKey);
    }

    public void removeEdge(Integer sourceKey, Integer destinationKey){
        Node sourceNode = vertices.get(sourceKey);

        if(sourceNode == null || !nodeExists(destinationKey))
            return;
        sourceNode.neighbors.remove(destinationKey);
    }

    public List<V> retrieveNeighbors(int key){
        if(!nodeExists(key))
            return new ArrayList<>();

        Node node = vertices.get(key);
        List<V> neighbors = new ArrayList<>();

        for (int childrenKey : node.neighbors) {
            neighbors.add(vertices.get(childrenKey).value);
        }
        return neighbors;
    }

    public V getNodeValue(int key){
        if(!nodeExists(key))
            return null;
        Node node = vertices.get(key);
        return node.value;
    }

    public boolean nodeExists(int key){
        return vertices.containsKey(key);
    }
}
