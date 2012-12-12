package org.greyhope.gf.mon.gui;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.dialog.ActionListDialog;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author greyhope
 */
public class MyListSelectDialog {
    
    private MyListSelectDialog() {}
    
    public static <T> T showDialog(final GUIScreen owner, final String title,
            final String description, final T... items)
    {
        return showDialog(owner, title, description, 0, items);
    }

    /**
     * Presents the user with a dialog where a list of items is displayed and
     * the user can select one of the items.
     *
     * @param owner GUIScreen to draw the dialog on
     * @param title Title of the dialog
     * @param description Text describing the dialog and the list
     * @param listWidth Width of the list, in columns
     * @param items Items to show in the list
     * @return The item the user chose
     */
    public static <T> T showDialog(final GUIScreen owner, final String title,
            final String description, final int listWidth, final T... items)
    {
        final List<T> result = new ArrayList<T>();
        Action []actionItems = new Action[items.length];
        for(int i = 0; i < items.length; i++) {
            final T item = items[i];
            actionItems[i] = new Action() {
                @Override
                public void doAction()
                {
                    result.add(item);
                }

                @Override
                public String toString() {
                    return item.toString();
                }
            };
        }
        
        int rows = items.length;

        MyActionListDialog.showActionListDialog(owner, title, description, listWidth, rows ,actionItems);
        if(result.isEmpty())
            return null;
        else
            return result.get(0);
    }
    
}
