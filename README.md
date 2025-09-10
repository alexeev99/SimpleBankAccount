### SimpleBankApp

A small java based console application made for fun and learning purposes.

The idea behind this project is to enable a bank teller to handle customer requests
when it comes to their bank accounts.

The application does not use a database (yet) so everything is in-memory.
A minimalistic, terminal based user interface is provided.

Following use cases are implemented for now:
- Customer is able to create a bank account
- Customer is able to deposit money into their bank accounts
- Customer is able to withdraw money from their bank accounts


### Prerequisites:
- Java 21.0.8
- Maven 3.9.10


### Working with the application

**Package the application:**
```shell
mvn package
```

**Start the application:**
```shell
java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
```

If everything works out, you should be greeted with a welcoming screen on the
terminal and the possibility to trigger some workflows.

**Run the tests:**
```shell
mvn test
```

#### Testing dependencies:

Following libraries are used for the test cases:
- `JUnit 5`
- `Mockito Core 5.14.2`
- `Mockito JUnit 5 Extension 5.14.2`
- `Mockito Inline 5.2.0`


#### Docker commands

If you don't want to install all necessary tools to work with the application,
you can also use docker.

**Build the image:**
```shell
docker build -t simple-bank-account .
```

**Start the application:**
```shell
docker run -it --rm simple-bank-account
```

**Run the tests:**
```shell
mvn test
```

If you want to work with the available development tools and docker, you can build
the image with the dev target stage.

```shell
docker build -t simple-bank-account-dev --target dev .
```

### Development tools

Following tools are implemented to support development:
- Checkstyle (Enforcing a preset google style guide)
- Spotless (Formatting the code)
- Error Prone (Detecting common bugs/mistakes)
  - NullAway (Detecting potential pitfalls with `null`)
- JaCoCo (Code coverage tool)

**Check style violations:**
```shell
mvn checkstyle:check
```

```shell
docker run -it simple-bank-account-dev mvn checkstyle:check
```

**Run the formatter:**
```shell
mvn spotless:apply
```

Note: If you want those changes to be reflected on the code base on your local machine,
you'll need to use a bind mount.
```shell
docker run -it simple-bank-account-dev mvn spotless:apply
```

**Detect potential pitfalls with error prone:**
Error Prone acts as a drop in replacement for the standard Java compiler.
Therefore any warnings and errors from Error Prone and shown during compile time.

```shell
mvn clean compile
```

```shell
docker run -it simple-bank-account-dev mvn clean compile
```

**Create code coverage reports**
```shell
mvn verify
```

Note: If you want the reports on your local machine, you'll need to use a bind mount.
```shell
docker run -it simple-bank-account-dev mvn verify
```

You'll find the reports within `target/site/jacoco/`
