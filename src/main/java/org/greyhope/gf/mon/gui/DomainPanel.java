package org.greyhope.gf.mon.gui;

import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Theme.Category;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
import org.greyhope.gf.mon.properties.Properties;

/**
 *
 * @author greyhope
 */
public class DomainPanel extends Panel{
    
    public DomainPanel(){
        
      super("Domain",new Border.Bevel(true), Panel.Orientation.HORISONTAL);
       
      TerminalSize size = new TerminalSize(42,3);
      this.setPreferredSize(size);
      
      // Set the Host panel
      addComponent(new Label("Name : ", Terminal.Color.BLACK, true));
      Label domainName = new Label(Properties.DOMAIN,12);
      domainName.setStyle(Category.TEXTBOX);
      addComponent(domainName);
      
      // Set the Port panel 
      addComponent(new Label("User : ", Terminal.Color.BLACK, true));
      Label domainUser = new Label(Properties.DOMAIN_USER,10);
      domainUser.setStyle(Category.TEXTBOX);
      addComponent(domainUser);
      
    }
    
}
