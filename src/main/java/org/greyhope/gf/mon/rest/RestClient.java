package org.greyhope.gf.mon.rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import java.util.List;
import org.greyhope.gf.mon.connection.DefaultConnection;
import org.greyhope.gf.mon.connection.MonitoringConnection;
import org.greyhope.gf.mon.connection.NonSSLConnection;
import org.greyhope.gf.mon.connection.SSLConnection;
import org.greyhope.gf.mon.properties.Properties;


/**
 *
 * @author greyhope
 */
public class RestClient {

    private ClientConfig config = new DefaultClientConfig();
    private Client client;
    private SSLConnection sslConnection;
    private WebResource webResource;
    private MonitoringConnection<DefaultConnection> mc;
    private List<String> keys;

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }
    
    public RestClient(Properties.CONNECTION connectionType) {

        switch (connectionType) {

            case SSL:
                System.out.println("SSL Connection");
                mc = new MonitoringConnection<DefaultConnection>(new SSLConnection());
                config.getProperties().put(com.sun.jersey.client.urlconnection.HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, new com.sun.jersey.client.urlconnection.HTTPSProperties(mc.getHostnameVerifier(), mc.getSSLContext()));
                break;

            case NON:
                System.out.println("NON SSL Connection");
                mc = new MonitoringConnection<DefaultConnection>(new NonSSLConnection());
                break;

            default:

                break;

        }

        client = Client.create(config);

    }
    
    public void setResource(String resource){
        
        webResource = client.resource(resource);
        setUsernamePassword(Properties.DOMAIN_USER, Properties.DOMAIN_PASSWORD);
    }

    public <T> T get_XML(Class<T> responseType) throws UniformInterfaceException {
        return webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T get_JSON(Class<T> responseType) throws UniformInterfaceException {
        return webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    private void setUsernamePassword(String username, String password) {
        client.addFilter(new HTTPBasicAuthFilter(username, password));
    }

    public void close() {
        client.destroy();
    }

}
