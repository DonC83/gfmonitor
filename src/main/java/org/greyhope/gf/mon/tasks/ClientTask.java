package org.greyhope.gf.mon.tasks;

import org.greyhope.gf.mon.properties.Properties;
import org.greyhope.gf.mon.properties.Properties.CONNECTION;
import org.greyhope.gf.mon.rest.RestClient;

/**
 *
 * @author greyhope
 */
public class ClientTask implements Runnable{
    
    private RestClient client;
    private String name;
    private CONNECTION connType;
    
    public ClientTask(Properties.CONNECTION connectionType){
        connType = connectionType;
    }

    @Override
    public void run() {
        
        
        
    }
    
}
