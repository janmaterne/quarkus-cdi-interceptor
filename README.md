# cdi-interceptor project

The goal of this project is to implement a CDI interceptor running Quarkus with less code as possible.

Steps while experimenting:

  * generate the project via http://code.quarkus.io
  * delete stuff we don't need for this project goal:
    * no native compilation, therefore no dockerfiles and no native test support
    * no website, just the endpoint 
  * use JEE tutorial to implement a CDI interceptor
  * try to get rid off some code: 
     * Quarkus doesn't need a `beans.xml` file
     * Quarkus configuration file (`application.properties`) is optional
  * try some 'clean ups' and comment their failure 

Note:

I tried native compilation without success, so I can't provide feedback here. 
But the failure leads to improper environment:

```
[ERROR] Failed to execute goal io.quarkus:quarkus-maven-plugin:1.4.2.Final:build (default) on project cdi-interceptor: 
        Failed to build quarkus application: io.quarkus.builder.BuildException: Build failure: Build failed due to errors
[ERROR]         [error]: Build step io.quarkus.deployment.pkg.steps.NativeImageBuildStep#build threw an exception: 
                         java.lang.RuntimeException: Cannot find the `native-image.cmd` in the GRAALVM_HOME, JAVA_HOME and System PATH. 
                         Install it using `gu install native-image`
```


## CDI-Interceptor

The CDI interceptor is based on https://docs.oracle.com/javaee/6/tutorial/doc/gkhjx.html

## Quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `cdi-interceptor-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/cdi-interceptor-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/cdi-interceptor-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.


