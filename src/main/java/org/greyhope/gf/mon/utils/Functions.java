package org.greyhope.gf.mon.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author greyhope
 */
public class Functions {
    
    public static final String SPACE_CHAR = "+";
    public static List<String> ignoredApplications;
    
    public static void init(){
        
        ignoredApplications = new ArrayList<String>();
        ignoredApplications.add("__admingui");
        ignoredApplications.add("__default-web-module");
        ignoredApplications.add("wstx-services");
        
    }
    
    public static Date getDateFromUnixEpoch(String date){
        
        Date resultDate = null;
        
        try{
            long epochDate = Long.parseLong(date);
            resultDate = new Date(epochDate * 1000);
        }catch(NumberFormatException e){
            
        }
        
        return resultDate;
        
    }
    
    public String stringToDescription(String string){
        
        return string.replaceAll(SPACE_CHAR, " ");
        
    }
    
}
