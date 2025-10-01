/**
 * StackOfInts - simple stack interface for integers.
 *
 * Provides basic stack operations: push, pop and isEmpty.
 */
public interface StackOfInts {
    /**
     * Pushes an integer value onto the top of the stack.
     *
     * @param value the integer value to push
     */
    void push(int value);

    /**
     * Removes and returns the integer value at the top of the stack.
     *
     * @return the integer value removed from the top of the stack
     * @throws java.util.NoSuchElementException if the stack is empty
     */
    int pop();

    /**
     * Checks whether the stack is empty.
     *
     * @return {@code true} if the stack contains no elements, {@code false} otherwise
     */
    boolean isEmpty();
}
