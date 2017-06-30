package com.example

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, FlatSpecLike, MustMatchers}

class GreeterActorSpec extends TestKit(ActorSystem("test-actor-system")) with ImplicitSender
  with FlatSpecLike with BeforeAndAfterAll with MustMatchers {

  override def afterAll() = TestKit.shutdownActorSystem(system)

  "Greeter Actor" should "accept GreetingMessage with a name" in {
    val greeterActor = system.actorOf(Props[GreeterActor])
    greeterActor ! GreetingMessage("User")
    expectNoMsg()
  }
}
