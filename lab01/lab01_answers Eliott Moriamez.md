**1)Concept of encapsulation, inheritance and polymorphism**

1. Encapsulation allows to create a new type, personalized with new methods
2. a) A setter allows the user to set the value of a parameter in a class\
b) A getter allows the user to get that value which\
We need those because most of the time these values are private and only available from a method in the class to "protect them" and avoid problems.
3. when you implement a method you may use parameters that have the same name as the class attribute, *this* allows to specify that you talk about the attribute and not the parameter\
*super* allows to get the same attributes as the father class when you create an inherited class
4. *inheritance* is the action to create a new class which is an extension from another class, this will act like the father class but you can implement more specific methods
5. *polymorphism* is when classes that inherit from the same class have methods that have the same name but unique to each of them 
there is the inheritance has explained in 4 and 5 where we extend a parent class, the interface where the parent class isn't defined with a lot of methods but that warns that the class that implement that interface need to have certain specific methods, finally there is the overloading polymorphism where we write different methods with the same name but with different parameters, allowing to prevent different type of answers for instance.
6. Classes must have a common parent class in order to be cast as the parent class, enabling polymorphism
7. reading
8. 
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


**2) Static members**

1. Static Variable is a variable accessible to all instances of a class. A static constant is a fixed static variable that cannot change. And a static method is a method in a class that can only access to its class variables.
2. A static constant cannot be change so it's not necessary to make a setter because there is less risk of causing problems by changing it by mistake
3. As static methods are to be called without being instanced, they can't access the *this* keyword, nor any instance-specific property, and will return the same output for a static input
4. It could be a method like static void displayScore(){System.out.println(score);} with score being a static variable for instance.

**3) Constructors, factory methods and singletons**

1. Object initialization process: anonymous static block constants initialization in the code's order, anonymous block (each time),then the constructor
2. Inheritance diagram of D9: B1 -> D1 -> D9\
The parent's constructor will always be called first, thus the call will be B1(), D1(), D9()
3. Constructors must be called with the keyword *new*. Factories can return a subtype, make the code more readable, and are used to create specific instances of a class.
4. Two applications of the *singleton pattern* may be a websocket to a chat server, which can only be instantiated once, and window management, where an application has only one window that the program can refer to (to get the state)
5. 
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

**4) Immutable objects/classes and Java Records**

1. The strategy is tu put "private" in front of tje definition of the variable
2. An immutable object is a specific instance that won't change while an immutable class is a class whom every instance will be constant.
3. It's useful to set constants in a class that could be easily accessible to all its instances or instances of extended classes without being able to modify it to avoid problems.
4. Java records can be useful to manipulate immutable data structures because they make it easy to use and call etc...
5. 
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

\
**5) Overriding hashCode, equals and toString**
1. The *==* operators compares by reference, i.e. looking if both instances are stored at the same address in the memory, while the *equals* method compares by value, i.e. looking if all the fields have the same value.
2. The *hashCode* method returns a hash of the instance, so a number specific to the current state of the instance. If two instances have the same values, they are in the same state, thus they share the same hash (but it is not reciprocal!).
3. reading
4. If two instances are proven equal using equals, they must share the same hashCode. Thus, hashCode stays consistent over the changes of the fields that are not comparated by equals. This implies that any Override of equals needs an override of hashCode to maintain this contract.
