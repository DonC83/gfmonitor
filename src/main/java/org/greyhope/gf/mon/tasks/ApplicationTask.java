package org.greyhope.gf.mon.tasks;

import java.io.IOException;
import java.util.List;
import org.greyhope.gf.mon.builder.JDomReader;
import org.greyhope.gf.mon.gui.MainPanel;
import org.greyhope.gf.mon.properties.Properties;
import org.greyhope.gf.mon.properties.Properties.CONNECTION;
import org.greyhope.gf.mon.rest.RestClient;
import org.greyhope.gf.mon.tree.Applications;
import org.greyhope.gf.mon.widgets.ComponentAction;
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
    private MainPanel panel;
    
    public ApplicationTask(Properties.CONNECTION connectionType, String baseUrl,MainPanel panel){
        connType = connectionType;
        client = new RestClient(connType);
        baseURL = baseUrl;
        resource = new String();
        this.panel = panel;
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
            
            int selected = panel.getAppList().getSelectedIndex();
            
            panel.getAppList().clearItems();
            
            //System.out.println("Selected : " + selected);
            int count = 1;
            
            for(String s : allApplications){
                panel.getAppList().addAction(count + ". " + s, new ComponentAction());
                count++;
            }
            
            if(selected == -1){
                panel.getAppList().setSelectedItem(0);
            }else{
                panel.getAppList().setSelectedItem(selected);
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
        }
    }
    
}
