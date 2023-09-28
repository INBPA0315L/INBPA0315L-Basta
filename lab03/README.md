# Lab 03 Overview

## Inheritance

One of the core principles of Object-Oriented Programming –inheritance– enables us to reuse existing code or extend an existing type.

Simply put, in Java, a class can inherit another class and multiple interfaces, while an interface can inherit other interfaces.

Imagine, as a car manufacturer, you offer multiple car models to your customers. Even though different car models might offer different features like a sunroof or bulletproof windows, they would all include common components and features, like engine and wheels.

It makes sense to create a basic design and extend it to create their specialized versions, rather than designing each car model separately, from scratch.

In a similar manner, with inheritance, we can create a class with basic features and behavior and create its specialized versions, by creating classes, that inherit this base class.

Just know a few terms:

- a base type is called `super` or a parent.
- a derived type is called a child.

### Class inheritance

Let's define a base class:

```java
public class Car {
    private String plate;
    private int power;
    private boolean automatic;

    public Car(String plate, int power, boolean automatic) {
        this.plate = plate;
        this.power = power;
        this.automatic = automatic;
    }
}
```

Let's define another class that extends this class:

```java
public class Truck extends Car{

    protected int capacity;

    public Truck(String plate, int power, boolean automatic, int capacity) {
        super(plate, power, automatic);
        this.capacity = capacity;
    }
}
```

A subclass class inherits the non-static protected and public members from the superclass class. In addition, the members with default (package-private) access are inherited if the two classes are in the same package.

On the other hand, the private and static members of a class are not inherited. Notice we use the constructor.

----

## `static` Keyword

In the Java programming language, the keyword `static` means that **the particular member belongs to a type itself, rather than to an instance of that type**.

> This means we’ll create only one instance of that static member that’s shared across all instances of the class.

![Visual Representation](https://www.baeldung.com/wp-content/uploads/2017/10/Static_variables_shared_in_Java_1-1.jpg)

It doesn’t matter how many times we instantiate a class. There will always be only one copy of static field belonging to it. The value of this static field is shared across all objects of either the same class.

From the memory perspective, **static variables are stored in the heap memory**.

Example of a `static` field: 

```java
public class Car {
    private String plate;
    private int power;
    private boolean automatic;

    public static int numberOfCars;

    public Car(String plate, int power, boolean automatic) {
        this.plate = plate;
        this.power = power;
        this.automatic = automatic;
        numberOfCars++;
    }
}
```

Now for every object of this class that we instantiate, the same copy of the numberOfCars variable is incremented. (Notice I edited the constructor as well)

### Key points

- Since static variables belong to a class, we can access them directly using the class name. So, we don’t need any object reference.
- We can only declare static variables at the class level.
- We can access static fields without object initialization.

### Static methods

We generally use static methods to perform an operation that’s not dependent upon instance creation.

We use them to access/manipulate static variables and other static methods that don’t depend upon objects.

An example:

```java
    public static Car getCoolerCar(
            Car first, Car second){
        if(first.power > second.power) {
            return first;
        } else {
            return second;
        }
    }
```

Note: *Static methods can’t be overridden.*

## `final` keyword

Variables marked as `final` can’t be reassigned. Once a final variable is initialized, it can’t be altered.

Final fields can be either constants or write-once fields. To distinguish them, we should ask a question — would we include this field if we were to serialize the object? If no, then it’s not part of the object, but a constant.

Note that any final field must be initialized before the constructor completes.

Note that according to naming conventions, class constants should be uppercase, with components separated by underscore ("_") characters:

```java
public class Car {
    private String plate;
    private int power;
    private boolean automatic;

    public static int numberOfCars;

    public static final int NUMBER_OF_WHEELS = 4;
}
```

----

## Interfaces

n Java, an interface is an abstract type that contains a collection of methods and constant variables. It is one of the core concepts in Java and is used to achieve **abstraction**, **polymorphism** and **multiple inheritances**.

A simple interface example would be:

```java
public interface Moving {
    void move();
    void repair();
}
```

We use `implements` keyword to implement these interfaces into our classes. However, we have to override the pre-defined methods in the interface:

```java
public class Car implements Moving {

    // ....
    @Override
    public void move() {
        System.out.println("I am a moving Car");
    }

    @Override
    public void repair() {
        System.out.println("I am repairing the Car");
    }
}

```

Recommended Reading: [Baeldung &mdash; Interfaces](https://www.baeldung.com/java-interfaces)
