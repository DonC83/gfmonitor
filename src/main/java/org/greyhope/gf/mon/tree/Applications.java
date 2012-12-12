package org.greyhope.gf.mon.tree;

import java.util.List;
import org.greyhope.gf.mon.framework.FeatureEvent;
import org.greyhope.gf.mon.framework.FeatureListener;
import org.greyhope.gf.mon.framework.ListenerComponent;

/**
 *
 * @author greyhope
 */
public class Applications extends ListenerComponent{
    
    public static final String URL = "server/applications";
    public static final String XPATH = "//entry/map/entry/map/*";
    
    private List<String> applications;

    public Applications() {
        super();
    }

    public List<String> getApplications() {
        return applications;
    }

    public void setApplications(List<String> applications) {
        this.applications = applications;
    }
    
    public void fireEvent(){
        for(FeatureListener f : getFeatureListener()){
            f.featureChanged(new FeatureEvent(this,"Applications"));
        }
    }
    
}
