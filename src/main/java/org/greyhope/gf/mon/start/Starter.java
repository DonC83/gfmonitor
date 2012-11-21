package org.greyhope.gf.mon.start;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.greyhope.gf.mon.applications.Application;
import org.greyhope.gf.mon.gui.ConsoleMonitoring;
import org.greyhope.gf.mon.lists.ApplicationList;
import org.greyhope.gf.mon.properties.Properties;
import org.greyhope.gf.mon.rest.RestClient;
import org.greyhope.gf.mon.tasks.ConnectionQueueTask;
import org.greyhope.gf.mon.utils.Functions;

public class Starter {
    
    private RestClient client = null;
    
    public static ApplicationList<Application> applicationList;
    private static String monitoringResource = null;
    private static String resourceType = null;
    
    private ConsoleMonitoring console;
    
    public Starter(Properties.CONNECTION connectionType) throws Exception {
        
        console = new ConsoleMonitoring(connectionType);
        
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
    
}
