/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greyhope.gf.mon.applications;

import java.util.List;
import org.greyhope.gf.mon.framework.BaseFeature;

/**
 *
 * @author greyhope
 */
public class Module<T> {
    
    T t;
    
    private BaseFeature _createcount;
    private BaseFeature _methodreadycount;
    private BaseFeature _removecount;
    
    List<BeanMethods> _bean_methods;
    private BeanPool beanPool;
    
}
