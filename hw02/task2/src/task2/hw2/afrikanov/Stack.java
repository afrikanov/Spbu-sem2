package task2.hw2.afrikanov;

/* Interface describes methods of a stack */
public interface Stack<Type> {

    /**
     * Method adds a value to the end of the stack
     * @param value - value, which should be added
     * @throws FullStackException if stack is full
     */
    void push(Type value) throws FullStackException;

    /**
     * Method removes the last value of the stack
     * @return the last element of stack, which will be deleted
     * @throws EmptyStackException if stack is empty
     */
    Type pop() throws EmptyStackException;

    /* @return the last element of stack */
    Type getTop();

    /* @return the amount of elements of the stack */
    int getSize();

    /* @return true if the stack is empty and false in other way */
    boolean isEmpty();
}
