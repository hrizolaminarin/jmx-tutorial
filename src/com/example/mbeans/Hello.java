package com.example.mbeans;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Hello extends NotificationBroadcasterSupport implements HelloMBean {

    private static final int DEFAULT_CACHE_SIZE = 200;

    private final String name = "Reginald";
    private int cacheSize = DEFAULT_CACHE_SIZE;

    private long sequenceNumber = 1;

    public void sayHello() {
        System.out.println("hello, world");
    }

    public int add(int x, int y) {
        return x + y;
    }

    public String getName() {
        return this.name;
    }

    public int getCacheSize() {
        return this.cacheSize;
    }

    public synchronized void setCacheSize(int size) {
        int oldSize = this.cacheSize;
        this.cacheSize = size;

        System.out.println("Cache size now " + this.cacheSize);

        Notification n = new AttributeChangeNotification(this,
                        sequenceNumber++,
                        System.currentTimeMillis(),
                        "CacheSize changed",
                        "CacheSize",
                        "int",
                        oldSize,
                        this.cacheSize);

        sendNotification(n);
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {

        String[] notificationTypes = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };
        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info = new MBeanNotificationInfo(notificationTypes, name, description);

        return new MBeanNotificationInfo[] {info};
    }
} 