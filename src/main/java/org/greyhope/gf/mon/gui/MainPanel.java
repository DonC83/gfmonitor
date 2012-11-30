package org.greyhope.gf.mon.gui;

import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Table;
import com.googlecode.lanterna.terminal.TerminalSize;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.greyhope.gf.mon.properties.Properties;
import org.greyhope.gf.mon.tasks.ApplicationTask;
import org.greyhope.gf.mon.widgets.ApplicationList;

/**
 *
 * @author greyhope
 */
public class MainPanel extends Panel{
      
    // Executor Scheduler Services
    private ScheduledExecutorService mainWindowTaskScheduler = null;
    
    private ApplicationList appList;

    public ApplicationList getAppList() {
        return appList;
    }

    public void setAppList(ApplicationList appList) {
        this.appList = appList;
    }
    
    public MainPanel(){
        super("Overview",new Border.Bevel(true), Panel.Orientation.HORISONTAL);
        
        TerminalSize size = new TerminalSize(162,42);
        this.setPreferredSize(size);
        
        TerminalSize applicationTableSize = new TerminalSize(40,40);
        
        Table applicationTable = new Table(1,"Application Deployed");
        applicationTable.setPreferredSize(applicationTableSize);
        
        appList = new ApplicationList();
        
        applicationTable.addRow(appList);
        
        this.addComponent(applicationTable);
        
        mainWindowTaskScheduler = Executors.newScheduledThreadPool(Properties.THREADS);
        
        initService(ConsoleMonitoring.conn);
        
    }
    
    private void initService(Properties.CONNECTION connectionType){
         Runnable clientTask = new ApplicationTask(connectionType,Properties.BASE_URL.toString(), this);
         ScheduledFuture<?> pollerTaskFuture = mainWindowTaskScheduler.scheduleWithFixedDelay(clientTask, Properties.INITIAL_DELAY_POLLER_THREAD,Properties.INTERVAL_DELAY_POLLER_THREAD, TimeUnit.SECONDS);
    }
    
}
