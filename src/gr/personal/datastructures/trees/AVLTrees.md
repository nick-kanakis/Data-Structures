# AVL Tree Theory


## Basic concepts

![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/AVL-tree-wBalance_K.svg/320px-AVL-tree-wBalance_K.svg.png "AVL trees")

AVL tree is a subtype of Binary Search trees that are also height-self-balanced.
In an AVL tree, the heights of the two child subtrees of any node differ by at most one; if at any time they differ by more than one.

Each node has a BalanceFactor:

`BalanceFactor(N) := Height(RightSubtree(N)) - Height(LeftSubtree(N))`

Where
`BalanceFactor(N) ∈ {–1,0,+1}`

And
`Height(N) = MAX(Height(N.leftChild), Height(N.rightChild)) + 1`

Balance factors can be kept up-to-date by knowing the previous balance factors and the change in height – it is not necessary to know the absolute height.

All operations are the same as BST except for insert/delete where the tree may have to re-balance itself. 
There are 2 types of rotations, Simple & Double rotation.

Let `z` be the first unbalanced node, `y` be the child of `z` that comes on the path from `w` (new inserted node) to `z` and
`x` be the grandchild of `z` that comes on the path from `w` to `z`.
Re-balance the tree by performing appropriate rotations on the subtree rooted with `z`. 
There can be 4 possible cases that needs to be handled as `x`, `y` and `z` can be arranged in 4 ways

**Simple Rotation**

`y` is left child of `z` and `x` is left child of `y` (**Left Left Case**)

T1, T2, T3 and T4 are subtrees.
 >          z                                      y 
 >         / \                                   /   \
 >        y   T4      Right Rotate (z)          x      z
 >       / \          - - - - - - - - ->      /  \    /  \ 
 >       x   T3                              T1  T2  T3  T4
 >      / \
 >     T1   T2

`y` is right child of `z` and `x` is right child of `y` (**Right Right Case**)


>         z                                y
>        /  \                            /   \ 
>       T1   y     Left Rotate(z)       z      x
>           /  \   - - - - - - - ->    / \    / \
>          T2   x                     T1  T2 T3  T4
>              / \
>            T3  T4

**Double Rotation**

`y` is left child of `z` and `x` is right child of `y` (**Left Right Case**)

>          z                               z                           x
>          / \                            /   \                        /  \ 
>        y   T4  Left Rotate (y)        x    T4  Right Rotate(z)    y      z
>       / \      - - - - - - - - ->    /  \      - - - - - - - ->  / \    / \
>      T1   x                          y    T3                    T1  T2 T3  T4
>          / \                        / \
>        T2   T3                    T1   T2


`y` is right child of `z` and `x` is left child of `y` (**Right Left Case**)

>          z                            z                            x
>         / \                          / \                          /  \ 
>       T1   y   Right Rotate (y)    T1   x      Left Rotate(z)   z      y
>           / \      - - - - - - ->     /  \   - - - - - - - ->  / \    / \
>          x   T4                      T2   y                  T1  T2  T3  T4
>         / \                              /  \
>       T2   T3                           T3   T4

## Time Complexity

Average and Worst is the same as this is a self balancing tree and
there is no possibility of creating a linked-list like tree (like BST). This means that average = worst time = height
aka log(n). The rotation operations take constant time.

| Access | Search | Insert | Delete |
|:-------:|:-------:|:-------:|:-------:|
| O(logn) | O(logn) | O(logn) | O(logn) |

## Space Complexity
`O(n)`

## Operations
- `Value search(Key)`
- `void insert(Key, Valye)`
- `void delete(Key)`
- `void preOrderTraversal()`
- `void inOrderTraversal()`
- `void postOrderTraversal()`

## Comparison with Red Black Tree

The AVL tree and other self balancing search trees like Red Black are useful to get all basic operations done in O(Log n) time. 
The AVL trees are more balanced compared to Red Black Trees, but they may cause more rotations during insertion and deletion. 
So if your application involves many frequent insertions and deletions, then Red Black trees should be preferred. 
And if the insertions and deletions are less frequent and search is more frequent operation, 
then AVL tree should be preferred over Red Black Tree.