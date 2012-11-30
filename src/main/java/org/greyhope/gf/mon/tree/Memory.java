package org.greyhope.gf.mon.tree;

import org.greyhope.gf.mon.framework.BaseFeature;
import org.greyhope.gf.mon.framework.FeatureEvent;
import org.greyhope.gf.mon.framework.FeatureListener;
import org.greyhope.gf.mon.framework.ListenerComponent;

/**
 *
 * @author greyhope
 */
public class Memory extends ListenerComponent{
    
    public static final String URL = "server/jvm/memory";
    public static final String XPATH = "//entry/map/entry/map/entry[@key='%']/map/*";
    
    private BaseFeature committedheapsize_count;
    private BaseFeature committednonheapsize_count;
    private BaseFeature initheapsize_count;
    private BaseFeature initnonheapsize_count;
    private BaseFeature maxheapsize_count;
    private BaseFeature maxnonheapsize_count;
    private BaseFeature objectpendingfinalizationcount_count;
    private BaseFeature usedheapsize_count;
    private BaseFeature usednonheapsize_count;

    public Memory() {
        super();
    }
    
    public void fireEvent(){
        for(FeatureListener f : getFeatureListener()){
            f.featureChanged(new FeatureEvent(this,"Memory"));
        }
    }
    
    public BaseFeature get_committedheapsize_count(){
        return committedheapsize_count;
    }

    public void set_committedheapsize_count(BaseFeature committedheapsize_count) {
        this.committedheapsize_count = committedheapsize_count;
    }

    public BaseFeature get_committednonheapsize_count() {
        return committednonheapsize_count;
    }

    public void set_committednonheapsize_count(BaseFeature committednonheapsize_count) {
        this.committednonheapsize_count = committednonheapsize_count;
    }

    public BaseFeature get_initheapsize_count() {
        return initheapsize_count;
    }

    public void set_initheapsize_count(BaseFeature initheapsize_count) {
        this.initheapsize_count = initheapsize_count;
    }

    public BaseFeature get_initnonheapsize_count() {
        return initnonheapsize_count;
    }

    public void set_initnonheapsize_count(BaseFeature initnonheapsize_count) {
        this.initnonheapsize_count = initnonheapsize_count;
    }

    public BaseFeature get_maxheapsize_count() {
        return maxheapsize_count;
    }

    public void set_maxheapsize_count(BaseFeature maxheapsize_count) {
        this.maxheapsize_count = maxheapsize_count;
    }

    public BaseFeature get_maxnonheapsize_count() {
        return maxnonheapsize_count;
    }

    public void set_maxnonheapsize_count(BaseFeature maxnonheapsize_count) {
        this.maxnonheapsize_count = maxnonheapsize_count;
    }

    public BaseFeature get_objectpendingfinalizationcount_count() {
        return objectpendingfinalizationcount_count;
    }

    public void set_objectpendingfinalizationcount_count(BaseFeature objectpendingfinalizationcount_count) {
        this.objectpendingfinalizationcount_count = objectpendingfinalizationcount_count;
    }

    public BaseFeature get_usedheapsize_count() {
        return usedheapsize_count;
    }

    public void set_usedheapsize_count(BaseFeature usedheapsize_count) {
        this.usedheapsize_count = usedheapsize_count;
    }

    public BaseFeature get_usednonheapsize_count() {
        return usednonheapsize_count;
    }

    public void set_usednonheapsize_count(BaseFeature usednonheapsize_count) {
        this.usednonheapsize_count = usednonheapsize_count;
    }

   
    
}
