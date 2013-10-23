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

public privileged aspect MonitorAspect {

//    public MonitorAspect() throws InstanceAlreadyExistsException, MalformedObjectNameException,
//            NotCompliantMBeanException, MBeanRegistrationException {System.out.println("I'm alive!");}
//
//  @Pointcut(value = "execution (* akka.actor.ActorCell.receiveMessage(..)) && args(msg)", argNames = "msg")
//  public void receiveMessagePointcut(Object msg) {}
//
//  @Before(value = "receiveMessagePointcut(msg)", argNames = "jp,msg")
//  public void message(JoinPoint jp, Object msg) {
//      DataDogCalls.logSuccess();
//      DataDogCalls.logContent(msg);
//  }
    after(Object[] msgs) : call(* akka.actor.ActorCell.receiveMessage(java.lang.Object...)) && args(msgs) {
        DataDogCalls.logSuccess();
    }


}