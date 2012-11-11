package org.greyhope.gf.mon.builder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.greyhope.gf.mon.framework.Feature;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

/**
 * @author greyhope
 * 
 * <p>
 * This class does xml and xpath related functions. 
 * <p>
 * 
 */
public class JDomReader {

    // public static String xmlString = "<?xml version='1.0' encoding=\"UTF-8\" standalone=\"no\"?><map><entry key=\"extraProperties\"><map><entry key=\"entity\"><map><entry key=\"countqueued15minutesaverage\"><map><entry key=\"unit\" value=\"count\"/><entry key=\"starttime\"><number>1352330922584</number></entry><entry key=\"count\"><number>7</number></entry><entry key=\"description\" value=\"Average number of connections queued in the last 15 minutes\"/><entry key=\"name\" value=\"CountQueued15MinutesAverage\"/><entry key=\"lastsampletime\"><number>1352330922584</number></entry></map></entry><entry key=\"countqueued5minutesaverage\"><map><entry key=\"unit\" value=\"count\"/><entry key=\"starttime\"><number>1352330922584</number></entry><entry key=\"count\"><number>1</number></entry><entry key=\"description\" value=\"Average number of connections queued in the last 5 minutes\"/><entry key=\"name\" value=\"CountQueued5MinutesAverage\"/><entry key=\"lastsampletime\"><number>1352330922584</number></entry></map></entry><entry key=\"countqueued1minuteaverage\"><map><entry key=\"unit\" value=\"count\"/><entry key=\"starttime\"><number>1352330922584</number></entry><entry key=\"count\"><number>1</number></entry><entry key=\"description\" value=\"Average number of connections queued in the last 1 minute\"/><entry key=\"name\" value=\"CountQueued1MinuteAverage\"/><entry key=\"lastsampletime\"><number>1352330922584</number></entry></map></entry><entry key=\"tickstotalqueued\"><map><entry key=\"unit\" value=\"count\"/><entry key=\"starttime\"><number>1352229883486</number></entry><entry key=\"count\"><number>0</number></entry><entry key=\"description\" value=\"(Unsupported) Total number of ticks that connections have spent in the queue\"/><entry key=\"name\" value=\"TicksTotalQueued\"/><entry key=\"lastsampletime\"><number>1352229883488</number></entry></map></entry><entry key=\"peakqueued\"><map><entry key=\"unit\" value=\"count\"/><entry key=\"starttime\"><number>1352229883486</number></entry><entry key=\"count\"><number>22</number></entry><entry key=\"description\" value=\"Largest number of connections that were in the queue simultaneously\"/><entry key=\"name\" value=\"PeakQueued\"/><entry key=\"lastsampletime\"><number>1352241821742</number></entry></map></entry><entry key=\"countopenconnections\"><map><entry key=\"unit\" value=\"count\"/><entry key=\"starttime\"><number>1352330922584</number></entry><entry key=\"count\"><number>1</number></entry><entry key=\"description\" value=\"The number of open/active connections\"/><entry key=\"name\" value=\"CountOpenConnections\"/><entry key=\"lastsampletime\"><number>1352330922584</number></entry></map></entry><entry key=\"counttotalconnections\"><map><entry key=\"unit\" value=\"count\"/><entry key=\"starttime\"><number>1352229883486</number></entry><entry key=\"count\"><number>533</number></entry><entry key=\"description\" value=\"Total number of connections that have been accepted\"/><entry key=\"name\" value=\"CountTotalConnections\"/><entry key=\"lastsampletime\"><number>1352330922442</number></entry></map></entry><entry key=\"counttotalqueued\"><map><entry key=\"unit\" value=\"count\"/><entry key=\"starttime\"><number>1352229883486</number></entry><entry key=\"count\"><number>1478</number></entry><entry key=\"description\" value=\"Total number of connections that have been queued\"/><entry key=\"name\" value=\"CountTotalQueued\"/><entry key=\"lastsampletime\"><number>1352330922446</number></entry></map></entry><entry key=\"countqueued\"><map><entry key=\"unit\" value=\"count\"/><entry key=\"starttime\"><number>1352229883486</number></entry><entry key=\"count\"><number>0</number></entry><entry key=\"description\" value=\"Number of connections currently in the queue\"/><entry key=\"name\" value=\"CountQueued\"/><entry key=\"lastsampletime\"><number>1352330922446</number></entry></map></entry><entry key=\"countoverflows\"><map><entry key=\"unit\" value=\"count\"/><entry key=\"starttime\"><number>1352229883486</number></entry><entry key=\"count\"><number>0</number></entry><entry key=\"description\" value=\"Number of times the queue has been too full to accommodate a connection\"/><entry key=\"name\" value=\"CountOverflows\"/><entry key=\"lastsampletime\"><number>1352229883488</number></entry></map></entry><entry key=\"maxqueued\"><map><entry key=\"unit\" value=\"count\"/><entry key=\"starttime\"><number>1352229883486</number></entry><entry key=\"count\"><number>0</number></entry><entry key=\"description\" value=\"Maximum size of the connection queue\"/><entry key=\"name\" value=\"MaxQueued\"/><entry key=\"lastsampletime\"><number>-1</number></entry></map></entry></map></entry><entry key=\"childResources\"><map/></entry></map></entry><entry key=\"message\" value=\"\"/><entry key=\"exit_code\" value=\"SUCCESS\"/><entry key=\"command\" value=\"Monitoring Data\"/></map>";
    
    public static List<Feature> performFeature(Class clazz,String xmlString) throws JDOMException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, Exception{
        InputStream is = new ByteArrayInputStream(xmlString.getBytes());
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(is);
        List<Feature> allFeatures = new ArrayList<Feature>();
        
        for(Field field : FeatureBuilder.getFields(clazz)){
            if(field.getName().equals("URL")){
                
            }else{
                XPathExpression xpathExpression = XPathFactory.instance().compile("//entry/map/entry/map/entry[@key='".concat(field.getName()).concat("']/map/*"));
                List<Element> elements = xpathExpression.evaluate(document);
                allFeatures.add(FeatureBuilder.buildFeature(field.getName(), elements));
            }
        }
        
        //showResults(allFeatures);
        return allFeatures;
    }
    
    public static void showResults(List<Feature> allFeatures)  {
        
        for(Feature feature : allFeatures){
            
            System.out.println("**** " +   feature.get_name() + "****");
            System.out.println("Current : " + feature.get_current());
            System.out.println("Description : " + feature.get_description());
            System.out.println("High water mark : " + feature.get_highwatermark());
            System.out.println("Lowerbound : " + feature.get_lowerbound());
            System.out.println("Low water mark : " + feature.get_lowwatermark());
            System.out.println("Maxtime : " + feature.get_maxtime());
            System.out.println("Min time : " + feature.get_mintime());
            System.out.println("Name : " + feature.get_name());
            System.out.println("Unit : " + feature.get_unit());
            System.out.println("Upperbound : " + feature.get_upperbound());
            System.out.println("Count : " + feature.get_count());
            System.out.println("Last sample time : " + feature.get_lastsampletime());
            System.out.println("Start time : " + feature.get_starttime());
            System.out.println("**** DONE ****");
            
        }

    }
}
