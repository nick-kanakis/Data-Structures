# Graphs Theory


## Basic concepts

![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Directed.svg/250px-Directed.svg.png "graphs")

A graph data structure consists of a finite (and possibly mutable) set of vertices or nodes or points,
together with a set of unordered pairs of these vertices for an undirected graph or a set of ordered pairs for a directed graph.
These pairs are known as edges for an undirected graph and as directed edges for a directed graph. 

A graph data structure may also associate to each edge some edge value, 
such as a symbolic label or a numeric attribute (cost, capacity, length, etc.).




## Time Complexity

If `V` the number of vertices and `E` the number of edges

| Add Node | Add edge | Remove node | Remove edge |
|:-------:|:-------:|:-------:|:-------:|
| O(1) | O(1) | O(E) | O(V) |

## Space Complexity
`O(V+E)`

## Operations

- `void addNode(Key, Value)`
- `void removeNode(Key)`
- `void addEdge(NodeKey1, NodeKey2)`
- `void removeEdge(NodeKey1, NodeKey2)`
- `List<Key> neighbors(Key)` 
- `Value getNodeValue(Key)` 
- `void updateNodeValue(Key, Value)` 

If it is a weighted graph :
Replace addEdge with:

- `void addEdge(NodeKey1, NodeKey2, Weight)`

Add:

- `Weight getEdgeWeight(NodeKey1, NodeKey2)` 
- `void updateEdgeWeight(NodeKey1, NodeKey2, Weight)` 
