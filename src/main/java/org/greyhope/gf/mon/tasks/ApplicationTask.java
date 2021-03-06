package org.greyhope.gf.mon.tasks;

import java.io.IOException;
import java.util.List;
import org.greyhope.gf.mon.builder.JDomReader;
import org.greyhope.gf.mon.properties.Properties;
import org.greyhope.gf.mon.properties.Properties.CONNECTION;
import org.greyhope.gf.mon.rest.RestClient;
import org.greyhope.gf.mon.tree.Applications;
import org.jdom2.JDOMException;

/**
 *
 * @author greyhope
 */
public class ApplicationTask implements Runnable{
    
    private RestClient client;
    private String name;
    private CONNECTION connType;
    private String baseURL;
    private String resource;
    private Applications applications;
    
    public ApplicationTask(Properties.CONNECTION connectionType, String baseUrl,Applications applications){
        connType = connectionType;
        client = new RestClient(connType);
        baseURL = baseUrl;
        resource = new String();
        this.applications = applications;
    }

    @Override
    public void run() {
        
        // Set the resource
        resource = baseURL.concat(Applications.URL).concat(".xml");
        //System.out.println("Resource : " + resource);
        client.setResource(resource);
        
        String response = client.get_XML(String.class);
        //System.out.println("XML Response : " + response);
        
        List<String> allApplications;
        
        try {
            allApplications =  JDomReader.getStringList(response, Applications.XPATH);
            
            applications.setApplications(allApplications);
            
            // System.out.println("Applications count : " + allApplications.size());
            
            applications.fireEvent();
            
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
        }
    }
    
}
