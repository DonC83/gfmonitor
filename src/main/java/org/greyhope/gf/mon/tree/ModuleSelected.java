/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greyhope.gf.mon.tree;

import org.greyhope.gf.mon.framework.FeatureEvent;
import org.greyhope.gf.mon.framework.SelectedComponent;
import org.greyhope.gf.mon.framework.SelectedListener;

/**
 *
 * @author greyhope
 */
public class ModuleSelected extends SelectedComponent{
    
    private String selected;

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }
    
    public ModuleSelected(){
        super();
    }
    
    public void fireEvent(){
        for(SelectedListener f : getSelectedListener()){
            f.selectedChanged(new FeatureEvent("Module",selected));
        }
    }
    
}
