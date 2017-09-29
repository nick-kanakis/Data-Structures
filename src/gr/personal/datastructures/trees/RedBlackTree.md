# Red-Black Tree  Theory


## Basic concepts

![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Red-black_tree_example.svg/320px-Red-black_tree_example.svg.png "Red-Black tree")


1. Every node has a color either red or black.
2. Root of tree is always black.
3. A red node cannot have a red parent or red child.
4. Every path from root to a NULL node has same number of black nodes.



## Time Complexity

Average and Worst is the same as this is a self balancing tree and
there is no possibility of creating a linked-list like tree (like BST). This means that average = worst time = height
aka log(n). The rotation operations take constant time.

| Access | Search | Insert | Delete |
|:-------:|:-------:|:-------:|:-------:|
| O(logn) | O(logn) | O(logn) | O(logn) |

## Space Complexity (Doubly, Circular, Singly)
`O(n)`

## Operations
- `Value search(Key)`
- `void insert(Key, Valye)`
- `void delete(Key)`
- `void preOrderTraversal()`
- `void inOrderTraversal()`
- `void postOrderTraversal()`

**Insert Algorithm**

Let `x` be the newly inserted node.

1. Perform standard BST insertion and make the color of newly inserted nodes as RED.
2. If `x` is root, change color of `x` as BLACK (Black height of complete tree increases by 1).
3. Do following if color of `x`’s parent is RED or x is not root.
    1. If `x`’s uncle is RED
        1. Change color of parent and uncle as BLACK
        2. Color of grand parent as RED.
        3.Change `x` = `x`’s grandparent, repeat steps 2 and 3 for new `x`.
    2. If `x`’s uncle is BLACK, then there can be four configurations for `x`, `x`’s parent (**p**) and x’s grandparent (**g**)
        1. Left Left Case (**p** is left child of **g** and **x** is left child of **p**)
        2. Left Right Case (**p** is left child of **g** and **x** is right child of **p**)
        3. Right Right Case 
        4. Right Left Case 

## Real Life Use

Red–black trees offer worst-case guarantees for insertion time, deletion time, and search time. 
Not only does this make them valuable in time-sensitive applications such as real-time applications, 
but it makes them valuable building blocks in other data structures which provide worst-case guarantees; 
for example, many data structures used in computational geometry can be based on red–black trees,
and the Completely Fair Scheduler used in current Linux kernels uses red–black trees.

The AVL tree is another structure supporting O(log n) search, insertion, and removal. 
It is more rigidly balanced than red–black trees, leading to slower insertion and removal but faster retrieval. 
This makes it attractive for data structures that may be built once and loaded without reconstruction, 
such as language dictionaries (or program dictionaries, such as the opcodes of an assembler or interpreter).

## Advantages

1.



## Disadvantages

1.