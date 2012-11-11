package org.greyhope.gf.mon.connection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.greyhope.gf.mon.utils.SecureConnectionKeyManager;
import org.greyhope.gf.mon.utils.SecureConnectionTrustManager;
import org.greyhope.gf.mon.properties.Properties;

/**
 *
 * @author greyhope
 */
public class SSLConnection implements DefaultConnection{
    
    public SSLConnection() {
    }
    
    @Override
    public void prepareConnection(){
        System.out.println("Preparing SSL Connection");
    }
    
    @Override
    public HostnameVerifier getHostnameVerifier() {
        return new HostnameVerifier() {

            @Override
            public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
                return true;
            }
        };
    }
    
    public SSLContext getSSLContext() {
        TrustManager mytm[] = null;
        KeyManager mykm[] = null;

        try {
            mytm = new TrustManager[]{new SecureConnectionTrustManager(Properties.TRUSTSTORE, Properties.TRUSTSTORE_PASSWORD.toCharArray())};
            mykm = new KeyManager[]{new SecureConnectionKeyManager(Properties.KEYSTORE, Properties.KEYSTORE_PASSWORD.toCharArray())};
        } catch (Exception ex) {
            System.out.println("Exception creating Trust / Key Managers : " + ex.getMessage());
        }

        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("SSL");
            ctx.init(mykm, mytm, null);
        } catch (java.security.GeneralSecurityException ex) {
            System.out.println("GeneralSecurityException getting instance of SSLContext : " + ex.getMessage());
        }
        return ctx;
    }
    
}
