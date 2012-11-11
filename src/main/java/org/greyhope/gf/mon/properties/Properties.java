package org.greyhope.gf.mon.properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

/**
 *
 * @author greyhope
 */
public class Properties {
    
    public enum CONNECTION{SSL,NON}
    
    private static PropertiesConfiguration properties;
    public static CONNECTION appConnection;
    
    public static String TRUSTSTORE;
    public static String TRUSTSTORE_PASSWORD;
    public static String KEYSTORE;
    public static String KEYSTORE_PASSWORD;
    public static StringBuilder BASE_URL;
    public static String APP_CONNECTION;
    public static int THREADS;
    
    public static String DOMAIN_USER;
    public static String DOMAIN_PASSWORD;
    
    public static int INITIAL_DELAY_POLLER_THREAD;
    public static int INTERVAL_DELAY_POLLER_THREAD;
    
    private static final int SSL = 1;
    private static final int NON_SSL = 0;
    
    public static void init() {

        try {
            properties = new PropertiesConfiguration("/gm/conf/settings.conf");
            properties.setDelimiterParsingDisabled(true);

            FileChangedReloadingStrategy strategy = new FileChangedReloadingStrategy();

            properties.setReloadingStrategy(strategy);
            properties.addConfigurationListener(new ConfigFileListener());
            
            TRUSTSTORE = properties.getString("truststore.path");
            TRUSTSTORE_PASSWORD = properties.getString("truststore.password");
            KEYSTORE = properties.getString("keystore.path");
            KEYSTORE_PASSWORD = properties.getString("keystore.password");
            APP_CONNECTION = properties.getString("app.connection");
            THREADS = properties.getInt("threads.number");
            INITIAL_DELAY_POLLER_THREAD = properties.getInt("initial.delay");
            INTERVAL_DELAY_POLLER_THREAD = properties.getInt("interval.delay");
            
            DOMAIN_USER = properties.getString("domain.user");
            DOMAIN_PASSWORD = properties.getString("domain.password");
            
            doConnectionType(APP_CONNECTION);
            
            String docBase = properties.getString("base.url");
            String unFormattedUrl = properties.getString("complete.url");
            String host = properties.getString("host");
            String port = properties.getString("port");
            String protocol = properties.getString("protocol");
            
            BASE_URL = new StringBuilder(String.format(unFormattedUrl,protocol,host,port,docBase).trim());
            
        } catch (ConfigurationException e) {
            
        }

    }
    
    private static void doConnectionType(String appType){
        
        int app = 0;
        if(appType.equals("SSL")){
            app = 1;
        }else{
            app =0;
        }
        
        switch(app){
            
            case SSL:
                appConnection = CONNECTION.SSL;
            break;
                
            case NON_SSL:
                appConnection = CONNECTION.NON;
            break;
                
            default :
                appConnection = CONNECTION.NON;
            break;    
            
        }
        
    }
    
}
