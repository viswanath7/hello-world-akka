package com.example

import akka.actor.{Actor, ActorSystem, Props}
import org.slf4j.LoggerFactory

// Define Message that shall be handled by the actor
case class GreetingMessage(name: String)

class Greeter extends Actor {

  val logger = LoggerFactory getLogger "Greeter"

  def receive: PartialFunction[Any, Unit] = {
    case GreetingMessage(name) => logger info s"Hello $name"
  }

}

object HelloWorld extends App {

  val logger = LoggerFactory getLogger HelloWorld.getClass

  logger info "Creating the 'Hello-World' actor system ..."
  val system = ActorSystem("Hello-World")

  logger info "Creating the 'greeter' actor"
  val greeter = system.actorOf(Props[Greeter], "greeter")

  logger info "Asynchronously sending 'greeting message' to the 'greeter' actor ..."
  greeter ! GreetingMessage("Akka")

  logger info "Terminating the actor system ..."
  system.terminate()

}
