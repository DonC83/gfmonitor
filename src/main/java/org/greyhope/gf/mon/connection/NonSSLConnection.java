package org.greyhope.gf.mon.connection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

/**
 *
 * @author greyhope
 */
public class NonSSLConnection implements DefaultConnection{
    
    @Override
    public void prepareConnection(){
        System.out.println("Preparing Non Connection");
    }

    @Override
    public SSLContext getSSLContext() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public HostnameVerifier getHostnameVerifier() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
