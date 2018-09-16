package com.nino;

import org.joda.time.DateTime;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ScheduledThreadPoolExecutor ses = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);
        ses.getQueue();
        System.out.println( "Hello World!" );
    }
}
