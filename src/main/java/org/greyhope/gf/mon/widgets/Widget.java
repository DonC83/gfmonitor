package org.greyhope.gf.mon.widgets;

import java.util.Date;
import org.greyhope.gf.mon.framework.BaseFeature;
import org.greyhope.gf.mon.framework.FeatureEvent;
import org.greyhope.gf.mon.framework.FeatureListener;

/**
 *
 * @author greyhope
 */

// This user class will potentially be a front end widget
public class Widget implements FeatureListener{
    
    public Widget(){
        
    }

    @Override
    public void featureChanged(FeatureEvent obj) {
        
        BaseFeature e = (BaseFeature) obj.getFeature();
        
        System.out.println("**** FEATURE CHANGED ****");
        System.out.println("Monitoring feature : " + e.get_name());
        System.out.println("Count : " + e.get_count());
        System.out.println("Current : " + e.get_current());
        System.out.println("Description : " + e.get_description());
        System.out.println("High watermark : " + e.get_highwatermark());
        System.out.println("Last sample Time : " + e.get_lastsampletime());
        System.out.println("Lowerbound : " + e.get_lowerbound());
        System.out.println("Low watermark : " + e.get_lowwatermark());
        System.out.println("Max time : " + e.get_maxtime());
        System.out.println("Min time : " + e.get_mintime());
        System.out.println("Start time : " + e.get_starttime());
        System.out.println("Unit : " + e.get_unit());
        System.out.println("Upper bound : " + e.get_upperbound());
        System.out.println("**** FEATURE CHANGED : " + new Date() +" ****");
    }
    
}
