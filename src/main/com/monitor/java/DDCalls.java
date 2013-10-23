package com.monitor.java;

import com.timgroup.statsd.NonBlockingStatsDClient;
import com.timgroup.statsd.StatsDClient;
import akka.actor.ActorRef;

public class DDCalls {
    private static final StatsDClient statsd = new NonBlockingStatsDClient("", "localhost", 8125, new String[]{"tag:value"});

    static void logSuccess() {statsd.incrementCounter("message.successes");}

    static void logFailure() {statsd.incrementCounter("message.failures");}

    static void logErrorType(int code) {statsd.recordHistogramValue("error.type", code);}

    static void incCount(String s) {statsd.incrementCounter(s);}

    static void logContent(String s) {
        statsd.incrementCounter(s);
    }

    static void logContent(Object cont) {
        statsd.incrementCounter(cont.getClass().toString());
    }
}
