package main.java

import javax.management.InstanceAlreadyExistsException
import javax.management.MBeanRegistrationException
import javax.management.MalformedObjectNameException
import javax.management.NotCompliantMBeanException


@Aspect
public class MonitorAspect {
  private ActorSystemMessages asm = new ActorSystemMessages();

  @Pointcut(
    value = "execution (* akka.actor.ActorCell.receiveMessage(..))" +
      "&& args(msg)",
    argNames = "msg")
  public void receiveMessagePointcut(Object msg) {}

  @Before(value = "receiveMessagePointcut(msg)",
    argNames = "jp,msg")
  public void message(JoinPoint jp, Object msg) {
    asm.recordMessage();
    System.out.println("Average throughput " + asm.average());
  }
}
