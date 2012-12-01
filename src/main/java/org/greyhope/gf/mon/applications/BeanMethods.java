package org.greyhope.gf.mon.applications;

import org.greyhope.gf.mon.framework.BaseFeature;

/**
 *
 * @author greyhope
 */
public class BeanMethods {
    
    public static final String URL = "server/applications/%/%/bean-methods/%";
    public static final String XPATH = "//entry/map/entry/map/entry[@key='%']/map/*";
    
    private String name;
    private BaseFeature _executiontime;
    private BaseFeature _methodstatistic;
    private BaseFeature _totalnumerrors;
    private BaseFeature _totalnumsuccess;

    public BeanMethods(String name) {
        this.name = name;
    }

    public BaseFeature get_executiontime() {
        return _executiontime;
    }

    public void set_executiontime(BaseFeature _executiontime) {
        this._executiontime = _executiontime;
    }

    public BaseFeature get_methodstatistic() {
        return _methodstatistic;
    }

    public void set_methodstatistic(BaseFeature _methodstatistic) {
        this._methodstatistic = _methodstatistic;
    }

    public BaseFeature get_totalnumerrors() {
        return _totalnumerrors;
    }

    public void set_totalnumerrors(BaseFeature _totalnumerrors) {
        this._totalnumerrors = _totalnumerrors;
    }

    public BaseFeature get_totalnumsuccess() {
        return _totalnumsuccess;
    }

    public void set_totalnumsuccess(BaseFeature _totalnumsuccess) {
        this._totalnumsuccess = _totalnumsuccess;
    }
    
}
