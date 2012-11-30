package org.greyhope.gf.mon.start;

import org.greyhope.gf.mon.gui.ConsoleMonitoring;
import org.greyhope.gf.mon.properties.Properties;
import org.greyhope.gf.mon.rest.RestClient;
import org.greyhope.gf.mon.utils.Functions;

public class Starter {
    
    private RestClient client = null;
    
    private static String monitoringResource = null;
    private static String resourceType = null;
    
    private ConsoleMonitoring console;
    
    public Starter(Properties.CONNECTION connectionType) throws Exception {
        
        console = new ConsoleMonitoring(connectionType);
        
    }
    
    public static void main(String[] args) {

        Properties.init();
        Functions.init();
        
        try {
            Starter src = new Starter(Properties.appConnection);
        } catch (Exception t) {
            System.out.println("Exception whilst starting program : " + t.getMessage());
        }
    }
    
}
