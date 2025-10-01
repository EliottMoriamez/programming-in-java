import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * ArrayBasedImpl - a resizable array-based implementation of StackOfInts.
 *
 * The internal array doubles when full and halves when quarter-full,
 * providing amortized O(1) push and pop.
 */
public class ArrayBasedImpl implements StackOfInts {
    private int[] data;
    private int size;

    /**
     * Creates an ArrayBasedImpl with default initial capacity.
     */
    public ArrayBasedImpl() {
        this(8);
    }

    /**
     * Creates an ArrayBasedImpl with the specified initial capacity.
     *
     * @param initialCapacity initial capacity (must be >= 1)
     */
    public ArrayBasedImpl(int initialCapacity) {
        if (initialCapacity < 1) initialCapacity = 1;
        data = new int[initialCapacity];
        size = 0;
    }

    /**
     * Pushes a value onto the stack.
     *
     * @param value the value to push
     */
    @Override
    public void push(int value) {
        if (size == data.length) {
            // grow (double)
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size++] = value;
    }

    /**
     * Pops and returns the top value.
     *
     * @return the popped integer
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public int pop() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        int val = data[--size];
        // shrink when 1/4 full to avoid loitering
        if (size > 0 && size == data.length / 4) {
            int newCap = Math.max(1, data.length / 2);
            data = Arrays.copyOf(data, newCap);
        }
        return val;
    }

    /**
     * Returns true if the stack is empty.
     *
     * @return true if empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * For testing and debugging: current size of the stack.
     *
     * @return number of elements in the stack
     */
    public int size() {
        return size;
    }

    /**
     * For testing: current capacity of internal array.
     *
     * @return current capacity
     */
    public int capacity() {
        return data.length;
    }
}
