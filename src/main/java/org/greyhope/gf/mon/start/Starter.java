package org.greyhope.gf.mon.start;

import org.greyhope.gf.mon.listeners.Widget;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greyhope.gf.mon.framework.Feature;
import org.greyhope.gf.mon.properties.Properties;
import org.greyhope.gf.mon.rest.RestClient;

public class Starter {
    
    RestClient client = null;
    
    private static String monitoringResource = null;
    private static String resourceType = null;
    private Widget widget;

    public Starter(Properties.CONNECTION connectionType) throws Exception {
        
       ExecutorService execService = Executors.newFixedThreadPool(Properties.THREADS);

       client = new RestClient(connectionType);
       client.setResource(Properties.BASE_URL.toString());
       
       String response = client.get_XML(String.class);
       
       System.out.println("XML Response : " + response);
       
       // Setting the Feature Listeners (completely wrong to put this... just testing)
       widget = new Widget();
       
       Feature jvm = new Feature("jvm");
       
       jvm.addFeatureListener(widget);
       
    }
    
    public static void main(String[] args) {

        Properties.init();
        
        if(args.length == 0){
            System.out.println("Usage : java -jar glassfish-monitoring-1.0.jar [xml] [url-resource]");
            System.out.println("No Resource to monitor, will exit.");
            System.exit(1);
        }else{
            monitoringResource = args[1].trim();
            resourceType = args[0].trim();
            System.out.println("Monitoring Resource : " + monitoringResource);
            Properties.BASE_URL.append(monitoringResource).append(".").append(resourceType);
            System.out.println("Resource URL : " + Properties.BASE_URL.toString());
        }
        
        try {
            Starter src = new Starter(Properties.appConnection);
        } catch (Exception t) {
            System.out.println("Exception whilst starting program : " + t.getMessage());
        }
    }
    
    
}
