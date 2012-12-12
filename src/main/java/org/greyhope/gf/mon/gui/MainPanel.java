package org.greyhope.gf.mon.gui;

import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Table;
import com.googlecode.lanterna.terminal.TerminalSize;
import org.greyhope.gf.mon.framework.FeatureEvent;
import org.greyhope.gf.mon.framework.MemoryFeatureListener;
import org.greyhope.gf.mon.framework.SelectedListener;
import org.greyhope.gf.mon.tree.Applications;
import org.greyhope.gf.mon.tree.ModuleSelected;
import org.greyhope.gf.mon.widgets.ApplicationComponentAction;
import org.greyhope.gf.mon.widgets.ApplicationList;

/**
 *
 * @author greyhope
 */
public class MainPanel extends Panel implements MemoryFeatureListener,SelectedListener {

    private ApplicationList appList;
    private Applications applications;
    public ModuleSelected selectedModule;
    private Table statsTable;
    private Table detailsTable;
    
    public ApplicationList getAppList() {
        return appList;
    }

    public void setAppList(ApplicationList appList) {
        this.appList = appList;
    }

    public MainPanel() {
        super("Overview", new Border.Bevel(true), Panel.Orientation.HORISONTAL);
        
        selectedModule = new ModuleSelected();
        selectedModule.addSelectedListener(this);
        
        // Size of Applications Window
        TerminalSize size = new TerminalSize(162, 42);
        this.setPreferredSize(size);

        // The Deployed Applications Table
        TerminalSize applicationTableSize = new TerminalSize(40, 40);
        Table applicationTable = new Table(1, "Application Deployed");
        applicationTable.setPreferredSize(applicationTableSize);

        // The Module Count Statistics
        TerminalSize countStatsTableSize = new TerminalSize(50, 40);
        statsTable = new Table(1, "Module Statistics");
        statsTable.setPreferredSize(countStatsTableSize);
        
        // The Module Activities
        
        // Module Details
        TerminalSize detailsTableSize = new TerminalSize(65, 40);
        detailsTable = new Table(1, "Module Details");
        detailsTable.setPreferredSize(detailsTableSize);
        
        appList = new ApplicationList();

        applicationTable.addRow(appList);

        this.addComponent(applicationTable);
        this.addComponent(statsTable);
        this.addComponent(detailsTable);

    }

    @Override
    public void featureChanged(FeatureEvent e) {

        applications = (Applications) e.getFeature();

        // Get the selected item
        int selected = this.getAppList().getSelectedIndex();

        // Clear the panel of all the deployed apps
        this.getAppList().clearItems();

        // An integer count value, purely for display purposes
        int count = 1;

        for (String s : applications.getApplications()) {
            this.getAppList().addAction(count + ". " + s, new ApplicationComponentAction(s,selectedModule));
            count++;
        }

        // If nothing was selected then set the selector bar to the first item
        if (selected == -1) {
            this.getAppList().setSelectedItem(0);
        } else {
            // Set the selected item to be selected
            this.getAppList().setSelectedItem(selected);
        }
    }

    @Override
    public void selectedChanged(FeatureEvent e) {
        System.out.println("Module Selected : " + e.getName());
    }
}
