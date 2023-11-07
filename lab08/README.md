# Lab 08 Overview

## `Scanner` revisited

Recall discussing [`Scanner`](../lab04/README.md#scanner) before. However, we only used the standard input. The `Scanner` class has multiple constructors[^1].

We can easily use a specific [one](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html#Scanner-java.io.File-) that uses the class [`File`](https://docs.oracle.com/javase/8/docs/api/java/io/File.html) as its argument.

```java
    Scanner scanner = new Scanner(new File("test.txt"));
```

Taking a look at the documentation, we will find the `throws` clause[^2]. This will lead us to our next topic.

*Recommended Reading: [Baeldung &mdash; Difference Between Throw and Throws in Java](https://www.baeldung.com/java-throw-throws)*

----

## Exceptions

Mainly there are three main categories of exceptional conditions:

- Checked Exceptions
- Unchecked Exceptions / Runtime Exceptions
- Errors

### Hierarchy

The objects that inherit from the Throwable class include direct descendants (objects that inherit directly from the Throwable class) and indirect descendants (objects that inherit from children or grandchildren of the Throwable class). The figure below illustrates the class hierarchy of the Throwable class and its most significant subclasses. As you can see, Throwable has two direct descendants: Error and Exception. [^3]

![The Throwable class](https://docs.oracle.com/javase/tutorial/figures/essential/exceptions-throwable.gif)

### Checked Exceptions

Checked exceptions are exceptions that the Java compiler requires us to handle. We have to either declaratively throw the exception up the call stack, or we have to handle it ourselves.

There are multiple ways we can handle exceptions[^4].

#### try-catch[^5]

Consider the following code snippet:

```java
public static void main(String[] args) {
    Scanner sc = new Scanner(new File("input.txt"));
}
```

The constructor we called throws `FileNotFoundException` exception, we have to deal with that. Let's wrap the `Scanner` in a try-catch block.

```java
public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
```

We can also catch multiple exceptions, we just need to define them:

```java
public static void main(String[] args) {
    try {
        int[] faultyArray = new int[1];
        System.out.println(faultyArray[10]);
        System.out.println(5 / 0);
        Scanner sc = new Scanner(new File("input.txt"));
    } catch (FileNotFoundException e) {
        System.out.println("File not found");
    } catch (ArithmeticException e) {
        System.out.println("Cannot Divide");
    } catch (Exception e) {
        System.out.println("Any other unspecified exception");
    }
}
```

It's worth mentioning `finally` blocks, there are times when we have code that needs to execute regardless of whether an exception occurs, and this is where the finally keyword comes in.

```java
public static void main(String[] args) {
    try {
        int[] faultyArray = new int[1];
        System.out.println(faultyArray[10]);
        System.out.println(5 / 0);
        Scanner sc = new Scanner(new File("input.txt"));
    } catch (FileNotFoundException e) {
        System.out.println("File not found");
    } catch (ArithmeticException e) {
        System.out.println("Cannot Divide");
    } catch (Exception e) {
        System.out.println("Any other unspecified exception");
    } finally {
        System.out.println("I get executed anyway");
    }
}
```

> **Note**
> The ways of usage of the try-catch blocks varies.

Notice what happens if we executed the following code snippet:

```java
public static void main(String[] args) {
    try {
        System.out.println(5 / 0); // What will this do?
        Scanner sc = new Scanner(new File("input.txt"));
    } catch (FileNotFoundException e) {
        System.out.println("File not found");
    }
}
```

The line in question will indeed throw an exception, this will be an unchecked exception. Notice that the exception we are catching here is pretty specific.

#### try-with-resources

The tradition try-catch-finally block is verbose, we can use try-with-resources[^6]. Simply put, to be auto-closed, a resource has to be both declared and initialized inside the try. Let's see how to use it:

A traditional try-catch:

```java
    try {
        Scanner sc = new Scanner(new File("input.txt"));
        while (sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
    } catch (FileNotFoundException e) {
        System.out.println("File not found");
    }
```

Now let's use try-with-resources:

```java
try (Scanner sc = new Scanner(new File("input.txt"))) {
    while (sc.hasNext()) {
        System.out.println(sc.nextLine());
    }
} catch (FileNotFoundException e) {
    System.out.println("File not found");
}
```

----

## Buffered Readers and Writers

### `BufferedReader`

Reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.[^7]

Similar to [Scanners](#scanner-revisited)? There are many reasons to favor one on the other, those can be found [here](https://www.baeldung.com/java-buffered-reader). `BufferedReader` is an interesting class to read about, it uses some really interesting software engineering design patterns.

Here's how we define it:

```java
BufferedReader br = new BufferedReader(new FileReader("input.txt"));
```

### `BufferedWriter`

Writes text to a character-output stream, buffering characters so as to provide for the efficient writing of single characters, arrays, and strings[^8].

It's one of many way to write to a file. A list of ways can be found [here](https://www.baeldung.com/java-write-to-file).

Here's how we define it:

```java
BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
```

We can use both of them in the try-with-resources. Here are two ways:

- Use `FileReader` and `FileWriter`.

    ```java
    try (
           BufferedReader br = new BufferedReader(new FileReader("input.txt"));
           BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))
    ) {
        while(true) {
            try {
                String[] tokens = br.readLine().split(";");
                bw.write(Arrays.toString(tokens) + "\n");
            } catch (NullPointerException e) {
                break;
            }
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    ```

- Use `InputStreamReader` and `OutputStreamWriter`

  ```java
  try (
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
    ) {
        while(true) {
            try {
                String line = br.readLine();
                while(line != null) {
                    System.out.println(line);
                    line = br.readLine();
                }
            } catch (NullPointerException e) {
                break;
            }
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
  ```

----

## Project Lombok

Java is a great language, but it can sometimes get too verbose for common tasks we have to do in our code or compliance with some framework practices. This often doesn’t bring any real value to the business side of our programs, and that’s where Lombok comes in to make us more productive.[^9]

The way it works is by plugging into our build process and auto-generating Java bytecode into our .class files as per a number of project annotations we introduce in our code.

We need to use [Maven](../lab05/README.md#maven) for this, it's added as a [dependency](../lab05/README.md#dependencies).

```xml
<dependencies>
    ...
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.20</version>
        <scope>provided</scope>
    </dependency>
    ...
</dependencies>
```

Consider the `LegoSet` class:

```java
public class LegoSet {
    private String code;
    private String name;
    private String theme;
    private int brick;
}
```

Now let's explore what we can do with lombok.

- `@ToString` &mdash; Generates the `toString()` method, provides options to include or exclude fields.
- `@Getter` &mdash; Generates a getter, it can be specified on the class to generate getters for all fields, or on certain fields only.
- `@Setter` &mdash; Generates a setter, can be used on a class level or a field level, similar to `@Getter`.
- `@AllArgsConstructor` &mdash; Generates a constructor with usage of all arguments.
- `@EqualsAndHashCode` &mdash; Generates `equals()` and `hashCode()`, provides options to include or exclude fields.

And many other possibilities.

[^1]: [Java Docs &mdash; Scanner](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html)

[^2]: [Oracle Java Tutorials &mdash; Specifying the Exceptions Thrown by a Method](https://docs.oracle.com/javase/tutorial/essential/exceptions/declaring.html)

[^3]: [Oracle Java Tutorials &mdash; How to Throw Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html)

[^4]: [Baeldung &mdash; Exception Handling in Java](https://www.baeldung.com/java-exceptions)

[^5]: [Oracle Java Tutorials &mdash; Catching and Handling Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html)

[^6]: [Baeldung &mdash; Java Try with Resources](https://www.baeldung.com/java-try-with-resources)

[^7]: [Java Documentation &mdash; BufferedReader](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html)

[^8]: [Java Documentation &mdash; BufferedWriter](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html)

[^9]: [Project Lombok](https://projectlombok.org/)
