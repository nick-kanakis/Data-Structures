package gr.personal.datastructures.trees;

/**
 * Created by Nicolas on 26/9/2017.
 */
public class BinarySearchTree<V> {

    public class Node {
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

    public void insert(int key, V value) {

        Node toBeInserted = new Node(key, value);

        if (root == null)
            root = toBeInserted;
        else
            insertRecursively(root, toBeInserted);

    }

    private void insertRecursively(Node currentRoot, Node toBeInserted) {

        if (currentRoot.key == toBeInserted.key)
            return;

        if (toBeInserted.key < currentRoot.key) {

            if (currentRoot.leftChild == null)
                currentRoot.leftChild = toBeInserted;
            else
                insertRecursively(currentRoot.leftChild, toBeInserted);
        } else {

            if (currentRoot.rightChild == null)
                currentRoot.rightChild = toBeInserted;
            else
                insertRecursively(currentRoot.rightChild, toBeInserted);
        }
    }

    public V retrieve(int key) {
        return retrieveRecursively(root, key);
    }

    private V retrieveRecursively(Node currentRoot, int key) {
        if (currentRoot == null)
            return null;

        if (currentRoot.key == key)
            return currentRoot.value;
        else if (key < currentRoot.key)
            return retrieveRecursively(currentRoot.leftChild, key);
        else
            return retrieveRecursively(currentRoot.rightChild, key);
    }

    public void delete(int key) {

        if (root == null)
            return;

        Node parentOfToBeDeletedNode = null;
        Node toBeDeletedNode = null;
        boolean isLeftChild = false;
        if (root.key == key)
            parentOfToBeDeletedNode = root;
        else
            parentOfToBeDeletedNode = findParentOfToBeDeletedNode(root, key);

        //if parentNode is still null that means that there is no node with given key
        if (parentOfToBeDeletedNode == null)
            return;

        if (key < parentOfToBeDeletedNode.key) {
            isLeftChild = true;
            toBeDeletedNode = parentOfToBeDeletedNode.leftChild;
        } else {
            isLeftChild = false;
            toBeDeletedNode = parentOfToBeDeletedNode.rightChild;
        }
        removeNode(parentOfToBeDeletedNode, toBeDeletedNode, isLeftChild);
    }

    /*
    * Find the parent of the node to be deleted by probing the left/right children of each node recursively.
    * */
    private Node findParentOfToBeDeletedNode(Node currentRoot, int key) {
        if (key < currentRoot.key && currentRoot.leftChild != null) {
            if (currentRoot.leftChild.key != key)
                return findParentOfToBeDeletedNode(currentRoot.leftChild, key);
            else
                return currentRoot;
        } else if (key > currentRoot.key && currentRoot.rightChild != null) {
            if (currentRoot.rightChild.key != key)
                return findParentOfToBeDeletedNode(currentRoot.rightChild, key);
            else
                return currentRoot;
        }
        return null;
    }

    private void removeNode(Node parentOfToBeDeletedNode, Node toBeDeletedNode, boolean isLeftChild) {

        //Case 1: Delete Node is leaf
        if (toBeDeletedNode.rightChild == null && toBeDeletedNode.leftChild == null) {
            if (isLeftChild)
                parentOfToBeDeletedNode.leftChild = null;
            else
                parentOfToBeDeletedNode.rightChild = null;

        }
        //Case 2: Delete Node has only one child
        else if (toBeDeletedNode.rightChild == null || toBeDeletedNode.leftChild == null) {
            //Right child of deleted node is the only not null child
            if (toBeDeletedNode.rightChild != null) {
                if (isLeftChild)
                    parentOfToBeDeletedNode.leftChild = toBeDeletedNode.rightChild;
                else
                    parentOfToBeDeletedNode.rightChild = toBeDeletedNode.rightChild;
            }
            //Left child of deleted node is the only not null child
            else {
                if (isLeftChild)
                    parentOfToBeDeletedNode.leftChild = toBeDeletedNode.leftChild;
                else
                    parentOfToBeDeletedNode.rightChild = toBeDeletedNode.leftChild;
            }

        }
        //Case 3: Delete Node has 2 children
        else {
            Node rootOfRightSubtree = toBeDeletedNode.rightChild;
            //Case 3.a: There is NO left most element in RIGHT subtree of the deleted node.
            if (rootOfRightSubtree.leftChild == null) {
                toBeDeletedNode.value = rootOfRightSubtree.value;
                toBeDeletedNode.key = rootOfRightSubtree.key;
                if (isLeftChild) {
                    toBeDeletedNode.leftChild = rootOfRightSubtree.rightChild;
                } else {
                    toBeDeletedNode.rightChild = rootOfRightSubtree.rightChild;
                }
            }
            //Case 3.b: There is a left most element in RIGHT subtree of the deleted node.
            else {
                Node minimumLeafNode = retrieveMinimumValue(rootOfRightSubtree);
                deleteMinimumNode(rootOfRightSubtree);
                toBeDeletedNode.key = minimumLeafNode.key;
                toBeDeletedNode.value = minimumLeafNode.value;
            }
        }
    }
    //todo: ??
    private Node retrieveMinimumValue(Node currentRoot) {
        if (currentRoot == null)  // this check will never be encountered.
            return null;
        if (currentRoot.leftChild != null)
            return retrieveMinimumValue(currentRoot.leftChild);
        else
            return currentRoot;
    }
    //todo: ??
    private Node deleteMinimumNode(Node currentRoot) {
        if (currentRoot == null)
            return null;
        if (currentRoot.leftChild == null)
            return currentRoot.rightChild;

        currentRoot.leftChild = deleteMinimumNode(currentRoot.leftChild);
        return currentRoot;
    }


    public void printPreOrder() {
        printPreOrderRecursively(root);
    }

    private void printPreOrderRecursively(Node currentRoot) {
        if (currentRoot != null)
            System.out.print(currentRoot.value + ",");

        if (currentRoot.leftChild != null)
            printPreOrderRecursively(currentRoot.leftChild);
        if (currentRoot.rightChild != null)
            printPreOrderRecursively(currentRoot.rightChild);
    }

    public void printInOrder() {
        printInOrderRecursively(root);
    }

    private void printInOrderRecursively(Node currentRoot) {
        if (currentRoot.leftChild != null)
            printInOrderRecursively(currentRoot.leftChild);
        System.out.print(currentRoot.value + ",");
        if (currentRoot.rightChild != null)
            printInOrderRecursively(currentRoot.rightChild);
    }

    public void printPostOrder() {
        printPostOrderRecursively(root);
    }

    private void printPostOrderRecursively(Node currentRoot) {
        if (currentRoot.leftChild != null)
            printPostOrderRecursively(currentRoot.leftChild);
        if (currentRoot.rightChild != null)
            printPostOrderRecursively(currentRoot.rightChild);
        if (currentRoot != null)
            System.out.print(currentRoot.value + ",");
    }
}
