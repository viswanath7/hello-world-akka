# Introduction
A hello world application in scala using akka

## Objective
The objective of 'hello-world-akka' application is to print 'Hello Akka'

## Implementation details
The scala class **_HelloWorld_** contains all the components 
It  
 1. Defines an untyped actor called **_Greeter_**
 2. Defines a case class called '**_GreetingMessage_**' which represents the message that shall be handled by the actor
 3. It creates an application called '**_HelloWorld_**' that 
 * Creates an actor system
 * Creates an actor
 * Sends message to that actor
 * Terminates the actor system
 
## Execution 

Select **_HelloWorld_** object in your IDE and just run it. 
Alternatively, issue the command from terminal
```sh
sbt clean run
```
 
