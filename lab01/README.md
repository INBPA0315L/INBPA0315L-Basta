# Lab 01 Overview

Java is:
- Statically-typed
- Object-oriented
- Platform-independent

## Basic Syntax

### Data types

Mainly there are two broad categories of data types in Java: [Primitive](#primitive-types) and [Objects/Reference](#reference-types) types

#### Primitive Types

Basic data types that store simple data and form the foundation of data manipulation. 

This includes:

- Integer values (`int`, `long`, `byte`, `short`)
- Floating-point values (`float`, `double`)
- Character values (`char`)
- Logical values (`boolean`)
  Very similar to the C programming languages, to declare a variable we must specify **name (identifier)** and **type**.

Example:

```java
int a;
int b;
double c;
```

Unlike C language, declaring a variable would have a default value (0 or 0.0 in case of numeric types). It's still possible to use the assignment operator `=` to initialize the variables during declaration:

```java
int a = 10;
char toggler = 'Y';
boolean isValid = true;
```

#### Reference Types

Objects that contain the references to values and/or other objects, this can include the special value `null` to denote the absence of a value.

An array is a reference type that can store a collection of values of a specific types. General syntax: `type[] identifier = new type[length];`. Type can be either primitive or reference.

Example:

```java
int[] numbers = new int[100];
numbers[0] = 1;
numbers[1] = 2;

int secondElement = numbers[2];
```

-----

## Naming

It's important to note how to name an identifier, it has to conform to the following rules:

- Starts with a letter, an underscore (`_`), or a dollar sign (`$`).
- Cannot be a reserved keyword (Footnote 1).
- Cannot be `true`, `false`, `null`

Preferably, every programming language has coding conventions, which are a set of rules that help us write a more readable code. *Recommended reading: [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)*

----

## Operators

- Arithmetic &mdash; `+`, `-`, `*`, `/`, `%`
- Logical &mdash; `&&`, `||`, `!`
- Comparison &mdash; `<`, `>`, `<=`, `>=`, `==`, `!=`

----

## Java Program Structure

The basic unit of a Java program is a `Class`. A Class can have one or more fields, methods, and even other class members(inner classes).

For a class to be executable, it must have [a `main` method](https://www.baeldung.com/java-main-method). Like C, this is the entry point of the program.

Example:

```java
public class HelloWorld {
    
    public static void main(String[] args) {
        int meaningOfLife = 42;
        System.out.println("Hello World! The meaning of life is the number " + meaningOfLife);
    }
}
```

## Compiling and Execution

To execute our source code, we first need to compile it. This process will generate a binary file with the `.class` file extension. We can execute the binary file on any machine that has a Java Runtime Environment (JRE) installed.

Remember that Java is platform-independent, this is achieved using JVM. *Recommended Reading: [GeeksForGeeks - Differences between JDK, JRE and JVM](https://www.geeksforgeeks.org/differences-jdk-jre-jvm/).*

- Compile: `javac HelloWorld.java`
- Execute: `java HelloWorld`

----

## If-Else

```java
if (count > 2) {
    System.out.println("Count is higher than 2");
} else {
    System.out.println("Count is lower or equal than 2");
}
```

----

## Switch Expression

For switch we have two syntaxes

### Classic Syntax

```java
public String exampleOfSwitch(String animal) {
    String result;
    switch (animal) {
        case "DOG":
            result = "domestic animal"; 
            break;
        case "CAT":
            result = "domestic animal";
            break;
        case "TIGER":
            result = "wild animal";
            break;
        default:
            result = "unknown animal";
            break;
    }
    return result;
}
```

### New Syntax

This new syntax was introduced in Java 12

```java
switch (day) {
        case MONDAY, FRIDAY, SUNDAY -> numLetters = 6;
        case TUESDAY -> numLetters = 7;
        case THURSDAY, SATURDAY -> numLetters = 8;
        case WEDNESDAY -> numLetters = 9;
        default -> numLetters = 0;
    };
```

----

## Loops

An example of both `for` and `while` loops:

```java
for (int i = 1; i <= 50; i++) {
    methodToRepeat();
}

int whileCounter = 1;
while (whileCounter <= 50) {
    methodToRepeat();
    whileCounter++;
}
```

Note that: we can use `break` to exit early from a loop, or `continue` to simply skip the current iteration we are in.

----
#### Footnotes

1. [Keywords](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html) are reserved words that have special meaning in Java.
