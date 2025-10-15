**2) Generic methods, classes, and interfaces**
1. Generic types eliminate explicit casts so its easier to type values, and provide compile-time type checking so it's safer to use.
2. For Generic class: ```class ClassName<T1, T2 extends Bound, ...> {...}```\
and Generic Method: ```public static <T extends Bound> ReturnType methodName(T param) { ... }```
3. A raw type is the generic type name without type arguments (ex: List instead of List<String>). But it's unsafe because it removes compile-time type checks and so allows inserting wrong element types and causes ClassCastException at runtime. But it's allowed because of backward compatibility with pre-generics Java.
4. fff

**3) Bounds for type variables**
1. Bounds restrict type parameters to a subset of types so methods can use members of the bound (methods/fields) and enable compile-time safety.
2. It's allowed if one class bound appears first, then interfaces.

**4) Subtyping and Wildcards**
1. 
- Invariance: Generic types with different type arguments are unrelated; GenBox\<A> and GenBox\<B> are not subtypes even if A and B are related.
- Covariance: Allows a container of subtype to be seen as a container of supertype when only reading; expressed with ? extends T.
- Contravariance: Allows a container of supertype to be used where a container of subtype is expected when only writing; expressed with ? super T.

2. 
- Subtype wildcard: <? extends T> — permits reading items as T, prevents safe writes except null.
- Supertype wildcard: <? super T> — permits writing T (or its subtypes), reading yields Object (need cast).
- Unbounded wildcard:<?> — read-only as Object, useful for methods that work on any generic type without assumptions.

3. 
- GenBox\<B> gb2 = new GenBox\<C>(); — does not compile because GenBox\<C> is not a subtype of GenBox\<B> (generic types are invariant).
- GenBox\<B> gb3 = new GenBox\<A>(); — does not compile because GenBox\<A> is not a subtype of GenBox\<B>.
- GenBox<? extends B> gb6 = new GenBox\<A>(); — does not compile because A is a supertype of B and cannot match ? extends B.
- gb5.setX(new B()); — does not compile because you cannot write to a reference declared as <? extends B>.
- gb5.setX(new C()); — does not compile for the same reason: writing into ? extends B is disallowed.
- GenBox<? super B> gb8 = new GenBox<C>(); — does not compile because C is a subtype of B and cannot match ? super B.
- B b3 = gb9.getX(); — does not compile because getX on ? super B returns Object (or ? super B), not B without a cast.
- B b4 = gb10.getX(); — does not compile because getX on an unbounded wildcard ? returns Object, not B without a cast.
- gb10.setX(new B()); — does not compile because you cannot write to a reference declared as an unbounded wildcard ?.


Code on : https://github.com/EliottMoriamez/programming-in-java.git