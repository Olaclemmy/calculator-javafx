# Calculator-JavaFX
The main purpose of this project was to learn JavaFX basisc and to adopt 
[MVC pattern](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller) into JavaFX base application.<br />

## Getting Started

The _model_ and _controller_ part is defined in Java's classes.<br />
The _view_ is defined in __.fxml__ file and __.css__ files.<br />

### Prerequisites

To compile, build and run the application the following components have to be installed:
- at least JDK 1.8 <br />
- latest Gradle version

### Building & running

To build the application in terminal move to the project's directory and run gradle wrapper script (dedicated for your OS),  e.g.:
```
./gradlew clean build
```
There are two options to run the application:
```
./gradlew run
```
or
```
java -jar build/libs/calculator-javafx.jar
```
## Built With
- [Gradle](https://gradle.org/) - advanced general purpose build management system based on Groovy and Kotlin
- [JavaFX](https://docs.oracle.com/javafx/2/) - is a set of graphics and media packages that enables developers 
to design, create, test, debug, and deploy rich client applications that operate consistently across diverse platforms.
- [JavaFX CSS](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html) -  styling a Java UI
