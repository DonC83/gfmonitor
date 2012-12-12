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
    
    HostPanel hostPanel;
    DomainPanel domainPanel;
    RamPanel ramPanel;
    
    public MainWindow(Properties.CONNECTION connectionType,HostPanel h,DomainPanel d,RamPanel r, MainPanel m){
        super("");
        
        TerminalSize size = new TerminalSize(170,62);
        super.setWindowSizeOverride(size);
        
        Panel statusPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
        
        hostPanel = h;
        domainPanel = d;
        ramPanel = r;

        statusPanel.addComponent(hostPanel);
        statusPanel.addComponent(domainPanel);
        statusPanel.addComponent(ramPanel);
        
        Panel middlePanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
        middlePanel.addComponent(m);
        
        Panel lowerPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
        ControlPanel controlPanel = new ControlPanel();
        lowerPanel.addComponent(controlPanel);
        
        addComponent(statusPanel);
        addComponent(middlePanel);
        addComponent(lowerPanel);
        
    }
    
}