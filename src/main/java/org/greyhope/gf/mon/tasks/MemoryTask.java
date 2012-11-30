package org.greyhope.gf.mon.tasks;

import java.beans.Statement;
import java.io.IOException;
import java.util.List;
import org.greyhope.gf.mon.builder.JDomReader;
import org.greyhope.gf.mon.framework.BaseFeature;
import org.greyhope.gf.mon.properties.Properties;
import org.greyhope.gf.mon.rest.RestClient;
import org.greyhope.gf.mon.tree.Memory;
import org.greyhope.gf.mon.utils.Functions;
import org.jdom2.JDOMException;

/**
 *
 * @author greyhope
 */
public class MemoryTask extends BaseTask implements Runnable {

    private Memory memory;
    private static final String COUNT = "_count";

    public MemoryTask(Properties.CONNECTION connectionType, String baseUrl, Memory memory) {
        super();
        System.out.println("Connection Type : " + connectionType);
        setConnType(connectionType);
        setClient(new RestClient(getConnType()));
        System.out.println("Memory Task Set");
        setBaseURL(baseUrl);
        setResource(new String());
        this.memory = memory;
        
    }

    @Override
    public void run() {
        
        System.out.println("Memory task started");

        // Set the resource
        setResource(getBaseURL().concat(Memory.URL).concat(".xml"));
        //System.out.println("Resource : " + resource);
        getClient().setResource(getResource());

        String response = getClient().get_XML(String.class);
        //System.out.println("XML Response : " + response);

        // Get the values 
        List<BaseFeature> allFeatures;
        Statement stmt;

        try {
            allFeatures = JDomReader.getNestedFeatureList(Memory.class, response, Memory.XPATH);
            //System.out.println("Feature Size : " + allFeatures.size());

            for (BaseFeature f : allFeatures) {
                //System.out.println("Feature Name : " + f.get_name().toLowerCase().concat(COUNT));
                stmt = new Statement(memory,SET.concat(Functions.getFeatureName(f.getFieldName().toLowerCase())),new Object[]{f});
                stmt.execute();
            }
            
            memory.fireEvent();

        } catch (JDOMException ex) {
            System.err.println("Exception Response : " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Exception Response : " + ex.getMessage());
        } catch (NoSuchMethodException ex) {
            System.err.println("Exception Response : " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.err.println("Exception Response : " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.err.println("Exception Response : " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Exception Response : " + ex.getMessage());
        }

        // Change Event happened


    }
}
