package org.greyhope.gf.mon.widgets;

import org.greyhope.gf.mon.gui.ConsoleMonitoring;
import org.greyhope.gf.mon.gui.MyListSelectDialog;
import org.greyhope.gf.mon.properties.Properties;
import org.greyhope.gf.mon.tasks.ModuleTask;
import org.greyhope.gf.mon.tree.DeployedApplication;
import org.greyhope.gf.mon.tree.ModuleSelected;

/**
 * @author greyhope
 */

public class ApplicationComponentAction extends ComponentAction {

    private DeployedApplication deployedApplication;
    private String appName;
    private ModuleSelected moduleSelected;

    public ApplicationComponentAction(String appName, ModuleSelected moduleSelected) {
        super();
        deployedApplication = new DeployedApplication(appName);
        this.appName = appName;
        this.moduleSelected = moduleSelected;
    }

    @Override
    public void doAction() {

        // Pause the current Application Poller until this action is complete

        try {
            // Start a task to get all modules in applications and their respective actions
            ModuleTask moduleTask = new ModuleTask(Properties.appConnection, Properties.BASE_URL.toString(), deployedApplication, appName);
            moduleTask.run();
            //Starter.appPollerTaskFuture.wait();
            // Make a listing of actions 
            String[] items;
            
            items = moduleTask.getAllApplications().toArray(new String[moduleTask.getAllApplications().size()]);
            
            String[] emptyList = new String[]{new String()};
            
            String result = MyListSelectDialog.showDialog(ConsoleMonitoring.guiScreen, "Modules", "For application : " + appName,100, items);
            
            if(result != null){
                moduleSelected.setSelected(result);
                moduleSelected.fireEvent();
            }

        } catch (Exception e) {
            System.out.println("Paused the application poller failed : " + e.getMessage());
        }
    }
}
