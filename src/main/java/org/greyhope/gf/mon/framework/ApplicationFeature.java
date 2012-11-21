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
public class ApplicationFeature extends ListenerComponent{
    
    private List<Application> apps;
    
    public synchronized void fireEvent(FeatureEvent f){
        for(FeatureListener ft : getFeatureListener()){
            ft.featureChanged(f);
        }
    }
    
}
