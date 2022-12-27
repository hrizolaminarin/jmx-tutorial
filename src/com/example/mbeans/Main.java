package com.example.mbeans;

import java.lang.management.*;
import javax.management.*;

/**
 * https://docs.oracle.com/en/java/javase/19/jmx/essentials-jmx-api.html#GUID-41CDE7AB-FEAD-42E0-BCE6-933501B654E2
 * */
public class Main {

    public static void main(String[] args) throws Exception {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        ObjectName name = new ObjectName("com.example.mbeans:type=Hello");

        Hello mbean = new Hello();

        mbs.registerMBean(mbean, name);

        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
/**
 * Copy the source code contained in the JMX Essentials section and create corresponding files in the work_dir/jmx_examples/Essential directory.
 *
 * Compile the example Java classes.
 * $ javac com/example/mbeans/*.java
 *
 * Start the Main application.
 * $ java com.example.mbeans.Main
 *
 * You will see a confirmation that Main is waiting for something to happen.
 *
 * Start JConsole in a different terminal window on the same machine.
 * $ jconsole
 *
 * You will see the JConsole tool open, presenting a list of running JMX agents that you can connect to.
 *
 * Select com.example.mbeans.Main from the list in the “New Connection” window, and click on Connect.
 * You will see a summary of your platform’s current activity.
 *
 * Click on the MBeans tab.
 * This panel shows you all the MBeans currently registered in the MBean server.
 *
 * In the left-hand frame, expand the com.example.mbeans node in the MBean tree.
 * You will see the example MBean Hello, that was created and registered by Main. If you click Hello, you will see its associated Attributes and Operations nodes in the MBean tree.
 *
 * Click on the Hello MBean node in the MBean tree to display the Hello MBean’s metadata and its associated Descriptor.
 * Click the Attributes node of the Hello MBean in the MBean tree.
 * This displays the MBean attributes that were defined by the Hello class.
 *
 * Change the value of the CacheSize attribute to 150.
 * In the terminal window in which you started Main, you will see confirmation of this change of attribute.
 *
 * Click the Operations node of the Hello MBean in the MBean tree.
 * Here you will see the two operations declared by the Hello MBean, sayHello() and add().
 *
 * Invoke the sayHello() operation, by clicking on the sayHello button.
 * A JConsole dialogue box will inform you that the method was invoked successfully, and you will see the message “hello, world” in the terminal window in which Main is running.
 *
 * Provide two integers for the add() operation to add , and click the add button.
 * You will be informed of the answer in a JConsole dialogue box.
 *
 * Click Connection and then Exit, to exit JConsole.
 * */