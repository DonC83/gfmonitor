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
    
    private Object feature;
    private String name;

    public FeatureEvent(Object feature, String name) {
        this.feature = feature;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Object getFeature() {
        return feature;
    }

    public void setFeature(Object feature) {
        this.feature = feature;
    }
    
    public FeatureEvent(String name){
        this.name = name;
    }
    
}
