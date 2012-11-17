/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greyhope.gf.mon.lists;

import java.util.LinkedList;

/**
 *
 * @author greyhope
 */
public class MonitoringStack {
    public static LinkedList<String> STACK = new LinkedList<String>();
    
    public MonitoringStack(){
       
    }
    
    public static void push(String url){
        STACK.add(url);
    }
    
    public static String pop(){
        return STACK.poll();
    }
    
    public static void init(){
        STACK.push("server/network/connection-queue");
    }
}
