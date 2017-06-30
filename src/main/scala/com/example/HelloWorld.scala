package com.example

import akka.actor.{Actor, ActorSystem, Props}
import org.slf4j.LoggerFactory

// Define Message that shall be handled by the actor
case class GreetingMessage(name: String)

// Create an actor by extending the 'Actor' trait
class GreeterActor extends Actor {

  val logger = LoggerFactory getLogger getClass.getSimpleName

  // Define the partial function that takes anything and returns a unit
  def receive: PartialFunction[Any, Unit] = {
    // Typically, there would be one case per message to handle
    case GreetingMessage(name) => logger info s"Hello $name"
  }

}

object HelloWorld extends App {

  val logger = LoggerFactory getLogger HelloWorld.getClass

  /**
    * One can't create an instance of actor like an instance of normal class.
    * Actors are created using 'actorOf' method of the 'ActorSystem'.
    */

  logger info "Creating the 'Hello-World' actor system ..."
  val system = ActorSystem("Hello-World")

  logger info "Creating the 'greeter' actor"
  // Properties of an actor along with an optional name are supplied to create an actor
  // Props is the configuration class to specify options for creation of the actors
  val greeter = system.actorOf(Props[GreeterActor], "greeter")

  logger info "Asynchronously sending 'greeting message' to the 'greeter' actor ..."
  // '!' is the tell method
  greeter ! GreetingMessage("Akka")

  logger info "Terminating the actor system ..."
  system.terminate()

}
