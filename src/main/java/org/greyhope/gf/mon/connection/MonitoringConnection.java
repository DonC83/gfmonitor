package org.greyhope.gf.mon.connection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

/**
 *
 * @author greyhope
 */
public class MonitoringConnection<T extends DefaultConnection>{

   private T connection;
   
   public MonitoringConnection(T connection){
       this.connection = connection;
   }
   
   public void prepare(){
       connection.prepareConnection();
   }
   
   public SSLContext getSSLContext() {
       return connection.getSSLContext();
   }
   
   public HostnameVerifier getHostnameVerifier() {
       return connection.getHostnameVerifier();
   } 
    
}
