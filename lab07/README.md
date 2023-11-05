# Lab 07 Overview

## `Comparator`

The Comparator interface defines a `compare(arg1, arg2)` method with two arguments that represent compared objects, and works similarly to the `Comparable.compareTo()` method.

Consider the following basic class with `Comparable`:

```java
public class LegoSet implements Comparable<LegoSet>{
    private final String code;
    private final String name;
    private final String theme;
    private final int bricks;

    // Data methods

    @Override
    public int compareTo(LegoSet o) {
        return this.name.compareTo(o.name);
    }
}
```

Defining a `Comparator` allows us to override the natural ordering previously defined by the `Comparable`.

Example:

```java
public class LegoSetComparator
        implements Comparator<LegoSet> {

    @Override
    public int compare(LegoSet o1, LegoSet o2) {
        return o1.getTheme().compareTo(o2.getTheme());
    }
}
```

Next step is to create a `Test` class. We will use an `ArrayList` to store the input. `List<LegoSet> legoSets = new ArrayList<>();`

Remember that Lists are a part of [Java Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html).

----

### Interlude: Collections

The Collection in Java is a framework that provides an architecture to store and manipulate the group of objects.

![Java Collection Hierarchy](https://static.javatpoint.com/images/java-collection-hierarchy.png)

It has a number of methods available and they're quite useful, the most important for this lab would be `Collections.sort()`.

----

Now we have two main ways of comparing:

- `Collections.sort(legoSets);` &mdash; This will call the natural ordering, i.e. `compareTo()` inherited from `Comparable`.
- `Collections.sort(legoSets, new LegoSetComparator());` &mdash; This will sort our input according the `compare()` method defined in the `LegoSetComparator` class.

----

To reduce boilerplate code, we can use multiple OOP aspects to our own advantage here:

### Package Visibility Class

```java
public class LegoSet implements Comparable<LegoSet>{
    private final String code;
    private final String name;
    private final String theme;
    private final int bricks;

    // Data methods

    @Override
    public int compareTo(LegoSet o) {
        return this.name.compareTo(o.name);
    }
}

class LegoSetComparator
        implements Comparator<LegoSet> {

    @Override
    public int compare(LegoSet o1, LegoSet o2) {
        return o1.getTheme().compareTo(o2.getTheme());
    }
}
```

Both classes are introduced in the same file.

### Nested Class

```java
public class LegoSet implements Comparable<LegoSet>{
    private final String code;
    private final String name;
    private final String theme;
    private final int bricks;

    // Data methods

    @Override
    public int compareTo(LegoSet o) {
        return this.name.compareTo(o.name);
    }

    public class LegoSetComparator
            implements Comparator<LegoSet> {

        @Override
        public int compare(LegoSet o1, LegoSet o2) {
            return o1.getTheme().compareTo(o2.getTheme());
        }
    }
}
```

In Java, it is possible to define a class within another class, such classes are known as nested classes. They enable you to logically group classes that are only used in one place, thus this increases the use of encapsulation and creates more readable and maintainable code.

> Note: the class `NestedClass` does not exist independently of the class `OuterClass`.

Hence, calling `LegoSetComparator` would be in this form: `Collections.sort(legoSets, legoSets.get(0).new LegoSetComparator());`

### Static Nested Class

```java
public class LegoSet implements Comparable<LegoSet>{
    private final String code;
    private final String name;
    private final String theme;
    private final int bricks;

    // Data methods

    @Override
    public int compareTo(LegoSet o) {
        return this.name.compareTo(o.name);
    }

    public static class LegoSetComparator
            implements Comparator<LegoSet> {

        @Override
        public int compare(LegoSet o1, LegoSet o2) {
            return o1.getTheme().compareTo(o2.getTheme());
        }
    }
}
```

and as it's a [static class](../lab03/README.md#static-keyword), it's easier to call it in the `sort()` method: `Collections.sort(legoSets, new LegoSet.LegoSetComparator());`

----

### Anonymous Classes

Anonymous classes are inner classes with no name. Since they have no name, we can’t use them in order to create instances of anonymous classes. As a result, we have to declare and instantiate anonymous classes in a single expression at the point of use.

```java
public class Test {
    public static void main(String[] args) {
        
        // stdin

        Collections.sort(legoSets, new Comparator<LegoSet>() {
            @Override
            public int compare(LegoSet o1, LegoSet o2) {
                return o1.getTheme().compareTo(o2.getTheme());
            }
        });

        // stdout
    }
}
```

### [Lambda Expressions](https://www.geeksforgeeks.org/lambda-expressions-java-8/)

```java
    Collections.sort(legoSets, (o1, o2) -> o1.getTheme().compareTo(o2.getTheme()));
```

### [`Comparator.Comparing()`](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html#comparing-java.util.function.Function-)

```java
Collections.sort(legoSets, Comparator.comparing(LegoSet::getTheme));
```

----

## Generics

The aim of generics is reducing bugs and adding an extra layer of abstraction over types.

Consider the following code snippet:

```java
    List list = new LinkedList();
    list.add(1);
    Integer i = list.iterator().next();
```

The compiler here will actually require an explicit casting, rewriting the example:

```java
    List list = new LinkedList();
    list.add(1);
    Integer i = (Integer) list.iterator().next();
```

There is no contract that could guarantee that the return type of the list is an `Integer`. The defined list could hold any object.

Let's modify it a little more:

```java
    List<Integer> list = new LinkedList<>();
    list.add(1);
    Integer i = list.iterator().next();
```

By adding the diamond operator `<>` containing the type, we narrow the specialization of this list to only `Integer` type. In other words, we specify the type held inside the list. The compiler can enforce the type at compile time.

Recommended Reading: [Baeldung &mdash; The Basics of Java Generics](https://www.baeldung.com/java-generics)

Let us consider a basic calculator implementation:

```java
public interface Calculator {
    int add(int a, int b);

    int multiply(int a, int b);
}
```

Let us make it generic now, not to just accept `int`. 

```java
public interface Calculator<T> {
    T add(T a, T b);

    T multiply(T a, T b);
}
```

Now when we implement this interface we can explicitly define a type:

```java
public class MyGenericCalculator
        implements GenericCalculator<Integer> {

    // impl...

}
```

----

## Abstract Classes

Recommended Reading: [Baeldung &mdash; Abstract Classes in Java](https://www.baeldung.com/java-abstract-class)

The idea of using an abstract class will allow us to define fields, hence we can create a nice calculator with memory.

```java
public abstract class AbstractCalculator<T extends Number> {
    T result;

    public abstract T add(T value);

    public abstract T multiply(T value);
}
```

----

List of [packages](src/lego/) for `Comparator` possibilities:

- A class having public visibility.
- A class having package visibility.
- A nested class.
- A static nested class.
- An anonymous class.
- A lambda expression (extra).
- The `Comparator.comparing` method using method reference (extra).