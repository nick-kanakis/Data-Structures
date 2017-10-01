package gr.personal.datastructures.trie.implementation;

import java.util.HashMap;

/**
 * Created by Nicolas on 1/10/2017.
 *
 * Each node will have a hashMap and a boolean variable.
 * The hashMap will Store the a character as a key and a reference to that child node.
 * We do not use arrays because this will result in a lot of waste space, also w will not use linkedLists because
 * we want to have that association between the character and the next node.
 *
 */
public class Trie {

    class Node{
        HashMap<Character, Node> children = new HashMap<>();
        boolean isEndWord = false;
    }

    private Node root = new Node();


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
        Node tmpNode = null;

        for (int i = 0; i < characters.length; i++) {

            if(currentNode.children.containsKey(characters[i]))
                currentNode = currentNode.children.get(characters[i]);
            else{
                tmpNode =  new Node();
                currentNode.children.put(characters[i],tmpNode);
                currentNode = tmpNode;
            }
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
   *    If (index == size of word) {
   *        if currentNode is not end of the world
   *            return false
   *        else
   *            mark node as not final
   *            if current node has no children
   *                return true
   *            else
   *                retrun false
   *    }
   *    get currentNode's child based on chars index
   *    if (node == null)
   *        return false
   *    shouldDeleteCurrentNode  = recursively call delete(childNode, chars, index++)
   *
   *    if( shouldDeleteCurrentNode is true) {
   *        remove child from hashmap
   *        if no mappings are left in the map
   *            return true
   *        else
   *            return false
   *    }
   *    return false
   *
   * */
    private boolean deleteRecursively(Node currentNode, char[] charArrayWord, int indexInCharArray) {
        if (indexInCharArray == charArrayWord.length) {
            //when end of word is reached only delete if currrent.endOfWord is true.
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

        for (int i = 0; i < charPrefix.length; i++) {
            if(currentNode.children.containsKey(charPrefix[i]))
                currentNode = currentNode.children.get(charPrefix[i]);
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
