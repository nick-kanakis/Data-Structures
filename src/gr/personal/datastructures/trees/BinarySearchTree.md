# Binary Search Tree Theory


## Basic concepts

![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Binary_search_tree.svg/288px-Binary_search_tree.svg.png "BST")

Binary Search Tree, is a node-based binary tree data structure which has the following properties:

- The left subtree of a node contains only nodes with keys less than the node’s key.
- The right subtree of a node contains only nodes with keys greater than the node’s key.
- The left and right subtree each must also be a binary search tree.
- There must be no duplicate nodes.

## Time Complexity
**Average**

| Access | Search | Insert | Delete |
|:-------:|:-------:|:-------:|:-------:|
| O(logn) |O(logn)  | O(logn) | O(logn)  |

**Worst**

| Access | Search | Insert | Delete |
|:-------:|:-------:|:-------:|:-------:|
| O(n) | O(n) | O(n) | O(n) |

## Space Complexity (Doubly, Circular, Singly)
`O(n)`

## Operations
- `Value search(Key)`
- `void insert(Key, Valye)`
- `void preOrderTraversal()`
- `void inOrderTraversal()`
- `void postOrderTraversal()`

## Real Life Use

- Implementation of sorting algorithms
- User in many search application ()

