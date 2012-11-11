package org.greyhope.gf.mon.connection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

/**
 * 
 * @author greyhope
 */
public interface DefaultConnection {
    
    public void prepareConnection();
    
    public SSLContext getSSLContext();
    
    public HostnameVerifier getHostnameVerifier();
    
}
