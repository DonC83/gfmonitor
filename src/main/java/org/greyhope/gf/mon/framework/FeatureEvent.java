/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greyhope.gf.mon.framework;

import java.util.List;
import org.greyhope.gf.mon.applications.Application;

/**
 *
 * @author greyhope
 */
public class FeatureEvent {
    
    private BaseFeature feature;
    private String name;
    private List<Application> apps;

    public List<Application> getApps() {
        return apps;
    }

    public void setApps(List<Application> apps) {
        this.apps = apps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public BaseFeature getFeature() {
        return feature;
    }

    public void setFeature(BaseFeature feature) {
        this.feature = feature;
    }
    
    public FeatureEvent(String name){
        this.name = name;
    }
    
}
