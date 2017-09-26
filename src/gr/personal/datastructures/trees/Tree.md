# Tree  Theory

## Basic concepts

![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Binary_tree.svg/288px-Binary_tree.svg.png "title")

A tree data structure can be defined recursively (locally) as a collection of nodes (starting at a root node),
where each node is a data structure consisting of a value, together with a list of references to nodes (the "children"),
with the constraints that no reference is duplicated, and none points to the root.
Alternatively, a tree can be defined abstractly as a whole (globally) as an ordered tree, with a value assigned to each node.

For a graph to be a tree it must follow some rules:
1. There must not be a cycle withing the graph
2. Each node should have only one father
3. All nodes must be connected

### Terminology
1. **Degree** The number of sub trees of a node.
2. **Edge** The connection between one node and another.
3. **Path** A sequence of nodes and edges connecting a node with a descendant
4. **Level** The level of a node is defined by 1 + (the number of connections between the node and the root).
5. **Height of node** The height of a node is the number of edges on the longest path between that node and a leaf
6. **Depth** The depth of a node is the number of edges from the tree's root node to the node.

### Traversal
1. **pre-order**, a walk in which each parent node is traversed(=printed/computed etc) before its children (Depth first).
2. **post-order**, a walk in which the children are traversed before their respective parents are traversed (Depth first).
3. **in-order**, a walk in which a node's left subtree, then the node itself, and finally its right subtree are traversed (Depth first).
4. **level-order**, effectively performs a breadth-first search over the entirety of a tree; nodes are traversed level by level (Breadth first).

### Why trees?

- Trees (with some ordering e.g., BST) provide moderate access/search (quicker than Linked List and slower than arrays).
- Trees provide moderate insertion/deletion (quicker than Arrays and slower than Unordered Linked Lists).
- One reason to use trees might be because you want to store information that naturally forms a hierarchy

## Real Life Use

- Representing hierarchical data
- Storing data in a way that makes it efficiently searchable
- Representing sorted lists of data
- Routing algorithms