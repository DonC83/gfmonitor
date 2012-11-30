package org.greyhope.gf.mon.framework;

import java.io.Serializable;

/**
 *
 * @author greyhope
 */
public class BaseFeature implements Serializable{
    
     private long _count;
    private String _highwatermark;
    private long _lastsampletime;
    private String _description;
    private String _unit;
    private String _upperbound;
    private String _name;
    private long _starttime;
    private String _lowerbound;
    private String _current;
    private String _lowwatermark;
    private String _mintime;
    private String _maxtime;
    private String fieldName;

    public BaseFeature(String name) {
        
        super();
        
        this.fieldName = name;
        this._name = "";
        this._count = 0;
        this._highwatermark = "";
        this._lastsampletime = 0;
        this._description = "";
        this._unit = "";
        this._upperbound = "";
        this._name = "";
        this._starttime = 0;
        this._lowerbound = "";
        this._current = "";
        this._lowwatermark = "";
        this._mintime = "";
        this._maxtime = "";
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    
    public long get_count() {
        return _count;
    }

    public void set_count(long _count) {
        this._count = _count;
    }

    public String get_current() {
        return _current;
    }

    public void set_current(String _current) {
        this._current = _current;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public String get_highwatermark() {
        return _highwatermark;
    }

    public void set_highwatermark(String _highwatermark) {
        this._highwatermark = _highwatermark;
    }

    public long get_lastsampletime() {
        return _lastsampletime;
    }

    public void set_lastsampletime(long _lastsampletime) {
        this._lastsampletime = _lastsampletime;
    }

    public String get_lowerbound() {
        return _lowerbound;
    }

    public void set_lowerbound(String _lowerbound) {
        this._lowerbound = _lowerbound;
    }

    public String get_lowwatermark() {
        return _lowwatermark;
    }

    public void set_lowwatermark(String _lowwatermark) {
        this._lowwatermark = _lowwatermark;
    }

    public String get_maxtime() {
        return _maxtime;
    }

    public void set_maxtime(String _maxtime) {
        this._maxtime = _maxtime;
    }

    public String get_mintime() {
        return _mintime;
    }

    public void set_mintime(String _mintime) {
        this._mintime = _mintime;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public long get_starttime() {
        return _starttime;
    }

    public void set_starttime(long _starttime) {
        this._starttime = _starttime;
    }

    public String get_unit() {
        return _unit;
    }

    public void set_unit(String _unit) {
        this._unit = _unit;
    }

    public String get_upperbound() {
        return _upperbound;
    }

    public void set_upperbound(String _upperbound) {
        this._upperbound = _upperbound;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseFeature other = (BaseFeature) obj;
        if (this._count != other._count) {
            return false;
        }
        if ((this._highwatermark == null) ? (other._highwatermark != null) : !this._highwatermark.equals(other._highwatermark)) {
            return false;
        }
        if (this._lastsampletime != other._lastsampletime) {
            return false;
        }
        if ((this._description == null) ? (other._description != null) : !this._description.equals(other._description)) {
            return false;
        }
        if ((this._unit == null) ? (other._unit != null) : !this._unit.equals(other._unit)) {
            return false;
        }
        if ((this._upperbound == null) ? (other._upperbound != null) : !this._upperbound.equals(other._upperbound)) {
            return false;
        }
        if ((this._name == null) ? (other._name != null) : !this._name.equals(other._name)) {
            return false;
        }
        if (this._starttime != other._starttime) {
            return false;
        }
        if ((this._lowerbound == null) ? (other._lowerbound != null) : !this._lowerbound.equals(other._lowerbound)) {
            return false;
        }
        if ((this._current == null) ? (other._current != null) : !this._current.equals(other._current)) {
            return false;
        }
        if ((this._lowwatermark == null) ? (other._lowwatermark != null) : !this._lowwatermark.equals(other._lowwatermark)) {
            return false;
        }
        if ((this._mintime == null) ? (other._mintime != null) : !this._mintime.equals(other._mintime)) {
            return false;
        }
        if ((this._maxtime == null) ? (other._maxtime != null) : !this._maxtime.equals(other._maxtime)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this._count ^ (this._count >>> 32));
        hash = 23 * hash + (this._highwatermark != null ? this._highwatermark.hashCode() : 0);
        hash = 23 * hash + (int) (this._lastsampletime ^ (this._lastsampletime >>> 32));
        hash = 23 * hash + (this._description != null ? this._description.hashCode() : 0);
        hash = 23 * hash + (this._unit != null ? this._unit.hashCode() : 0);
        hash = 23 * hash + (this._upperbound != null ? this._upperbound.hashCode() : 0);
        hash = 23 * hash + (this._name != null ? this._name.hashCode() : 0);
        hash = 23 * hash + (int) (this._starttime ^ (this._starttime >>> 32));
        hash = 23 * hash + (this._lowerbound != null ? this._lowerbound.hashCode() : 0);
        hash = 23 * hash + (this._current != null ? this._current.hashCode() : 0);
        hash = 23 * hash + (this._lowwatermark != null ? this._lowwatermark.hashCode() : 0);
        hash = 23 * hash + (this._mintime != null ? this._mintime.hashCode() : 0);
        hash = 23 * hash + (this._maxtime != null ? this._maxtime.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Feature{" + "_count=" + _count + ", _highwatermark=" + _highwatermark + ", _lastsampletime=" + _lastsampletime + ", _description=" + _description + ", _unit=" + _unit + ", _upperbound=" + _upperbound + ", _name=" + _name + ", _starttime=" + _starttime + ", _lowerbound=" + _lowerbound + ", _current=" + _current + ", _lowwatermark=" + _lowwatermark + ", _mintime=" + _mintime + ", _maxtime=" + _maxtime + '}';
    }
}
