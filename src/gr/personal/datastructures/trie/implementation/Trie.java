package gr.personal.datastructures.trie.implementation;

import java.util.HashMap;

/**
 * Created by Nicolas on 1/10/2017.
 *
 * Each node will have a hashMap and a boolean variable.
 * The hashMap will store a character as a key and a reference to that child node.
 * We do not use arrays because this will result in a lot of waste space, also we will not use linkedLists because
 * we want to have that association between the character and the next node.
 *
 */
public class Trie {

    class Node{
        HashMap<Character, Node> children = new HashMap<>();
        boolean isEndWord = false;
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    /*
    * Insert Algorithm
    *
    * Split the String into charArray.
    * Create temporary node (tempNode) value initialized with root;
    *
    * for(int i=0; i<size of charArray; i++)
    *
    *   if( tempNode contains charArray[i])
    *       tempNode = children.get(charArray[i])
    *       continue
    *   else
    *       insert to tempNode a reference to the new node as well as the character.
    *       tempNode = new Node that was just added.
    *
    * Mark the last node as it is containing a final char.
    *
    * */

    public void insert(String newWord){
        if(newWord==null)
            return;

        char[] characters = newWord.toCharArray();
        Node currentNode = root;

        for (char c: characters) {
            if(!currentNode.children.containsKey(c))
                currentNode.children.put(c,new Node());
            currentNode = currentNode.children.get(c);
        }
        currentNode.isEndWord = true;
    }


    public void deleteWord(String word) {
        if(word==null)
            return;

        char[] charArrayWord = word.toCharArray();


        deleteRecursively(root, charArrayWord, 0);
    }

    /*
   *  Delete Algorithm
   *
   * Boolean delete( currentNode, chars, index of chars)
   *
   * #When the end is reached#:
   *  If it has reach the end of the chars
   *    then check if it is a final world if not return false
   *    else
   *    mark it as not final world since we want to delete it
   *    Also if it has no children return true so it can be removed by the caller
   *
   * #Recursive part#:
   * If the char is not null recursively call the delete method again for the next node & next char
   *
   * #remove of node#:
   * If the result is true that means that you need to remove the node.
   *    remove the node from the children list
   *    check if the current node has no children, so it can be deleted by the recursive caller.
   * */
    private boolean deleteRecursively(Node currentNode, char[] charArrayWord, int indexInCharArray) {
        if (currentNode == null)
            return false;
        if (indexInCharArray == charArrayWord.length) {
            //when end of word is reached only delete if current.endOfWord is true.
            if (!currentNode.isEndWord) {
                return false;
            }
            currentNode.isEndWord = false;
            //if current has no other mapping then return true
            return currentNode.children.size() == 0;
        }
        char ch = charArrayWord[indexInCharArray];
        Node childNode = currentNode.children.get(ch);
        if (childNode == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = deleteRecursively(childNode, charArrayWord, indexInCharArray + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            currentNode.children.remove(ch);
            //return true if no mappings are left in the map.
            return currentNode.children.size() == 0;
        }
        return false;
    }


    public boolean searchPrefix(String prefix){
        if(prefix==null)
            return false;

        char[] charPrefix = prefix.toCharArray();
        Node currentNode = root;

        for (char c: charPrefix) {
            if(currentNode.children.containsKey(c))
                currentNode = currentNode.children.get(c);
            else
                return false;
        }
        return true;
    }

    public boolean searchWord(String word){
        if(word==null)
            return false;

        char[] chars = word.toCharArray();
        Node currentNode = root;

        for (int i = 0; i < chars.length; i++) {
            if(currentNode.children.containsKey(chars[i]))
                currentNode = currentNode.children.get(chars[i]);
            else
                return false;
        }
        if(currentNode.isEndWord)
            return true;
        return false;
    }
}
