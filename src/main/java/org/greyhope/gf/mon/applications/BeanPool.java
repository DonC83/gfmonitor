package org.greyhope.gf.mon.applications;

import org.greyhope.gf.mon.framework.BaseFeature;

/**
 *
 * @author greyhope
 */
public class BeanPool {
    
    private String name;
    
    private BaseFeature _jmsmaxmessagesload;
    private BaseFeature _numbeansinpool;
    private BaseFeature _numthreadswaiting;
    private BaseFeature _totalbeanscreated;
    private BaseFeature _totalbeansdestroyed;

    public BeanPool(String moduleName) {
        this.name = moduleName;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }
    
    public BaseFeature get_jmsmaxmessagesload() {
        return _jmsmaxmessagesload;
    }

    public void set_jmsmaxmessagesload(BaseFeature _jmsmaxmessagesload) {
        this._jmsmaxmessagesload = _jmsmaxmessagesload;
    }

    public BaseFeature get_numbeansinpool() {
        return _numbeansinpool;
    }

    public void set_numbeansinpool(BaseFeature _numbeansinpool) {
        this._numbeansinpool = _numbeansinpool;
    }

    public BaseFeature get_numthreadswaiting() {
        return _numthreadswaiting;
    }

    public void set_numthreadswaiting(BaseFeature _numthreadswaiting) {
        this._numthreadswaiting = _numthreadswaiting;
    }

    public BaseFeature get_totalbeanscreated() {
        return _totalbeanscreated;
    }

    public void set_totalbeanscreated(BaseFeature _totalbeanscreated) {
        this._totalbeanscreated = _totalbeanscreated;
    }

    public BaseFeature get_totalbeansdestroyed() {
        return _totalbeansdestroyed;
    }

    public void set_totalbeansdestroyed(BaseFeature _totalbeansdestroyed) {
        this._totalbeansdestroyed = _totalbeansdestroyed;
    }
    
}
