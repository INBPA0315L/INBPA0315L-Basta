# Lab 02 Overview

## What is a `Class`?

Simply put, a class represent a definition or a type of object. In Java, classes can contain fields, constructors, and methods.

## What is an `Object`?

Class `Object` is the root of the class hierarchy. Every class has `Object` as a superclass. All objects, including arrays, implement the methods of this class. [^1]


[^1]: [Java Docs](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html)

----

## `Class` Definition

To define a class in Java we can do the following:

```java
class Car {

    // fields
    String type;
    String model;
    String color;
    int speed;
}
```

This Java class represents a car in general. We can create any type of car from this class. However, to create cars we need what is called a constructor. Let's extend our example:

```java
class Car {

    // fields
    String type;
    String model;
    String color;
    int speed;

    // constructor
    Car(String type, String model, String color, int speed) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.speed = speed;
    }
}
```

Every Java class has an empty constructor by default. We use it if we don’t provide a specific implementation as we did above. Here’s how the default constructor would look for our Car class:

```java
Car() {}
```

This constructor simply initializes all fields of the object with their default values. Strings are initialized to null and integers to zero.

We can also add a simple method to this class:

```java
class Car {

    // fields
    String type;
    String model;
    String color;
    int speed;

    // constructor
    Car(String type, String model, String color) {
        this.type = type;
        this.model = model;
        this.color = color;
    }

    // methods
    int increaseSpeed(int increment) {
        this.speed += increment;
        return this.speed;
    }
}
```

## `Object` Definition

While classes are translated during compile time, objects are created from classes at runtime.

Objects of a class are called instances, and we create and initialize them with constructors and call `increaseSpeed()`:

```java
Car focus = new Car("Ford", "Focus", "red");
focus.increaseSpeed(30);
```

----

## Access Modifiers

The class we defined is very simple and missing lots of important key features of a class. One of which is access modifiers. You can think of access modifiers as the visibility of the class members, whether they are fields or methods.

|Modifier | Description |
|---------|-------------|
|`default` | declarations are visible only within the package (package private) |
|`private` | declarations are visible within the class only |
|`protected` | declarations are visible within the package or all subclasses|
|`public` | declarations are visible everywhere

If we did not specify an access modifier, it's automatically set to `default`.

Back to our little example. We want our constructor and methods to be public and available for access, however we want our fields to be private. Fields hold the state of our object, therefore we want to control access to that state. We can keep some of them private, and others public.

```java
public class Car {

    // fields
    private String type;
    private String model;
    private String color;
    private int speed;

    // constructor
    public Car(String type, String model, String color) {
        this.type = type;
        this.model = model;
        this.color = color;
    }

    // methods
    public int increaseSpeed(int increment) {
        this.speed += increment;
        return this.speed;
    }
}
```

Now the question would be, what to do if we want to access these fields? We achieve this using specific methods called getters and setters. Let's extend our class further:

```java
public class Car {

    // fields
    private String type;
    private String model;
    private String color;
    private int speed;

    // constructor ...

    // methods ...

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
```

The type and model fields do not have getters and setters, because they hold internal data of our objects. We can define them only through the constructor during initialization. Furthermore, the color can be accessed and changed, whereas speed can only be accessed, but not changed. We enforced speed adjustments through specialized public methods like `increaseSpeed()` and `decreaseSpeed()`. In other words, we use access control to **encapsulate** the state of the object.

You might've noticed the keyword `this`. In Java, `this` keyword is a reference to the current object whose method is being called.

----

## `toString()` Method

If you want to represent any object as a string, `toString()` method comes into existence. The `toString()` method returns the String representation of the object. Let's look at an example for our `Car` class:

```java
    @Override
    public String toString() {
        return "Car [type=" + type + ", model=" + model + ", color=" + color + ", speed=" + speed + "]";
    }
```

`@Override` indicates that we are overriding the default behavior of the `toString()` function defined by the super class, i.e `Object`.

----

## `equals()` Method

The Object class defines both the equals() and hashCode() methods, which means that these two methods are implicitly defined in every Java class, including the ones we create.

```java
Car focus = new Car("Ford", "Focus", "red");
Car focus2 = new Car("Ford", "Focus", "red");
```

As we can see we defined to exactly similar cars, however in the realm of Java they're not equal. `focus.equals(focus2)` won't return `true`. The **default implementation** of `equals()` in the `Object` class says that equality is the same as object identity, and `focus` and `focus2` are two distinct instances.

We can override this behavior easily.

```java
@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return speed == car.speed && Objects.equals(type, car.type) && Objects.equals(model, car.model) && Objects.equals(color, car.color);
    }
```

----

## `hashCode()` Method

`hashCode()` returns an integer representing the current instance of the class. We should calculate this value consistent with the definition of equality for the class. Thus, if we override the `equals()` method, we also have to override `hashCode()`.

Recommended further reading: 

- [Baeldung &mdash; Java equals() and hashCode() Contracts](https://www.baeldung.com/java-equals-hashcode-contracts)
- [Baeldung &mdash; Guide to hashCode() in Java](https://www.baeldung.com/java-hashcode)
- 
