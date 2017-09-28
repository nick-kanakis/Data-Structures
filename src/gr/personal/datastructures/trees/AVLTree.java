package gr.personal.datastructures.trees;

/**
 * Created by nkanakis on 9/28/2017.
 */
public class AVLTree<V>{

    private class Node{
        int key, height;
        V value;
        Node leftChild;
        Node rightChild;

        public Node(int key, V value) {
            this.key = key;
            this.value = value;
            height = 1;
        }
    }

    private Node root;

    private Node rotateRight(Node originalRoot){
        //Perform rotation
        Node newRoot = originalRoot.leftChild;
        originalRoot.leftChild = newRoot.rightChild;
        newRoot.rightChild = originalRoot;

        newRoot.height = max(height(newRoot.leftChild), height(newRoot.rightChild)) + 1;
        originalRoot.height = max(height(originalRoot.leftChild), height(originalRoot.rightChild)) + 1;

        return newRoot;
    }

    private Node rotateLeft(Node originalRoot){
        Node newRoot = originalRoot.rightChild;
        originalRoot.rightChild = newRoot.leftChild;
        newRoot.leftChild = originalRoot;

        newRoot.height = max(height(newRoot.leftChild), height(newRoot.rightChild)) + 1;
        originalRoot.height = max(height(originalRoot.leftChild), height(originalRoot.rightChild)) + 1;

        return newRoot;
    }

    // A utility function to get maximum of two integers
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private int height(Node node) {
        if (node == null)
            return 0;

        return node.height;
    }

    private int getBalanceFactor(Node node){
        if (node == null)
            return 0;
        return height(node.leftChild) - height(node.rightChild);
    }

    public void insert(int key, V value){
        Node newNode = new Node(key,value);
        root = insertRecursively(root,newNode);
    }

//todo: study it
    private Node insertRecursively(Node currentRoot, Node newNode) {

        /* 1.  Perform the normal BST insertion */
        if (currentRoot == null)
            return newNode;

        if (newNode.key < currentRoot.key)
            currentRoot.leftChild = insertRecursively(currentRoot.leftChild, newNode);
        else if (newNode.key > currentRoot.key)
            currentRoot.rightChild = insertRecursively(currentRoot.rightChild, newNode);
        else // Duplicate keys not allowed
            return currentRoot;

        /* 2. Update height of this ancestor node */
        currentRoot.height = 1 + max(height(currentRoot.leftChild),
                height(currentRoot.rightChild));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balanceFactor = getBalanceFactor(currentRoot);

        //If left unbalanced (balancing factor > 1) && the new node has been inserted on the left
        //Do a LEFT LEFT rotation
        if(balanceFactor > 1 && newNode.key < currentRoot.leftChild.key)
            return rotateRight(currentRoot);

        //If right unbalanced (balancing factor < -1) && the new node has been inserted on the right
        //Do a RIGHT RIGHT rotation
        if(balanceFactor < -1 && newNode.key > currentRoot.rightChild.key)
            return rotateLeft(currentRoot);

        //If left unbalanced (balancing factor > 1) && the new node has been inserted on the right
        //Do a LEFT RIGHT rotation
        if(balanceFactor > 1 && newNode.key > currentRoot.leftChild.key){
            currentRoot.leftChild = rotateLeft(currentRoot.leftChild);
            return rotateRight(currentRoot);
        }

        //If right unbalanced (balancing factor <-1) && the new node has been inserted on the left
        //Do a RIGHT LEFT rotation
        if(balanceFactor < -1 && newNode.key < currentRoot.rightChild.key){
            currentRoot.rightChild = rotateRight(currentRoot.rightChild);
            return rotateLeft(currentRoot);
        }

        /* return the (unchanged) node pointer */
        return currentRoot;
    }

    public void preOrder(){
        preOrderRecursively(root);
    }

    private void preOrderRecursively(Node root) {
        if(root != null){
            System.out.print(root.key+",");
            preOrderRecursively(root.leftChild);
            preOrderRecursively(root.rightChild);
        }
    }
}
