# Linked List Theory

## Advantages

1. Linked lists are a dynamic data structure, which can grow and be pruned, allocating and deallocating memory while the program is running
2. There is no need to define an initial size for a linked list.

## Disadvantages

1. Use more memory than arrays, because of the storage used by their pointers.
2. Nodes are stored incontiguously, greatly increasing the time required to access individual elements within the list.
3. Nodes in a linked list must be read in order from the beginning as linked lists are inherently sequential access.

## Basic concepts

### Singly linked list.

Singly linked lists contain nodes which have a data field as well as a 'next' field, which points to the next node in line of nodes. 
Operations that can be performed on singly linked lists include insertion, deletion and traversal.

![alt text](https://upload.wikimedia.org/wikipedia/commons/6/6d/Singly-linked-list.svg "Singly linked list")

### Doubly linked list.

In a 'doubly linked list', each node contains, besides the next-node link, a second link field pointing to the 'previous' node in the sequence. 
The two links may be called 'forward('s') and 'backwards', or 'next' and 'prev'('previous').
This makes RemoveBack operation cheap O(1).

![alt text](https://upload.wikimedia.org/wikipedia/commons/5/5e/Doubly-linked-list.svg "Doubly linked list")

### Circular linked list.

In the last node of a list, the link field often contains a null reference, a special value used to indicate the lack of further nodes.
A less common convention is to make it point to the first node of the list; in that case the list is said to be 'circular' or 'circularly linked'; otherwise it is said to be 'open' or 'linear'.

![alt text](https://upload.wikimedia.org/wikipedia/commons/d/df/Circularly-linked-list.svg "Circular linked list")

## Time Complexity (Doubly, Circular, Singly)
| Access | Search | Insert | Delete |
|:-------:|:-------:|:-------:|:-------:|
| O(n) | O(n) | O(1) | O(1) | 

## Space Complexity (Doubly, Circular, Singly)
`O(n)` 

## Operations
- void AddFront(Key)
- Key GetFront() 
- void RemoveFront()
- void AddBack(Key)
- Key GetBack()
- void RemoveBack()
- Boolean Find(key)
- void Erase(Key)
- Boolean Empty(Key)
- void AddBefore(Node, Key)
- void AddAfter(Node, Key)



