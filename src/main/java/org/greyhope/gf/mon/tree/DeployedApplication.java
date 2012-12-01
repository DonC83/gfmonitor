package org.greyhope.gf.mon.tree;

import java.util.List;
import org.greyhope.gf.mon.applications.Application;
import org.greyhope.gf.mon.applications.ApplicationModule;
import org.greyhope.gf.mon.applications.Module;
import org.greyhope.gf.mon.framework.FeatureEvent;
import org.greyhope.gf.mon.framework.FeatureListener;
import org.greyhope.gf.mon.framework.ListenerComponent;

/**
 *
 * @author greyhope
 */
public class DeployedApplication extends ListenerComponent implements Application{
    
    public static final String URL = "server/applications/%";
    public static final String XPATH = "//entry/map/entry/map/*";
    
    List<Module<ApplicationModule>> applicationModules;
    private String serviceName;

    public DeployedApplication(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    
    @Override
    public List<Module<ApplicationModule>> getModules() {
        return applicationModules;
    }
    
    public void fireEvent(){
        for(FeatureListener f : getFeatureListener()){
            f.featureChanged(new FeatureEvent(this,"DeployedApplication"));
        }
    }
    
}
