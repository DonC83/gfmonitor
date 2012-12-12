/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greyhope.gf.mon.gui;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border.Invisible;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.ActionListBox;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.terminal.TerminalSize;

/**
 *
 * @author greyhope
 */
public class MyActionListDialog extends Window
{
    private final ActionListBox actionListBox;

    private MyActionListDialog(String title, String description, int actionListBoxWidth, int maxRows) {
        super(title);
        
        if(description != null){
            addComponent(new Label(description));
        }
        
        actionListBox = new ActionListBox(new TerminalSize(actionListBoxWidth, maxRows));
        addComponent(actionListBox);
        Panel cancelPanel = new Panel(new Invisible(), Panel.Orientation.HORISONTAL);
        cancelPanel.addComponent(new Label("                "));
        cancelPanel.addComponent(new Button("Close", new Action() {
            @Override
            public void doAction()
            {
                close();
            }
        }));
        addComponent(cancelPanel);
    }

    private void addAction(final String title, final Action action) {
        actionListBox.addAction(title, new Action() {
            @Override
            public void doAction() {
                action.doAction();
                close();
            }
        });
        actionListBox.setPreferredSize(new TerminalSize(actionListBox.getPreferredSize().getColumns(),
                                                        actionListBox.getPreferredSize().getRows() + 1));
    }

    /**
     * Will display a dialog prompting the user to select an action from a list.
     * The label of each action will be the result of calling toString() on each
     * Action object.
     */
    public static void showActionListDialog(GUIScreen owner, String title, String description, Action... actions)
    {
        int maxLength = 0;
        int maxRows = actions.length;
        for(Action action: actions)
            if(action.toString().length() > maxLength)
                maxLength = action.toString().length();
        
        showActionListDialog(owner, title, description, maxLength, maxRows,actions);
    }

    /**
     * Will display a dialog prompting the user to select an action from a list.
     * The label of each action will be the result of calling toString() on each
     * Action object.
     */
    public static void showActionListDialog(GUIScreen owner, String title, String description, int itemWidth,int itemRows, Action... actions)
    {
        //Autodetect width?
        if(itemWidth == 0) {
            showActionListDialog(owner, title, description, actions);
            return;
        }
        
        MyActionListDialog actionListDialog = new MyActionListDialog(title, description, itemWidth, itemRows);
        for(Action action: actions)
            actionListDialog.addAction(action.toString(), action);
        owner.showWindow(actionListDialog, GUIScreen.Position.CENTER);
    }
}