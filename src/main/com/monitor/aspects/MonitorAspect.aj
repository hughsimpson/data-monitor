package com.monitor.aspects;

import com.monitor.scala.DataDogCalls;
//import com.monitor.statsdCalls;

public aspect MonitorAspect {

    after(Object[] msgs) : call(* akka.actor.ActorCell.receiveMessage(java.lang.Object...)) && args(msgs) {
        System.out.println("££££");
        DataDogCalls.logSuccess();
    }
    after(akka.actor.ActorCell actorCell, Object msgs) : target(actorCell) && call(* akka.actor.ActorCell.receiveMessage(..)) && args(msgs) {
        System.out.println("###");
        DataDogCalls.logSuccess();
    }


}