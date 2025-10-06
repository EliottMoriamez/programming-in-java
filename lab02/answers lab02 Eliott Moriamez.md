**Java - elements of OOP (II)**

**1) Final variables, methods, and classes**
1. Reading
2. Using constants can make the code more readable (bn: constant for PI) and make it easy to modify a code by only needing to modify a value at one place instead of in multiple functions, moreover it's safe beacause it prevents to accidentally modify it somewhere and breaking the code somewhere else.
3. Meaning of final variable: 
- local variable: once initialized, value cannot be reassigned
- instance variable: must be initialized at the declaration of any instance
- static constants: shared accross all instances
- methods: prevents overriding in subclasses
- classes: prevents the class to be subclassed
4. First one: not always if fields are references to mutable objects. Second: Yes because we cannot modify primitive fields externally.
5. The getter gives the reference so we can use it to modify it externally.

**2)Enumeration classes (enums)**
3. Yes it is correct and thread safe

**3)Nested classes**
2. Main differences:
- Static nested class does not need an instance of the enclosing class.
- Inner class requires an instance of the enclosing class.
- Local class has method-local scope.
- Anonymous class is concise but limited (cannot declare constructors, only one instance).
3. Yes, but you need an instance of the enclosing class.\
Yes, all are allowed depending on visibility needs.

**4)Abstract Data Types**
2) **Abstract classes**: Can have constructors, fields, implemented methods, and abstract methods. Only single inheritance allowed.\
**Interfaces**: Cannot have constructors, all fields are implicitly *public static final*, methods are abstract by default. A class can implement multiple interfaces.
3) The possible types are: 
- Constants
- Abstract methods
- Default methods 
- Static methods 
- Private methods 
4) It's ```abstract class E { abstract void m1(); }```
5) It's ```interface D { void m1(); }```
6) Output will be `b is an instance of A` and `b is an instance of C`
\
because B implements A and B extends D which extends C

**5)Functional interfaces and lambda expressions**
2) A functional interface has exactly one abstract method while a lambda expression provides a clean way to implement that single method inline.
3) 
```java
@FunctionalInterface
interface VoidToInt { int apply(); }

@FunctionalInterface
interface IntToVoid { void apply(int x); }

@FunctionalInterface
interface IntToInt { int apply(int x); }

@FunctionalInterface
interface TwoIntToVoid { void apply(int a, int b); }

//anonymous classes:
VoidToInt vti = new VoidToInt() {
 public int apply() { return 42; }
};

IntToVoid itv = new IntToVoid() {
 public void apply(int x) { System.out.println(x); }
};

IntToInt iti = new IntToInt() {
 public int apply(int x) { return x * x; }
};

TwoIntToVoid titv = new TwoIntToVoid() {
 public void apply(int a, int b) { System.out.println(a + b); }
};

//lambda expressions:
VoidToInt vti = () -> 42;
IntToVoid itv = x -> System.out.println(x);
IntToInt iti = x -> x * x;
TwoIntToVoid titv = (a, b) -> System.out.println(a + b);
```
