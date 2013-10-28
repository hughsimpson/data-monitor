package com.monitor.aspects;

import com.monitor.scala.DataDogCalls;
//import com.monitor.statsdCalls;

public aspect MonitorAspect {

    after(Object[] msgs) : call(* akka.actor.ActorCell.receiveMessage(java.lang.Object...)) && args(msgs) {
        System.out.println("££££");
        DataDogCalls.logSuccess();
    }
    pointcut receiveMessage(akka.actor.ActorCell actorCell, Object msg) : target(actorCell) &&
     call (* akka.actor.ActorCell.receiveMessage(..)) && args(msg);

    before(akka.actor.ActorCell actorCell, Object msg): receiveMessage(actorCell, msg) {
        DataDogCalls.logSuccess();
        actorCell.guardian();
        System.out.println("!£$^^$&");
    }


}