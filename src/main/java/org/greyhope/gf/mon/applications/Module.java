package org.greyhope.gf.mon.applications;

import java.util.List;
import org.greyhope.gf.mon.framework.BaseFeature;

/**
 *
 * @author greyhope
 */
public class Module {
    
    public static final String URL = "server/applications/%/%";
    public static final String XPATH = "//entry/map/entry/map/entry[@key='%']/map/*";
    
    public static final String BP_URL = "server/applications/%/%/bean-pool";
    public static final String BP_XPATH = "//entry/map/entry/map/entry[@key='%']/map/*";
    public static final String BM_URL = "server/applications/%/%/bean-methods";
    public static final String BM_XPATH = "//entry/map/entry/map/*";
    
    ApplicationModule applicationModule;
    
    private String name;
    private BaseFeature _createcount;
    private BaseFeature _methodreadycount;
    private BaseFeature _removecount;
    
    List<BeanMethods> _bean_methods;
    private BeanPool bean_pool;

    public Module(ApplicationModule applicationModule, String name) {
        this.applicationModule = applicationModule;
        this.name = name;
    }

    public List<BeanMethods> get_bean_methods() {
        return _bean_methods;
    }

    public void set_bean_methods(List<BeanMethods> _bean_methods) {
        this._bean_methods = _bean_methods;
    }

    public BaseFeature get_createcount() {
        return _createcount;
    }

    public void set_createcount(BaseFeature _createcount) {
        this._createcount = _createcount;
    }

    public BaseFeature get_methodreadycount() {
        return _methodreadycount;
    }

    public void set_methodreadycount(BaseFeature _methodreadycount) {
        this._methodreadycount = _methodreadycount;
    }

    public BaseFeature get_removecount() {
        return _removecount;
    }

    public void set_removecount(BaseFeature _removecount) {
        this._removecount = _removecount;
    }

    public BeanPool get_bean_pool() {
        return bean_pool;
    }

    public void set_bean_pool(BeanPool beanPool) {
        this.bean_pool = beanPool;
    }

    
}
