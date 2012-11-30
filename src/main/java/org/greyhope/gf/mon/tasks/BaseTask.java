/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greyhope.gf.mon.tasks;

import org.greyhope.gf.mon.properties.Properties.CONNECTION;
import org.greyhope.gf.mon.rest.RestClient;

/**
 *
 * @author greyhope
 */
public class BaseTask {
    
    private RestClient client;
    private String name;
    private CONNECTION connType;
    private String baseURL;
    private String resource;
    public final static String SET = "set_";

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public RestClient getClient() {
        return client;
    }

    public void setClient(RestClient client) {
        this.client = client;
    }

    public CONNECTION getConnType() {
        return connType;
    }

    public void setConnType(CONNECTION connType) {
        this.connType = connType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
    
}
