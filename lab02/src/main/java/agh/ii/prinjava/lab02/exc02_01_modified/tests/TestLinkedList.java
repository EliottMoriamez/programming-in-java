public class TestLinkedList {
    public static void main(String[] args) {
        StackOfInts s = new LinkedListBasedImpl();
        if (!s.isEmpty()) throw new AssertionError("Should be empty initially");
        s.push(1);
        s.push(2);
        s.push(3);
        if (s.pop() != 3) throw new AssertionError("Expected 3");
        if (s.pop() != 2) throw new AssertionError("Expected 2");
        if (s.pop() != 1) throw new AssertionError("Expected 1");
        if (!s.isEmpty()) throw new AssertionError("Should be empty at end");
        System.out.println("TestLinkedList: OK");
    }
}
