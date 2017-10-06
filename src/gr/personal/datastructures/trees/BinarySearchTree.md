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

The worst O times are only with the tree has one branch (aka linked-list)

## Space Complexity
`O(n)`

## Operations
- `Value search(Key)`
- `void insert(Key, Valye)`
- `void delete(Key)`
- `void preOrderTraversal()`
- `void inOrderTraversal()`
- `void postOrderTraversal()`

Delete operation: (https://www.youtube.com/watch?v=x6At0nzX92o)

- When the node is leaf just delete it.

- When the node has one child delete the node and "move up" the child
of the deleted node.

- When the node has 2 children, go to the right sub-tree, and find the most
left leaf. Replace the node you want to delete with the leaf and delete the node
easily now that it is a leaf node.

- When the node has 2 children but the right sub-tree has no left nodes replace
the first right child of the node you want to delete with the soon to be delete node.
Delete that node. This is easy as the node has only one children.

## Real Life Use

- Implementation of sorting algorithms.
- User in many search application.

