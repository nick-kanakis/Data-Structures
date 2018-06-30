# Trie Theory Theory

## Basic concepts

![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Trie_example.svg/256px-Trie_example.svg.png "Trie")

Trie is a kind of search tree—an ordered tree data structure that is used to store a dynamic set
or associative array where the keys are usually strings. All the descendants of a node have a common prefix of the string associated with that node,
and the root is associated with the empty string.
Simply every node of Trie consists of multiple branches. Each branch represents a possible character of keys.
We need to mark the last node of every key as end of word node

In the example shown, keys are listed in the nodes and values below them. Each complete English word has an arbitrary integer value associated with it.

## Time Complexity
| Access | Search | Insert | Delete |
|:-------:|:-------:|:-------:|:-------:|
| O(M) | O(M) | O(M) | O(M) |

Where `M` is the maximum world length

## Space Complexity
Let `w` be the amount of words in the trie and
`m` is the average word length. Then the boundary is `O(Alphabet_size*w*m)`
since it simply represents the max amount of characters in the trie, which is obviously also it's space boundary.

`O(Alphabet_size*w*m)`

## Operations
- `void insert(Char)`
- `void delete(List<Char>)`
- `void prefixExist(List<Char>)`
- `void wordExist(List<Char>)`


## Real Life Use

- Replacement for other data structures, A trie can also be used to replace a hash table, over which it has the following advantages:
    - Looking up data in a trie is faster in the worst case.
    - There are no collisions of different keys in a trie.
    - There is no need to provide a hash function or to change hash functions as more keys are added to a trie.
- Autocomplete / Dictionary.
- Spell check
- Longest prefix mach, is an algorithm used by routers in Internet Protocol networking to select
an entry from a forward table
