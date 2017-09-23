# Queue Theory

## Basic concepts

![alt text](https://upload.wikimedia.org/wikipedia/commons/5/52/Data_Queue.svg "Queue")

The entities in queues are kept in order and the only operations on the collection are the addition of entities to the rear terminal position,
known as **enqueue**, and removal of entities from the front terminal position, known as **dequeue**.
This makes the queue a FIFO data structure.

Theoretically, a queue does not have a specific capacity.
Regardless of how many elements are already contained, a new element can always be added,
However there is a special type of queue, **Bounded queues**, that are limited to a fix number of items

## Time Complexity (Doubly, Circular, Singly)
| Access | Search | Insert | Delete |
|:-------:|:-------:|:-------:|:-------:|
| O(n) | O(n) | O(1) | O(1) |

## Space Complexity (Doubly, Circular, Singly)
`O(n)`

## Operations
- `void enqueue(Item)`
- `Item dequeue()`
- `Item peek()`

## Real Life Use

- The can be used as a *Buffer*
- Queue is also used by Operating systems for job scheduling.