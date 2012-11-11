package org.greyhope.gf.mon.builder;

import java.beans.Expression;
import java.beans.Statement;
import java.lang.reflect.Field;
import java.util.List;
import org.greyhope.gf.mon.framework.Feature;
import org.jdom2.Attribute;
import org.jdom2.Element;

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

    /**
     * 
     * @author greyhope
     * 
     * <p>
     * This class is used for building features for the glassfish application server that can be monitored. The static
     * methods take the Feature bundled component that will be interogated and populated with values. The util methods 
     * will return a feature attributed to a bundled feature component.       
     * <p>
     */
public class FeatureBuilder {

    public final static String KEY = "key";
    public final static String VALUE = "value";
    public final static String SET = "set_";
    
    
    /**
     * <p>
     * The get fields method will extract the fields from the bundled feature class.
     * <p>
     *
     * @param Class clazz
     * @return Field[]
     *
     */
    public static Field[] getFields(Class clazz){
        return clazz.getDeclaredFields();
    }
    
    /**
     * <p>
     * The get fields method will extract the fields from the feature class and populate a feature class from the Nodelist object
     * using statement and expression introspective elements.
     * <p>
     *
     * @param name
     * @param elements
     * @return result
     *
     */
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
