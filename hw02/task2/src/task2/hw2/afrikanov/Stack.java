package task2.hw2.afrikanov;

/* Interfaces describes methods of a stack */
public interface Stack<Type> {

    /**
     * Method adds a value to the end of the stack
     * @param value - value, which should be added
     */
    void push(Type value) throws FullStackException;

    /* Method removes the last value of the stack */
    Type pop() throws EmptyStackException;

    /* @return the last element of stack */
    Type top();

    /* @return the amount of elements of the stack */
    int getSize();

    /* @return true if the stack is empty and false in other way */
    boolean isEmpty();
}
