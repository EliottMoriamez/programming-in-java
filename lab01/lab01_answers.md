**1)Concept of encapsulation, inheritance and polymorphism**

1. Encapsulation allows to create a new type, personalized with new methods\
2. a) A setter allows the user to set the value of a parameter in a class\
b) A getter allows the user to get that value which\
We need those because most of the time these values are private and only available from a method in the class to "protect them" and avoid problems.
3. when you implement a method you may use parameters that have the same name as the class attribute, *this* allows to specify that you talk about the attribute and not the parameter\
*super* allows to get the same attributes as the father class when you create an inherited class
4. *inheritance* is the action to create a new class which is an extension from another class, this will act like the father class but you can implement more specific methods
5. *polymorphism* is when classes that inherit from the same class have methods that have the same name but unique to each of them 
there is the inheritance has explained in 4 and 5 where we extend a parent class, the interface where the parent class isn't defined with a lot of methods but that warns that the class that implement that interface need to have certain specific methods, finally there is the overloading polymorphism where we write different methods with the same name but with different parameters, allowing to prevent different type of answers for instance.
6. Idk
7. reading
8. 
\
**2)Static members**

1. Static Variable is a variable accessible to all instances of a class. A static constant is a fixed static variable that cannot change. And a static method is a method in a class that can only access to its class variables.
2. A static constant cannot be change so it's not necessary to make a setter because there is less risk of causing problems by changing it by mistake
3. idk
4. It could be a method like static void displayScore(){System.out.println(score);} with score being a static variable for instance.

**3)Constructors, factory methods and singletons**

