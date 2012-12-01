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
    public static List<String> ignoredBeanMethods;
    

    public static void init() {

        ignoredApplications = new ArrayList<String>();
        ignoredApplications.add("__admingui");
        ignoredApplications.add("__default-web-module");
        ignoredApplications.add("wstx-services");
        
        ignoredBeanMethods = new ArrayList<String>();
        ignoredBeanMethods.add("equals-java.lang.Object");
        ignoredBeanMethods.add("getClass");
        ignoredBeanMethods.add("hashCode");
        ignoredBeanMethods.add("notify");
        ignoredBeanMethods.add("notifyAll");
        ignoredBeanMethods.add("toString");
        ignoredBeanMethods.add("wait");
        ignoredBeanMethods.add("wait-long");
        ignoredBeanMethods.add("wait-long-int");
        
    }

    public static Date getDateFromUnixEpoch(String date) {

        Date resultDate = null;

        try {
            long epochDate = Long.parseLong(date);
            resultDate = new Date(epochDate * 1000);
        } catch (NumberFormatException e) {
        }

        return resultDate;

    }

    public String stringToDescription(String string) {

        return string.replaceAll(SPACE_CHAR, " ");

    }

    public static long bytesToMb(long bytes) {

        long MEGABYTE = 1024L * 1024L;
        long b = bytes / MEGABYTE;
        return b;
    }

    public static String getField(String field) {
        return field.replaceAll("_", "-");
    }
    
    public static String getFeatureName(String field) {
        return field.replaceAll("-", "_");
    }
    
    public static long getUnusedRamAmount(long maxTotal, long usedHeap){
        
        long unused = bytesToMb(maxTotal) - bytesToMb(usedHeap);
        
        //System.out.println("Unused : " + unused);
        return unused;
    }
    
  
}
