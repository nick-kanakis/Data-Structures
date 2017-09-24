# Hash table Theory

## Basic concepts

A hash table (hash map) is a structure that can map keys to values.
A hash table uses a **hash function** to compute an index into an array of buckets or slots, from which the desired value can be found.

## Collision Handling

Since a hash function gets us a small number for a big key, there is possibility that two keys result in same value.
This situation is called collision. Following are the ways to handle collisions:

### Chaining

The idea is to make each cell of hash table point to a linked list of records that have same hash function value.
Chaining is simple, but requires additional memory outside the table.

**Advantages**

1. Simple to implement
2. Hash table never fills up.
3. Less sensitive to the hash function or load factors.
4. Mostly used when it is unknown how many and how frequently keys may be inserted or deleted

**Disadvantages**

1. Wastage of Space
2. If the chain becomes long, then search time can become O(n) in worst case.
3. Uses extra space for links
4. Cache performance of chaining is not good as keys are stored using linked list.
Open addressing provides better cache performance as everything is stored in same table


### Open Addressing

In open addressing, all elements are stored in the hash table itself.
Each table entry contains either a record, NIL, or a deprecated recorded marked as "deleted".
When searching for an element, we one by one examine table slots until the desired element is found
or it is clear that the element is not in the table

*Insert(k)*: Keep probing until an empty slot is found.
Once an empty slot is found, insert k.

*Search(k)*: Keep probing until slot’s key doesn’t become equal to k or an empty slot is reached.

*Delete(k)*: If we simply delete a key, then search may fail. So slots of deleted keys are marked specially as “deleted”.
Insert can insert an item in a deleted slot, but search doesn’t stop at a deleted slot.

**Probing Types**

- *Linear Probing* : In linear probing, we linearly probe for next slot. (hash(x)+i) % S.
The main problem with linear probing is clustering, many consecutive elements form groups and it starts taking time to find a free slot or to search an element.

- *Quadratic Probing* :  We look for i2‘th slot in i’th iteration (hash(x)+i\*i) .

> let hash(x) be the slot index computed using hash function.

> If slot hash(x) % S is full, then we try (hash(x) + 1\*1) % S

> If (hash(x) + 1\*1) % S is also full, then we try (hash(x) + 2\*2) % S

> If (hash(x) + 2\*2) % S is also full, then we try (hash(x) + 3\*3) % S

- *Double Hashing* We use another hash function hash2(x) and look for i\*hash2(x) slot in i’th rotation.

**Advantages & Disadvantages**

The opposite of Chaining.

**What probing solution to choose**

*Linear probing* has the best cache performance, but suffers from clustering.
One more advantage of Linear probing is easy to compute.

*Quadratic probing* lies between the two in terms of cache performance and clustering.

*Double hashing* has poor cache performance but no clustering. Double hashing requires more computation time as two hash functions need to be computed.

### Hash Function

## Time Complexity

**Average**

| Access | Search | Insert | Delete |
|:-------:|:-------:|:-------:|:-------:|
| O(1) | O(1) | O(1) | O(1) |

**Worst**

| Access | Search | Insert | Delete |
|:-------:|:-------:|:-------:|:-------:|
| O(n) | O(n) | O(n) | O(n) |


## Space Complexity
`O(n)`

## Operations
- `void add(Key, Value)`
- `void delete(Key)`
- `Value retrieve(Key)`


## Advantages

- The main advantage of hash tables over other table data structures is speed,
This advantage is more apparent when the number of entries is large.
Hash tables are particularly efficient when the maximum number of entries can be predicted in advance,
so that the bucket array can be allocated once with the optimum size and never resized.


## Disadvantages

- Although operations on a hash table take constant time on average,
the cost of a good hash function can be significantly higher than the inner loop of the lookup algorithm for a sequential list or search tree.
Thus hash tables are not effective when the number of entries is very small.

## Real Life Use

Many times hash tables turn out to be more efficient than search trees or any other table lookup structure.
For this reason, they are widely used in many kinds of computer software, particularly for associative arrays,
database indexing, caches, and sets.
