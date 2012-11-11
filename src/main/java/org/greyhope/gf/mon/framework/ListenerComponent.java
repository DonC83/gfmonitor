package org.greyhope.gf.mon.framework;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author greyhope
 */
public class ListenerComponent {
    
    private Set<FeatureListener> featureListener;

    public Set<FeatureListener> getFeatureListener() {
        return featureListener;
    }

    public void setFeatureListener(Set<FeatureListener> featureListener) {
        this.featureListener = featureListener;
    }
    
    public ListenerComponent(){
        featureListener = new HashSet<FeatureListener>();
    }
    
    public synchronized void addFeatureListener(FeatureListener f){
        featureListener.add(f);
    }
    
    public synchronized void removeFeatureListener(FeatureListener f){
        featureListener.remove(f);
    }
    
}
