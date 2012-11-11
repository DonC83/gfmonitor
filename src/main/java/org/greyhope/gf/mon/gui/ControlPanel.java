package org.greyhope.gf.mon.gui;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.dialog.ActionListDialog;
import com.googlecode.lanterna.terminal.TerminalSize;

/**
 *
 * @author greyhope
 */
public class ControlPanel extends Panel{
    
     public ControlPanel(){
        super("",new Border.Bevel(true), Panel.Orientation.HORISONTAL);
        
        TerminalSize size = new TerminalSize(160,3);
        this.setPreferredSize(size);
        
        // Exit Button
        addComponent(new Button("Exit", new Action() {
                @Override
                public void doAction() {
                    
                    ActionListDialog.showActionListDialog(ConsoleMonitoring.guiScreen, "Message", "Press enter to exit or select close to cancel.", new Action(){

                    @Override
                    public void doAction() {
                        System.exit(1);
                    }
                        
                    });
                }
            }));
     
        addComponent(new Button("Reconnect", new Action() {
                @Override
                public void doAction() {
                    
                }
            }));
        
    }
}
