# A OneSky API Service layer
The idea behind this project is to provide a java sdk to OneSky's API

## Compilation
This project relies heavily on [retrofit2](https://square.github.io/retrofit/). It uses a bunch of interfaces to generate the access required method calls to interface with OneSKy's API.

Use maven to compile and install the dependency:
`mvn clean install`

## Usage
This project is available in maven central so just include it as a dependency
```
<dependency>
    <groupId>com.dustriel</groupId>
    <artifactId>onesky-service</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## Attribution
This is an unofficial plugin and it is not endorsed or supported by OneSky or any members of the organisation.
