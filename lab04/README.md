# Lab 04 Overview

## `String.split()`

The `String` library in Java offers a great deal of methods. One of these is `split()`, which splits the given `String` based on the delimiter, returning an array of Strings.

Example:

```java
String[] splitted = "Thom,Ed,Jonny,Colin,Philip".split(",");
```

Further Reading: [Baeldung &mdash; Split a String in Java](https://www.baeldung.com/java-split-string)

----

## Arrays

According to the [Java documentation](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html), an array is an object containing a fixed number of values of the same type. The elements of an array are indexed, which means we can access them with numbers (called indices).

Declaration:

```java
int[] stuff;
int anotherStuff[];
```

Initialization

```java
int[] anArray = new int[10];
```

When using this method, we initialize each element to its default value, here `0`. When initializing an array of Object, elements are `null` by default.

Accessing Elements:

```java
anArray[0] = 10
```

Iteration:

Standard For-Loop

```java
int[] anArray = new int[] {1, 2, 3, 4, 5};
for (int i = 0; i < anArray.length; i++) {
    System.out.println(anArray[i]);
}
```

For-each loop

```java
int[] anArray = new int[] {1, 2, 3, 4, 5};
for (int element : anArray) {
    System.out.println(element);
}
```

Further Reading: [Baeldung &mdash; Arrays in Java](https://www.baeldung.com/java-arrays-guide)

----

## `Scanner`

### `nextLine()`

The `nextLine()` method of the `java.util.Scanner` class scans from the current position until it finds a line separator delimiter `\n`. The method returns the `String` from the current position to the end of the line.

### `next()`

Typically, Scanner breaks the input into tokens using a delimiter pattern, which is, by default, any whitespace.

With that being said, `next()`, as the name implies, reads **only** the next token from the input until it encounters the delimiter.

Must Read:

- [Baeldung &mdash; Integer.parseInt(scanner.nextLine()) and scanner.nextInt() in Java](https://www.baeldung.com/java-scanner-integer)
- [Baeldung &mdash; Read Multiple Inputs on Same Line](https://www.baeldung.com/java-read-multiple-inputs-same-line)

----

## Comparisons

Comparisons in Java are quite easy, until they’re not.

When working with custom types, or trying to compare objects that aren’t directly comparable, we need to make use of a comparison strategy. We can build one simply by making use of the `Comparator` or `Comparable` interfaces.

`Comparable` interface defines a strategy of comparing an object with other objects of the same type.

The sorting order is decided by the return value of the `compareTo()` method. The `Integer.compare(x, y)` returns `-1` if `x` is less than `y`, `0` if they’re equal, and `1` otherwise.

Example:

```java
public class Airport implements Comparable<Airport>{

    private String name;
    private String city;
    private int runways;
    private int time;


    @Override
    public int compareTo(Airport o) {
        if (this.runways != o.runways) {
            // Negative sign -> Descending
            return -Integer.compare(this.runways, o.runways);;
        }
        if (this.time != o.time) {
            return -Integer.compare(this.time, o.time);
        }

        return this.name.compareTo(o.name);
    }
}
```

Recommended Reading: [GeeksForGeeks &mdash; Comparable vs Comparator in Java](https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/)