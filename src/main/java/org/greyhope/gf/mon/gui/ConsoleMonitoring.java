package org.greyhope.gf.mon.gui;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

/**
 * @author greyhope
 */
public class ConsoleMonitoring {
    
    protected static Screen screen;
    protected static GUIScreen guiScreen;
    
    public ConsoleMonitoring(){
        screen = TerminalFacade.createScreen(new SwingTerminal());
        screen.startScreen();
        ConsoleMonitoring.guiScreen = TerminalFacade.createGUIScreen(screen);
        build();
    }
    
    private void build(){
        
        // Create the host window
        MainWindow mainWindow = new MainWindow();
        ConsoleMonitoring.guiScreen.showWindow(mainWindow, GUIScreen.Position.CENTER);
        
    }
   
}
