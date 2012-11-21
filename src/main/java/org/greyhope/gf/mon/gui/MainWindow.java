package org.greyhope.gf.mon.gui;

import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.terminal.TerminalSize;
import org.greyhope.gf.mon.properties.Properties;

/**
 *
 * @author greyhope
 */
public class MainWindow extends Window{
    
    public MainWindow(Properties.CONNECTION connectionType){
        super("");
        
        TerminalSize size = new TerminalSize(170,62);
        super.setWindowSizeOverride(size);
        
        Panel statusPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
        
        HostPanel hostPanel = new HostPanel();
        DomainPanel domainPanel = new DomainPanel();
        RamPanel ramPanel = new RamPanel();

        statusPanel.addComponent(hostPanel);
        statusPanel.addComponent(domainPanel);
        statusPanel.addComponent(ramPanel);
        
        Panel middlePanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
        MainPanel mainPanel = new MainPanel();
        middlePanel.addComponent(mainPanel);
        
        Panel lowerPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
        ControlPanel controlPanel = new ControlPanel();
        lowerPanel.addComponent(controlPanel);
        
        addComponent(statusPanel);
        addComponent(middlePanel);
        addComponent(lowerPanel);
        
    }
    
}
