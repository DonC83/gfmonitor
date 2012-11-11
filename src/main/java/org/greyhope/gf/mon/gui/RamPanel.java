package org.greyhope.gf.mon.gui;

import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Theme.Category;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

/**
 *
 * @author greyhope
 */
public class RamPanel extends Panel{
    
    public RamPanel(){
      super("RAM",new Border.Bevel(true), Panel.Orientation.HORISONTAL);
      
      TerminalSize size = new TerminalSize(51,3);
      this.setPreferredSize(size);
      
      // Set the Host Label
      addComponent(new Label("Allocated : ", Terminal.Color.BLACK, true));
      Label ramAlloc = new Label("4,5",4);
      ramAlloc.setStyle(Category.TEXTBOX);
      addComponent(ramAlloc);
      
      // Set the Port Label 
      addComponent(new Label("Used : ", Terminal.Color.BLACK, true));
      Label ramUsed = new Label("1,5",4);
      ramUsed.setStyle(Category.TEXTBOX);
      addComponent(ramUsed);
      
      // Set the Port Label 
      addComponent(new Label("Free : ", Terminal.Color.BLACK, true));
      Label ramFree = new Label("3,0",4);
      ramFree.setStyle(Category.TEXTBOX);
      addComponent(ramFree);
      
    }
    
}
