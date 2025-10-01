/**
 * StackOfIntsFtry - simple factory for StackOfInts implementations.
 */
public class StackOfIntsFtry {
    /**
     * Creates a new LinkedListBasedImpl instance.
     *
     * @return a new LinkedListBasedImpl
     */
    public static StackOfInts createLinked() {
        return new LinkedListBasedImpl();
    }

    /**
     * Creates a new ArrayBasedImpl instance (default capacity).
     *
     * @return a new ArrayBasedImpl
     */
    public static StackOfInts createArray() {
        return new ArrayBasedImpl();
    }
}
