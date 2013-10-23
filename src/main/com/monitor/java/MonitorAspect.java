package com.monitor.java;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;

@Aspect
public class MonitorAspect {

    public MonitorAspect() throws InstanceAlreadyExistsException, MalformedObjectNameException,
            NotCompliantMBeanException, MBeanRegistrationException {}

    @Pointcut(value = "execution (* akka.actor.ActorCell.receiveMessage(..)) && args(msg)", argNames = "msg")
    public void receiveMessagePointcut(Object msg) {}

    @Before(value = "receiveMessagePointcut(msg)", argNames = "jp,msg")
    public void message(JoinPoint jp, Object msg) {
        DDCalls.logSuccess();
    }
}