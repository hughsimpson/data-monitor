package main.java;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class JMXEndpoint {
    public static void start(ActorSystemMessages messages) throws InstanceAlreadyExistsException,
            MalformedObjectNameException, MBeanRegistrationException, NotCompliantMBeanException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("monitor:type=Performance");
        ActorSystemPerformanceMXBeanImpl mbean =
                new ActorSystemPerformanceMXBeanImpl(messages);
        mbs.registerMBean(mbean, name);
    }
}

