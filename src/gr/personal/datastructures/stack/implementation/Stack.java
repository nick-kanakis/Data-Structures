package gr.personal.datastructures.stack.implementation;

/**
 * Created by Nicolas on 23/9/2017.
 *
 * Stack API
 * ----------------------------------------------
 *
 *  void    push(Item item)      	    // append an item at the top of the stack.
 *  Item    pop()                       // returns & removes the top element.
 *  int     peek()                      // returns only the top element.
 */
public interface Stack<Item>{

    public void push(Item item);
    public Item pop();
    public Item peek();
}
