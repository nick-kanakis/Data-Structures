# Linked List Theory

## Advantages

1. Dynamic size.
2. Ease of insertion/deletion.

## Disadvantages

1. Use more memory than arrays, because of the storage used by their pointers.
2. Random access is not allowed. We have to access elements sequentially starting from the first node. So we cannot do binary search with linked lists.

## Basic concepts

### Singly linked list.

Singly linked lists contain nodes which have a data field as well as a 'next' field, which points to the next node in line of nodes.
![alt text](https://upload.wikimedia.org/wikipedia/commons/6/6d/Singly-linked-list.svg "Singly linked list")

### Doubly linked list.

In a 'doubly linked list', each node contains, besides the next-node link, a second link field pointing to the 'previous' node in the sequence. 
This makes RemoveBack operation cheap O(1).

![alt text](https://upload.wikimedia.org/wikipedia/commons/5/5e/Doubly-linked-list.svg "Doubly linked list")

### Circular linked list.

In the last node of a list, the link field often contains a null reference, a special value used to indicate the lack of further nodes.
A less common convention is to make it point to the first node of the list; in that case the list is said to be 'circular' or 'circularly linked'

![alt text](https://upload.wikimedia.org/wikipedia/commons/d/df/Circularly-linked-list.svg "Circular linked list")

## Time Complexity (Doubly, Circular, Singly)
| Access | Search | Insert | Delete |
|:-------:|:-------:|:-------:|:-------:|
| O(n) | O(n) | O(1) | O(1) | 

## Space Complexity (Doubly, Circular, Singly)
`O(n)` 

## Operations
- `Value get(Index)`
- `int size()`
- `void add(Value)`
- `void add(Value, Index)`
- `void remove(Index)`
- `Boolean isEmpty()`



