/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greyhope.gf.mon.framework;

/**
 *
 * @author greyhope
 */
public class FeatureEvent {
    
    private Feature feature;
    private String name;

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }
    
    public FeatureEvent(String name){
        this.name = name;
    }
    
}
