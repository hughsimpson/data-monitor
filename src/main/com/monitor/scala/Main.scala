package com.monitor.scala

import akka.actor.{ActorRef, ActorSystem}

object Main extends App {
  import akka.actor.ActorDSL._
  import Commands._

  implicit val system = ActorSystem()

  val chatter = actor(new Act {
    become {
      case i: Int =>
        println("o")
        self ! (sender, i)
      case (sender: ActorRef, i: Int) =>
        if (i > 0)
        {
          self ! (sender, i - 1)}
        else
          sender ! "zero"
    }
  })
  implicit val _ = actor(new Act {
    become {
      case x => println(">>> " + x)
    }
  })

  def commandLoop(): Unit = {
    readLine() match {
      case CountdownCommand(count) => (0 until 5).par.map {_=>chatter ! count.toInt}

      case QuitCommand             => return

      case x          =>           println("nope")
    }

    commandLoop()
  }
//  import com.monitor.clojure._
//  println(random.binomial(5, 3))

  commandLoop()
  system.shutdown()

}

object Commands {
  val CountdownCommand = """(\d+)""".r
  val QuitCommand      = "quit"
}
