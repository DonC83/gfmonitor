/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greyhope.gf.mon.framework;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author greyhope
 */
public class SelectedComponent {
    
    private Set<SelectedListener> selectedListener;

    public Set<SelectedListener> getSelectedListener() {
        return selectedListener;
    }

    public void setSelectedListener(Set<SelectedListener> featureListener) {
        this.selectedListener = featureListener;
    }
    
    public SelectedComponent(){
        selectedListener = new HashSet<SelectedListener>();
    }
    
    public synchronized void addSelectedListener(SelectedListener f){
        selectedListener.add(f);
    }
    
    public synchronized void removeSelectedListener(SelectedListener f){
        selectedListener.remove(f);
    }
    
}
