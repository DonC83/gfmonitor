package org.greyhope.gf.mon.builder;

import java.beans.Expression;
import java.beans.Statement;
import java.lang.reflect.Field;
import java.util.List;
import org.greyhope.gf.mon.framework.Feature;
import org.greyhope.gf.mon.tree.ConnectionQueue;
import org.jdom2.Attribute;
import org.jdom2.Element;

/**
 *
 * @author greyhope
 */
//long count;
//String highwatermark;
//long lastsampletime;
//String description;
//String unit;
//String upperbound;
//String name;
//long starttime;
//String lowerbound;
//String current;
//String lowwatermark;
//String mintime;
//String maxtime;
public class FeatureBuilder {

    public final static String KEY = "key";
    public final static String VALUE = "value";
    public final static String SET = "set_";
    
    public static Field[] getFields(Class clazz){
        return clazz.getDeclaredFields();
    }
    
    public static Feature buildFeature(String name, List<Element> elements) throws Exception {

        Object result = new Feature(name);
        
        Statement stmt;
        Expression expr;

        for (Element e : elements) {

            List<Attribute> attributes = e.getAttributes();

            if (attributes.size() == 2) {
                stmt = new Statement(result, SET.concat(e.getAttributeValue(KEY)), new Object[]{e.getAttributeValue(VALUE)});
                stmt.execute();
            } else {
                stmt = new Statement(result, SET.concat(e.getAttributeValue(KEY)), new Object[]{Long.valueOf(e.getValue())});
                stmt.execute();
            }
        }
        return (Feature) result;
    }
}
