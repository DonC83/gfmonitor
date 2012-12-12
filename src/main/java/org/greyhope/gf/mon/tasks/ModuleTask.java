package org.greyhope.gf.mon.tasks;

import java.io.IOException;
import java.util.List;
import org.greyhope.gf.mon.builder.JDomReader;
import org.greyhope.gf.mon.properties.Properties;
import org.greyhope.gf.mon.properties.Properties.CONNECTION;
import org.greyhope.gf.mon.rest.RestClient;
import org.greyhope.gf.mon.tree.DeployedApplication;
import org.jdom2.JDOMException;

/**
 *
 * @author greyhope
 */
public class ModuleTask{
    
    private RestClient client;
    private String name;
    private CONNECTION connType;
    private String baseURL;
    private String resource;
    private DeployedApplication applicationModules;
    private List<String> allApplications;
    private String appName;
    
    public ModuleTask(Properties.CONNECTION connectionType, String baseUrl,DeployedApplication applicationModules, String appName){
        connType = connectionType;
        client = new RestClient(connType);
        baseURL = baseUrl;
        resource = new String();
        this.applicationModules = applicationModules;
        this.appName = appName;
    }

    public List<String> getAllApplications() {
        return allApplications;
    }

    public void setAllApplications(List<String> allApplications) {
        this.allApplications = allApplications;
    }
    
    public void run() {
        
        // Set the resource
        resource = baseURL.concat(DeployedApplication.URL.replaceAll("%", appName)).concat(".xml");
        //System.out.println("Resource : " + resource);
        client.setResource(resource);
        
        String response = client.get_XML(String.class);
        //System.out.println("XML Response : " + response);
        
        try {
            allApplications =  JDomReader.getStringList(response, DeployedApplication.XPATH);
            
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
