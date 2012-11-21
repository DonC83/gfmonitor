package org.greyhope.gf.mon.widgets;

import java.util.Date;
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
    public void featureChanged(FeatureEvent e) {
        System.out.println("**** FEATURE CHANGED ****");
        System.out.println("Monitoring feature : " + e.getFeature().get_name());
        System.out.println("Count : " + e.getFeature().get_count());
        System.out.println("Current : " + e.getFeature().get_current());
        System.out.println("Description : " + e.getFeature().get_description());
        System.out.println("High watermark : " + e.getFeature().get_highwatermark());
        System.out.println("Last sample Time : " + e.getFeature().get_lastsampletime());
        System.out.println("Lowerbound : " + e.getFeature().get_lowerbound());
        System.out.println("Low watermark : " + e.getFeature().get_lowwatermark());
        System.out.println("Max time : " + e.getFeature().get_maxtime());
        System.out.println("Min time : " + e.getFeature().get_mintime());
        System.out.println("Start time : " + e.getFeature().get_starttime());
        System.out.println("Unit : " + e.getFeature().get_unit());
        System.out.println("Upper bound : " + e.getFeature().get_upperbound());
        System.out.println("**** FEATURE CHANGED : " + new Date() +" ****");
    }
    
}
