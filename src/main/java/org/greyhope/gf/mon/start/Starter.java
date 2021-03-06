package org.greyhope.gf.mon.start;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.greyhope.gf.mon.gui.ConsoleMonitoring;
import org.greyhope.gf.mon.gui.DomainPanel;
import org.greyhope.gf.mon.gui.HostPanel;
import org.greyhope.gf.mon.gui.MainPanel;
import org.greyhope.gf.mon.gui.RamPanel;

import org.greyhope.gf.mon.properties.Properties;

import org.greyhope.gf.mon.tasks.ApplicationTask;
import org.greyhope.gf.mon.tasks.MemoryTask;

import org.greyhope.gf.mon.tree.Applications;
import org.greyhope.gf.mon.tree.Memory;

import org.greyhope.gf.mon.utils.Functions;

public final class Starter {

    // RAM Window Executor Scheduler Services
    private ScheduledExecutorService ramWindowTaskScheduler = null;
    private ScheduledExecutorService appWindowTaskScheduler = null;
    
    // Console GUI
    public static ConsoleMonitoring console;
    
    // Schedulers - to control polling
    public static ScheduledFuture<?> ramPollerTaskFuture;
    public static ScheduledFuture<?> appPollerTaskFuture;
    
    private static final Logger LOGGER = Logger.getLogger(Starter.class);
    
    private static final String SOFTWARE_DIR = "/gm/conf/";
    
    // Value Objects - Source Objects
    private Memory memory;
    private Applications applications;

    public Starter(Properties.CONNECTION connectionType) throws Exception {
        
        LOGGER.info("Glassfish monitoring started : " + new Date());

        // Create Main GUI Components (actually the components which are registered as listeners for data)
        HostPanel hostPanel = new HostPanel();
        DomainPanel domainPanel = new DomainPanel();
        RamPanel ramPanel = new RamPanel();
        
        MainPanel mainPanel = new MainPanel();
        
        // Create the Source Data objects for GUI Components
        memory = new Memory();
        applications = new Applications();
        
        // Set the listeners for Data Components
        memory.addFeatureListener(ramPanel);
        applications.addFeatureListener(mainPanel);
        
        // Setup the Services 
        ramWindowTaskScheduler = Executors.newScheduledThreadPool(Properties.THREADS);
        appWindowTaskScheduler = Executors.newScheduledThreadPool(Properties.THREADS);
        
        // Initialize the services
        initServices(connectionType);
        
        // Start the Console GUI
        console = new ConsoleMonitoring(connectionType,hostPanel,domainPanel,ramPanel,mainPanel);
        
    }
    
    public static void initLogging(){
        try {
            DOMConfigurator.configureAndWatch(SOFTWARE_DIR + "log4j.xml", 10000L);
        } catch (Exception domex) {
            System.out.println("Log4j Setup issue : " + domex.getMessage());
            System.exit(1);
        }

    }
   
    public void initServices(Properties.CONNECTION connectionType){
        
        // Start the Tasks
        initRAMService(connectionType);
        initAPPService(connectionType);
        
        System.out.println("Completed Service Setup");
        
    }

    private void initRAMService(Properties.CONNECTION connectionType) {
        
        System.out.println("Setting up RAM Service");
        Runnable clientTask = new MemoryTask(connectionType, Properties.BASE_URL.toString(), memory);
        ramPollerTaskFuture = ramWindowTaskScheduler.scheduleWithFixedDelay(clientTask, Properties.INITIAL_DELAY_POLLER_THREAD, Properties.INTERVAL_DELAY_POLLER_THREAD, TimeUnit.SECONDS);
    }

    private void initAPPService(Properties.CONNECTION connectionType) {
        
        System.out.println("Setting up APP Service");
        Runnable clientTask = new ApplicationTask(connectionType, Properties.BASE_URL.toString(), applications);
        appPollerTaskFuture = ramWindowTaskScheduler.scheduleWithFixedDelay(clientTask, Properties.INITIAL_DELAY_POLLER_THREAD, Properties.INTERVAL_DELAY_POLLER_THREAD, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {

        Properties.init();
        Functions.init();
        
        initLogging();

        try {
            Starter src = new Starter(Properties.appConnection);
        } catch (Exception t) {
            System.out.println("Exception whilst starting program : " + t.getMessage());
        }
    }
}
