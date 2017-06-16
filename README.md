# Gradle for Java

Welcome to the demos and exercises for the Hack & Söhne Tooling Deep Dive!

The exercises were taken from Udacity's ud867 course and modified to fit this format. 

They are much shorter and cover what you need to know 90% of the time when working with Gradle, but they are not as in depth as Udacity's exercises.

### Basic commands

```gradle taskname```: Run task ```taskname```

```gradle tasks```: Show *most* available tasks

```gradle tasks --all```: Show *all* available tasks

```gradle dependencies```: Download dependencies

```gradle -b anotherfile.gradle taskname```: Run ```taskname``` in ```anotherfile.gradle``` instead of in ```build.gradle```


### Running the Gradle wrapper:

* Unix: ```./gradlew taskname```
* Windows: ```gradlew taskname```
