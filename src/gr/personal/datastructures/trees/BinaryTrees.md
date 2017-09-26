# Binary Trees Theory

## Basic concepts

![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Binary_tree.svg/288px-Binary_tree.svg.png "Binary tree")

Binary tree is a tree data structure in which each node has at most two children, 
which are referred to as the left child and the right child

### Types

- A **full binary tree** is a tree in which every node in the tree has either 0 or 2 children.
- A **perfect binary tree** is a binary tree in which all interior nodes have two children and
 all leaves have the same depth or same level
- In a **complete binary tree** every level is complete, except possibly the last,
 and all nodes in the last level are as far left as possible 

- A **balanced binary tree** 2 subtrees can only differ in height by 1. The height must be O(Log n) where
n is the number of nodes. Balanced Binary Search trees are performance wise good as they provide O(log n) time for search,
insert and delete.


## Specializations of Binary trees

- **Binary Search Tree** - Used in many search applications where data is constantly entering/leaving, 
such as the map and set objects in many languages' libraries
- **Binary Tries** - Used in almost every high-bandwidth router for storing router-tables.
- **Heaps** - Used in implementing efficient priority-queues, which in turn are used for scheduling processes in many operating systems.