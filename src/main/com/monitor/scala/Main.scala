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
  import com.monitor._      // For these to work: You need to first mvn compile with these lines commented out
//  println(random.binomial(120, 63))  // then run the 'main' class with 'Make, no error check' in your configuration
//  random.printbinomial(120, 57)      // (at least, that's the case in intelliJ. Not sure how one would deploy it.)

  commandLoop()
  system.shutdown()

}

object Commands {
  val CountdownCommand = """(\d+)""".r
  val QuitCommand      = "quit"
}
