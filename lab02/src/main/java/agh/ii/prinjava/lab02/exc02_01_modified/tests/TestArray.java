public class TestArray {
    public static void main(String[] args) {
        ArrayBasedImpl s = new ArrayBasedImpl(2);
        if (!s.isEmpty()) throw new AssertionError("Should be empty initially");
        s.push(10); s.push(20); s.push(30);
        if (s.capacity() < 3) throw new AssertionError("Capacity should have grown");
        if (s.pop() != 30) throw new AssertionError("Expected 30");
        if (s.pop() != 20) throw new AssertionError("Expected 20");
        if (s.pop() != 10) throw new AssertionError("Expected 10");
        if (!s.isEmpty()) throw new AssertionError("Should be empty at end");
        System.out.println("TestArray: OK");
    }
}
