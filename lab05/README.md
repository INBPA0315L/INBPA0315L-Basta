# Lab 05 Overview

## Maven

A software project management and comprehension tool with the following objectives:
    - Making the build process easy
    - Providing a uniform build system
    - Providing quality project information
    - Providing guidelines and best practices for development

![Standard Directory Layout](https://i.imgur.com/Pe9i7la.png)

### Project Object Model (POM)

An XML document that contains a declarative description of the project.
    - Contains metadata and configuration settings

When executing a lifecycle phase or a plugin goal, Maven looks for the POM in the current directory by default.

A typical POM sturcture:

```xml
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>hu.inf.unideb</groupId>
    <artifactId>demo</artifactId>
    <packaging>jar</packaging>
    <version>1.0-SNAPSHOT</version>
    <name>com.demo</name>
    <url>http://maven.apache.org</url>
    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
            //...
            </plugin>
        </plugins>
    </build>
</project>
```

#### Project Identifiers

Maven uses a set of identifiers, also called coordinates, to uniquely identify a project and specify how the project artifact should be packaged:

- `groupId` – a unique base name of the company or group that created the project
- `artifactId` – a unique name of the project
- `version` – a version of the project
- `packaging` – a packaging method (e.g. WAR/JAR/ZIP)

The first three of these (`groupId`:`artifactId`:`version`) combine to form the unique identifier and are the mechanism by which you specify which versions of external libraries (e.g. JARs) your project will use.

##### Dependencies

These external libraries that a project uses are called dependencies. The dependency management feature in Maven ensures the automatic download of those libraries from a central repository, so you don’t have to store them locally.

- uses less storage by significantly reducing the number of downloads off remote repositories
- makes checking out a project quicker
- provides an effective platform for exchanging binary artifacts within your organization and beyond without the need for building artifacts from source every time.

##### Repositories

A repository in Maven is used to hold build artifacts and dependencies of varying types. The default local repository is located in the `.m2/repository` folder under the home directory of the user.

If an artifact or a plugin is available in the local repository, Maven uses it. Otherwise, it is downloaded from a central repository and stored in the local repository. The default central repository is [Maven Central](https://search.maven.org/classic/#search|ga|1|centra).

### Maven Build Lifecycles

- `validate` – checks the correctness of the project
- `compile` – compiles the provided source code into binary artifacts
- `test` – executes unit tests
- `package` – packages compiled code into an archive file
- `integration-test` – executes additional tests, which require the packaging
- `verify` – checks if the package is valid
- `install` – installs the package file into the local Maven repository
- `deploy` – deploys the package file to a remote server or repository

To execute an application from the command line we use `mvn exec:java`

### Recommended Readings

Maven is a huge topic, understanding the whole architecture of it would be really useful. So you can read the following:

- [Maven Overview](https://gist.github.com/Bakhomious/2e981aced4a68ed239661619c16451ce)
- [Baeldung &mdash; Apache Maven Tutorial](https://www.baeldung.com/maven)
- [Apache Maven &mdash; Documentation](https://maven.apache.org/guides/index.html)