package org.greyhope.gf.mon.gui;

import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.terminal.TerminalSize;

/**
 *
 * @author greyhope
 */
public class MainPanel extends Panel{
    
    public MainPanel(){
        super("Overview",new Border.Bevel(true), Panel.Orientation.HORISONTAL);
        
        TerminalSize size = new TerminalSize(162,42);
        this.setPreferredSize(size);
        
    }
    
}
