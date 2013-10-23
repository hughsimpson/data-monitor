package com.monitor.aspects;

import com.monitor.scala.DataDogCalls;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;

public aspect MonitorAspect {
//
//  @Before(value = "receiveMessagePointcut(msg)", argNames = "jp,msg")
//  public void message(JoinPoint jp, Object msg) {
//      DataDogCalls.logSuccess();
//      DataDogCalls.logContent(msg);
//  }
    after(Object[] msgs) : call(* akka.actor.ActorCell.receiveMessage(java.lang.Object...)) && args(msgs) {
        System.out.println("££££");
        DataDogCalls.logSuccess();
    }
    after(akka.actor.ActorCell actorCell, Object msgs) : target(actorCell) && call(* akka.actor.ActorCell.receiveMessage(..)) && args(msgs) {
        System.out.println("###");
        DataDogCalls.logSuccess();
    }


}