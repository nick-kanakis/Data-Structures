package gr.personal.datastructures.trees;

/**
 * Created by Nicolas on 26/9/2017.
 */
public class BinarySearchTree<V> {

    public class Node{
        int key;
        V value;
        Node leftChild;
        Node rightChild;

        public Node(int key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    private Node root;

    public void insert(int key, V value){

        Node toBeInserted = new Node(key,value);

        if(root ==null)
            root = toBeInserted;
        else
            insertRecursively(root,toBeInserted);

    }

    private void insertRecursively(Node currentRoot, Node toBeInserted){

        if(currentRoot.key == toBeInserted.key)
            return;

        if(currentRoot.key < toBeInserted.key){

            if(currentRoot.leftChild == null)
                currentRoot.leftChild = toBeInserted;
            else
                insertRecursively(currentRoot.leftChild, toBeInserted);
        }
        else {

            if(currentRoot.rightChild == null)
                currentRoot.rightChild = toBeInserted;
            else
                insertRecursively(currentRoot.rightChild, toBeInserted);
        }
    }

    public V retrieve(int key){
         return retrieveRecursively(root, key);
    }

    private V retrieveRecursively(Node currentRoot, int key){
        if(currentRoot.key == key)
            return currentRoot.value;
        else if (currentRoot.key< key)
            retrieveRecursively(currentRoot.leftChild, key);
        else
            retrieveRecursively(currentRoot.rightChild, key);
        return null;
    }

    public void delete(int key){

    }



    public void printPreOrder(){}

    public void printInOrder(){}

    public void printPostOrder(){}




}
