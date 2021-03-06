package org.greyhope.gf.mon.gui;

import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Theme.Category;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
import org.greyhope.gf.mon.properties.Properties;

/**
 * @author greyhope
 */
public class HostPanel extends Panel{
    
    public HostPanel(){
        // Set the title
      super("Glassfish",new Border.Bevel(true), Panel.Orientation.HORISONTAL);
      
      TerminalSize size = new TerminalSize(65,3);
      this.setPreferredSize(size);
      
      // Set the Host panel
      addComponent(new Label("Host : ", Terminal.Color.BLACK, true));
      Label hostName = new Label(Properties.HOST,15);
      hostName.setStyle(Category.TEXTBOX);
      addComponent(hostName);
      
      // Set the Port panel 
      addComponent(new Label("Port : ", Terminal.Color.BLACK, true));
      Label hostPort = new Label(String.valueOf(Properties.PORT),4);
      hostPort.setStyle(Category.TEXTBOX);
      addComponent(hostPort);
      
      // Set the Status panel 
      addComponent(new Label("Status : ", Terminal.Color.BLACK, true));
      Label hostStatus = new Label("Disonnected",13);
      hostStatus.setStyle(Category.TEXTBOX);
      addComponent(hostStatus);
      
    }
}
