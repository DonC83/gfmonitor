package org.greyhope.gf.mon.gui;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;
import org.greyhope.gf.mon.properties.Properties;

/**
 * @author greyhope
 */
public class ConsoleMonitoring {
    
    protected static Screen screen;
    protected static GUIScreen guiScreen;
    private MainWindow mainWindow;
    public static Properties.CONNECTION conn;

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    
    public ConsoleMonitoring(Properties.CONNECTION connectionType){
        screen = TerminalFacade.createScreen(new SwingTerminal());
        screen.startScreen();
        ConsoleMonitoring.guiScreen = TerminalFacade.createGUIScreen(screen);
        ConsoleMonitoring.conn = connectionType;
        build();
    }
    
    private void build(){
        
        // Create the host window
        mainWindow = new MainWindow(conn);
        ConsoleMonitoring.guiScreen.showWindow(mainWindow, GUIScreen.Position.CENTER);
        
    }
   
}
