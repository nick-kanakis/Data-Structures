# Heap  Theory


## Basic concepts

![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/Max-Heap.svg/320px-Max-Heap.svg.png "Heap")

It’s a complete tree. All levels are completely filled except possibly the last level and the last level has all keys as left as possible.
This property of Binary Heap makes them suitable to be stored in an array.
A Binary Heap is either **Min Heap** or **Max Heap**.
In a Min Binary Heap, the key at root must be minimum among all keys present in heap. The same property must be recursively true for all nodes in Binary Tree.
Max Binary Heap is similar to Min Heap, but the root myst be the maximum among all keys present in the heap .

Binary heaps are good candidates to be stored in an array because the are complete binary trees and can be stored compactly.
Let n be the number of elements in the heap and i be an arbitrary valid index of the array storing the heap.
If the tree root is at index 0, with valid indices 0 through n − 1, then each element a at index i has:

- children at indices 2i + 1 and 2i + 2
- its parent at index floor((i − 1) ∕ 2). (`Floor(x)` = less than or equal to `x`)


## Time Complexity

For Binary Heap
**Worst**
| Search | Insert | Delete |
|:-------:|:-------:|:-------:|
| O(n) | O(logn) | O(logn) |


**Average**
| Search | Insert | Delete |
|:-------:|:-------:|:-------:|
| O(n) | O(1) | O(1) |


Since is not sorted, it might take the whole structure to search for a specific element.
Insert/delete in the worst case take O(logn) since you will need to fix the heap property, heapify.
Insert/Delete can be O(1) if the value added is less/greater than the parent depending if we have Max/Min heap.
(Parent >< Child) for the whole branch to the top.

## Space Complexity
`O(n)`

## Operations
- `void insert(Value)`
- `Value retrieve(Key)`
- `void delete(Key)`
- `Value findMax()`
- `Value extractMax()`
- `Value findMin()`
- `Value extractMin()`


### Basic Algorithm for operations:

**Insert**
1. Add the element to the bottom level of the heap.
2. Compare the added element with its parent; if they are in the correct order, stop.
3. If not, swap the element with its parent and return to the previous step.

**Extract Max element**

1. Replace the root of the heap with the last element on the last level.
2. Compare the new root with its children; if they are in the correct order, stop.
3. If not, swap the element with one of its children and return to the previous step. (Swap with its smaller child in a min-heap and its larger child in a max-heap.)


## Real Life Use

- *Heapsort*: One of the best sorting methods being in-place
- *Graph algorithms*: By using heaps as internal traversal data structures, run time will be reduced by polynomial order. Example of such problems is Dijkstra's shortest-path algorithm.
- *Priority Queue*: A priority queue is an abstract concept like "a list" or "a map"; just as a list can be implemented with a linked list or an array, a priority queue can be implemented with a heap.
