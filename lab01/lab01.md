**First lab answers**

**1) Concepts of encapsulation, inheritance, and polymorphism**

1. *Encapsulation* : controlling by who data and functions can be accessed and modified, protecting the implementation
of a class
2. - *Mutator method* : a public function that sets the value of a private variable
   - *Accessor method* : a public function that returns the value of a private variable
3. - `this` returns the current instance of the class
   - `super` returns the properties of the parent class
4. *Inheritance* : deriving classes from already existing ones, extending their methods and properties
5. *Polymorphism* : using a child class instance as an instance of the parent class, making possible the grouping of
several different child instances in one array, or passing a child as a parent class in a function parameter
6. Classes must have a common parent class in order to be cast as the parent class, enabling polymorphism
7. *Reading of the article*
8. Writing some tests :
```java
class RectangleTest {
    Rectangle rec;

    @BeforeEach
    void setUp() {
        int w = 2, h = 3;

        rec = new Rectangle(w, h);
    }
    
    @Test
    void area() {
        assertEquals(6, rec.area());
    }

    @Test
    void perimeter() {
        assertEquals(10, rec.perimeter());
    }
}
```

## 2) Static members (variables/constants and methods)

1. - A *static variable* (defined with the keyword `static`) is shared between all instances of a class
   - A *static constant* (defined with the keyword `final`) can't be changed after initialization. When combined with
     `static`, the result is a constant shared among all instances of a class
   - A *static method* (defined with the keyword `static`) can be called without instancing an object, as it does not
   read nor modify any of `this` properties, and therefore will always give the same output for a defined input
2. *Static constants* are often `public` as they are hard written values that are given to leave the "magic number"
   from a class
3. As *static methods* are to be called without being instanced, they can't access the `this` keyword, nor any
   instance-specific property, and will return the same output for a static input
4. One example of a static method is the `Math.exp()` method, as it does not need a complete instance of the `Math`
   class to work, and `Math.exp(2)` will always return the same value

## 3) Constructors, factory methods, and singletons

1. *Object initialization process* :
   - Anonymous static block (only **once**, only static methods allowed) + constants initialization in the code's order
   - Anonymous block (each time)
   - Constructor
2. - Inheritance diagram of `D9`: B1 -> D1 -> D9
   - The parent's constructor will always be called first, thus the call will be `B1()`, `D1()`, `D9()`
3. *Constructors* must be called with the keyword `new`. *Factories* can return a subtype, make the code more readable,
   and are used to create specific instances of a class.
4. Two applications of the *singleton pattern* may be a websocket to a chat server, which can only be instantiated once,
   and window management, where an application has only one window that the program can refer to (to get the state)
5. Writing some tests
```java
class EagerSingletonTest {
    EagerSingleton s;

    @BeforeEach
    void setUp() {
        s = EagerSingleton.getInstance();
    }

    @Test
    void getInstance() {
        assert (s == EagerSingleton.getInstance());
    }
}

class LazySingletonTest {
    LazySingleton s;

    @BeforeEach
    void setUp() {
        s = LazySingleton.getInstance();
    }

    @Test
    void getInstance() {
        LazySingleton s2 = LazySingleton.getInstance();
        assert(s == s2);
    }
}
```

## 4) Immutable objects/classes and Java Records

1. A strategy to make an object immutable is to make the class `final`, and to control the access by setting only
   *getters* (and no *setter*)
2. An *immutable object* is an object whose internal state remains constant after it has been entirely created. An
   *immutable class* is a class whose instances have all the same, constant, state.
3. *Immutable objects* are thread-safe since they implement no concurrency.
4. *(From the World Wide Web)* Two usages for *Java Records* are Data Transfer Objects to carry immutable values across
   different layers of the application, and configuration settings, used to represent structured, immutable
   configuration objects.
5. Writing some tests:
```java
class HelloJavaRecordTest {
    HelloJavaRecord hjr;

    @BeforeEach
    void setHjr() {
        hjr = new HelloJavaRecord(1, "abc");
    }

    @Test
    void i1() {
        assertNotEquals(2, hjr.i1());
        assertEquals(1, hjr.i1());
    }

    @Test
    void s1() {
        assertEquals("abc", hjr.s1());
    }
}

class HelloImmutableTest {
    HelloImmutable hi1;
    HelloImmutable hi2;
    HelloImmutable hi3;

    @BeforeEach
    void setUp() {
        hi1 = new HelloImmutable(1, "abc");
        hi2 = new HelloImmutable(1, "abc");
        hi3 = new HelloImmutable(1, "bcd");
    }

    @Test
    void getI1() {
        assertEquals(1, hi1.getI1());
    }

    @Test
    void getS1() {
        assertEquals("abc", hi2.getS1());
    }

    @Test
    void testEquals() {
        assert(hi1.equals(hi2));
    }

    @Test
    void testHashCode() {
        assertNotEquals(hi1.hashCode(), hi3.hashCode());
    }
}
```

## 5) Overriding hashCode, equals, and toString

1. The `==` operators compares by reference, i.e. looking if both instances are stored at the same address in the
   memory, while the `equals` method compares by value, i.e. looking if all the fields have the same value.
2. The `hashCode` method returns a hash of the instance, so a number specific to the current state of the instance. If
   two instances have the same values, they are in the same state, thus they share the same hash (but it is not
   reciprocal!).
3. *(Reading of the Oracle Docs)*.
4. If two instances are proven equal using `equals`, they **must** share the same `hashCode`. Thus, `hashCode` stays
   consistent over the changes of the fields that are not comparated by `equals`. This implies that any `Override` of
   `equals` needs an override of `hashCode` to maintain this contract. Notes :
   - Collisions of `hashCode` may appear, i.e. two different instances may share the same `hashCode`
   - `equals` follows the principles of the mathematical binary equivalence relation.
5. `"javadoc" finished with exit code 1` :(