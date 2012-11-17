package org.greyhope.gf.mon.tasks;

import java.io.IOException;
import java.util.List;
import org.greyhope.gf.mon.builder.JDomReader;
import org.greyhope.gf.mon.framework.Feature;
import org.greyhope.gf.mon.framework.FeatureEvent;
import org.greyhope.gf.mon.listeners.Widget;
import org.greyhope.gf.mon.properties.Properties;
import org.greyhope.gf.mon.properties.Properties.CONNECTION;
import org.greyhope.gf.mon.lists.MonitoringStack;
import org.greyhope.gf.mon.rest.RestClient;
import org.greyhope.gf.mon.tree.ConnectionQueue;
import org.jdom2.JDOMException;

/**
 *
 * @author greyhope
 */
public class ConnectionQueueTask implements Runnable{
    
    private RestClient client;
    private String name;
    private CONNECTION connType;
    private String baseURL;
    private String resource;
    
    public ConnectionQueueTask(Properties.CONNECTION connectionType, String baseUrl){
        connType = connectionType;
        client = new RestClient(connType);
        baseURL = baseUrl;
        resource = new String();
    }

    @Override
    public void run() {
        
        //System.out.println("Running task : " + this);
        
        // Set the resource
        resource = baseURL.concat(MonitoringStack.pop()).concat(".xml");
        //System.out.println("Resource : " + resource);
        client.setResource(resource);
        
        String response = client.get_XML(String.class);
        //System.out.println("XML Response : " + response);
        
        List<Feature> allFeatures;
        
        Widget formWidget = new Widget();
        
        try {
            allFeatures = JDomReader.performFeature(ConnectionQueue.class, response);
            
            for(Feature f : allFeatures){
                f.addFeatureListener(formWidget);
                
                FeatureEvent changeEvent = new FeatureEvent(ConnectionQueue.URL);
                changeEvent.setFeature(f);
                
                f.fireEvent(changeEvent);
            }
            
        } catch (JDOMException ex) {
            System.err.println("Exception Response : " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Exception Response : " + ex.getMessage());
        } catch (NoSuchMethodException ex) {
            System.err.println("Exception Response : " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.err.println("Exception Response : " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.err.println("Exception Response : " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Exception Response : " + ex.getMessage());
        }finally{
            MonitoringStack.push(ConnectionQueue.URL);
        }
        
    }
    
}
