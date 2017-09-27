# AVL Tree Theory


## Basic concepts

![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/AVL-tree-wBalance_K.svg/320px-AVL-tree-wBalance_K.svg.png "AVL trees")

AVL tree is a subtype of Binary Search trees that are also height-self-balanced.
In an AVL tree, the heights of the two child subtrees of any node differ by at most one; if at any time they differ by more than one.

Each node has a BalanceFactor:
BalanceFactor(N) := Height(RightSubtree(N)) - Height(LeftSubtree(N))
Where
BalanceFactor(N) ∈ {–1,0,+1}

Balance factors can be kept up-to-date by knowing the previous balance factors and the change in height – it is not necessary to know the absolute height.

All operations are the same as BST except for insert/delete where the tree may have to re-balance. There are 2 types of rotations:

**Simple Rotation**

**Double Rotation**

## Time Complexity

Average and Worst is the same as this is a self balancing tree and
there is no possibility of creating a linked-list like tree (like BST)

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

## Real Life Use

-

## Advantages

1.


## Disadvantages

1.