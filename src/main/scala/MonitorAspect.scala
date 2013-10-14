package main.scala


import javax.management.InstanceAlreadyExistsException
import javax.management.MBeanRegistrationException
import javax.management.MalformedObjectNameException
import javax.management.NotCompliantMBeanException


@Aspect
public class MonitorAspect {

  @Pointcut(
    value = "execution (* akka.actor.ActorCell.receiveMessage(..))" +
      "&& args(msg)",
    argNames = "msg")
  public void receiveMessagePointcut(Object msg) {}

  @Before(value = "receiveMessagePointcut(msg)",
    argNames = "jp,msg")
  public void message(JoinPoint jp, Object msg) {
    // log the message
    System.out.println("Message " + msg);
  }
}
