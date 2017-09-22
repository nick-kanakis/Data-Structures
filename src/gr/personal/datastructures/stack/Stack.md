# Stack Theory

## Basic concepts

![alt text](https://upload.wikimedia.org/wikipedia/commons/b/b4/Lifo_stack.png "Stack")

Stack is an abstract data type that serves as a collection of elements,
with two principal operations: push, which adds an element to the collection,
and pop, which removes the most recently added element that was not yet removed.
Stacks are knows also as **LIFO** queues.
Additionally, a peek operation may give access to the top without modifying the stack.

## Time Complexity
| Access | Search | Insert | Delete |
|:-------:|:-------:|:-------:|:-------:|
| O(n) | O(n) | O(1) | O(1) |

## Space Complexity
`O(n)`

## Operations
- `void push(Item)`
- `Item pop()`
- `Item peek()` can be done with a pop & push operation

## Real Life Use

- **Backtracking** (*Very important for interview puzzles that you have to keep track*).
Consider a simple example of finding the correct path in a maze.
There are a series of points, from the starting point to the destination.
We start from one point. To reach the final destination, there are several paths.
Suppose we choose a random path. After following a certain path,
we realise that the path we have chosen is wrong.
So we need to find a way by which we can return to the beginning of that path.
This can be done with the use of stacks. With the help of stacks,
we remember the point where we have reached.
This is done by pushing that point into the stack.
In case we end up on the wrong path,
we can pop the last point from the stack and thus return to the last point and continue our quest to find the right path.
This is called backtracking.

- A number of programming languages are stack-oriented,
meaning they define most basic operations (adding two numbers, printing a character) as taking their arguments from the stack,
and placing any return values back on the stack.
Many virtual machines are stack-oriented, including **Java Virtual Machine**.




