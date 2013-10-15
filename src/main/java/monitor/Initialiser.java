package monitor;

import dogBeans.DataDogRecording;
import monitor.DataDogCalls;

import javax.management.*;
import java.lang.management.ManagementFactory;


public class Initialiser {
    public static void start(DataDogCalls udpClient) throws InstanceAlreadyExistsException,
            MalformedObjectNameException, MBeanRegistrationException, NotCompliantMBeanException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("monitor:type=Performance");
        DataDogRecording mbean =
                new DataDogRecording(udpClient);
        mbs.registerMBean(mbean, name);
    }
}
