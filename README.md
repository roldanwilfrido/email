Email Squaretrade 
================  

Email Squaretrade

- [Github repository](https://github.com/roldanwilfrido/email)


# Software Requirements

Project with the latest available versions of the following:

* Spring Boot 3.0.0-M5+
* Java 17 - **Check out [SDKMAN!](https://sdkman.io/)**
* Jakarta EE
* H2
* Gradle 7.5+


## Setup for IntelliJ

* Install "lombok" plugin & Enable: Settings -> Compiler -> Annotation Processor -> Enable annotation processing


## Running application

1. Compiling and running unit tests
```
./gradlew clean test bootJar
```
2. Starting the App
```
./gradlew bootRun
```

## Using application

<b>URL</b>: [POST] http://localhost:8080/squaretrade/email
```json
{
    "email": "roldanhollow@gmail.com",
    "name": "Roldan"
}
```
Response: 201

## Exception handler

* Case #1: Trying the previous calling will cause:

```json
{
  "time": "2022-XX-XXThh:mm:ss.mmm",
  "status": 422,
  "message": "Email info already exist!"
}
```

* Case #2: Trying wrong email format:

<b>URL</b>: [POST] http://localhost:8080/squaretrade/email
```json
{
    "email": "badEmailFormat",
    "name": "Bad"
}
```
Response:
```json
{
  "time": "2022-XX-XXThh:mm:ss.mmm",
  "status": 400,
  "message": "Email with bad format. Please check."
}
```

## Details

* Controller (Spring web)
* Service (Spring Framework)
* Repository, Entity (Spring Data)
* Validations (Email, Already exist - Jakarta EE) 
* Exception handler (Spring web)
