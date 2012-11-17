package org.greyhope.gf.mon.start;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.greyhope.gf.mon.framework.Application;
import org.greyhope.gf.mon.lists.ApplicationList;
import org.greyhope.gf.mon.properties.Properties;
import org.greyhope.gf.mon.lists.MonitoringStack;
import org.greyhope.gf.mon.rest.RestClient;
import org.greyhope.gf.mon.tasks.ConnectionQueueTask;
import org.greyhope.gf.mon.utils.Functions;

public class Starter {
    
    private RestClient client = null;
    
    private static ApplicationList<Application> applicationList;
    private static String monitoringResource = null;
    private static String resourceType = null;
    
   // Executor Scheduler Services
    private ScheduledExecutorService mainWindowTaskScheduler = null;
    
    public Starter(Properties.CONNECTION connectionType) throws Exception {
        
        // Prolly should create one thread to manage a few monitoring nodes
       mainWindowTaskScheduler = Executors.newScheduledThreadPool(Properties.THREADS);
       
       MonitoringStack.init();
       
       initService(connectionType);
       
    }
    
    public static void main(String[] args) {

        Properties.init();
        Functions.init();
        
        applicationList = new ApplicationList<Application>();
        
        try {
            Starter src = new Starter(Properties.appConnection);
        } catch (Exception t) {
            System.out.println("Exception whilst starting program : " + t.getMessage());
        }
    }
    
    private void initService(Properties.CONNECTION connectionType){
         Runnable clientTask = new ConnectionQueueTask(connectionType,Properties.BASE_URL.toString());
         ScheduledFuture<?> pollerTaskFuture = mainWindowTaskScheduler.scheduleWithFixedDelay(
                clientTask, Properties.INITIAL_DELAY_POLLER_THREAD,
                Properties.INTERVAL_DELAY_POLLER_THREAD, TimeUnit.SECONDS);
    }
    
    
}
