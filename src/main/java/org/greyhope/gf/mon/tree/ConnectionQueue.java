/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greyhope.gf.mon.tree;

import org.greyhope.gf.mon.framework.BaseFeature;

/**
 *
 * @author greyhope
 */
public class ConnectionQueue {
    
    public static final String URL = "server/network/connection-queue";
    public static final String XPATH = "//entry/map/entry/map/entry[@key='%']/map/*";
    
    private BaseFeature countopenconnections;
    private BaseFeature countoverflows;
    private BaseFeature countqueued;
    private BaseFeature countqueued15minutesaverage;
    private BaseFeature countqueued1minuteaverage;
    private BaseFeature countqueued5minutesaverage;
    private BaseFeature counttotalconnections;
    private BaseFeature counttotalqueued;
    private BaseFeature maxqueued;
    private BaseFeature peakqueued;
    private BaseFeature tickstotalqueued;

    public ConnectionQueue() {
    }

    public BaseFeature get_countopenconnections() {
        return countopenconnections;
    }

    public void set_countopenconnections(BaseFeature countopenconnections) {
        this.countopenconnections = countopenconnections;
    }

    public BaseFeature get_countoverflows() {
        return countoverflows;
    }

    public void set_countoverflows(BaseFeature countoverflows) {
        this.countoverflows = countoverflows;
    }

    public BaseFeature get_countqueued() {
        return countqueued;
    }

    public void set_countqueued(BaseFeature countqueued) {
        this.countqueued = countqueued;
    }

    public BaseFeature get_countqueued15minutesaverage() {
        return countqueued15minutesaverage;
    }

    public void set_countqueued15minutesaverage(BaseFeature countqueued15minutesaverage) {
        this.countqueued15minutesaverage = countqueued15minutesaverage;
    }

    public BaseFeature get_countqueued1minuteaverage() {
        return countqueued1minuteaverage;
    }

    public void set_countqueued1minuteaverage(BaseFeature countqueued1minuteaverage) {
        this.countqueued1minuteaverage = countqueued1minuteaverage;
    }

    public BaseFeature get_countqueued5minutesaverage() {
        return countqueued5minutesaverage;
    }

    public void set_countqueued5minutesaverage(BaseFeature countqueued5minutesaverage) {
        this.countqueued5minutesaverage = countqueued5minutesaverage;
    }

    public BaseFeature get_counttotalconnections() {
        return counttotalconnections;
    }

    public void set_counttotalconnections(BaseFeature counttotalconnections) {
        this.counttotalconnections = counttotalconnections;
    }

    public BaseFeature get_counttotalqueued() {
        return counttotalqueued;
    }

    public void set_counttotalqueued(BaseFeature counttotalqueued) {
        this.counttotalqueued = counttotalqueued;
    }

    public BaseFeature get_maxqueued() {
        return maxqueued;
    }

    public void set_maxqueued(BaseFeature maxqueued) {
        this.maxqueued = maxqueued;
    }

    public BaseFeature get_peakqueued() {
        return peakqueued;
    }

    public void set_peakqueued(BaseFeature peakqueued) {
        this.peakqueued = peakqueued;
    }

    public BaseFeature get_tickstotalqueued() {
        return tickstotalqueued;
    }

    public void set_tickstotalqueued(BaseFeature tickstotalqueued) {
        this.tickstotalqueued = tickstotalqueued;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConnectionQueue other = (ConnectionQueue) obj;
        if (this.countopenconnections != other.countopenconnections && (this.countopenconnections == null || !this.countopenconnections.equals(other.countopenconnections))) {
            return false;
        }
        if (this.countoverflows != other.countoverflows && (this.countoverflows == null || !this.countoverflows.equals(other.countoverflows))) {
            return false;
        }
        if (this.countqueued != other.countqueued && (this.countqueued == null || !this.countqueued.equals(other.countqueued))) {
            return false;
        }
        if (this.countqueued15minutesaverage != other.countqueued15minutesaverage && (this.countqueued15minutesaverage == null || !this.countqueued15minutesaverage.equals(other.countqueued15minutesaverage))) {
            return false;
        }
        if (this.countqueued1minuteaverage != other.countqueued1minuteaverage && (this.countqueued1minuteaverage == null || !this.countqueued1minuteaverage.equals(other.countqueued1minuteaverage))) {
            return false;
        }
        if (this.countqueued5minutesaverage != other.countqueued5minutesaverage && (this.countqueued5minutesaverage == null || !this.countqueued5minutesaverage.equals(other.countqueued5minutesaverage))) {
            return false;
        }
        if (this.counttotalconnections != other.counttotalconnections && (this.counttotalconnections == null || !this.counttotalconnections.equals(other.counttotalconnections))) {
            return false;
        }
        if (this.counttotalqueued != other.counttotalqueued && (this.counttotalqueued == null || !this.counttotalqueued.equals(other.counttotalqueued))) {
            return false;
        }
        if (this.maxqueued != other.maxqueued && (this.maxqueued == null || !this.maxqueued.equals(other.maxqueued))) {
            return false;
        }
        if (this.peakqueued != other.peakqueued && (this.peakqueued == null || !this.peakqueued.equals(other.peakqueued))) {
            return false;
        }
        if (this.tickstotalqueued != other.tickstotalqueued && (this.tickstotalqueued == null || !this.tickstotalqueued.equals(other.tickstotalqueued))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.countopenconnections != null ? this.countopenconnections.hashCode() : 0);
        hash = 17 * hash + (this.countoverflows != null ? this.countoverflows.hashCode() : 0);
        hash = 17 * hash + (this.countqueued != null ? this.countqueued.hashCode() : 0);
        hash = 17 * hash + (this.countqueued15minutesaverage != null ? this.countqueued15minutesaverage.hashCode() : 0);
        hash = 17 * hash + (this.countqueued1minuteaverage != null ? this.countqueued1minuteaverage.hashCode() : 0);
        hash = 17 * hash + (this.countqueued5minutesaverage != null ? this.countqueued5minutesaverage.hashCode() : 0);
        hash = 17 * hash + (this.counttotalconnections != null ? this.counttotalconnections.hashCode() : 0);
        hash = 17 * hash + (this.counttotalqueued != null ? this.counttotalqueued.hashCode() : 0);
        hash = 17 * hash + (this.maxqueued != null ? this.maxqueued.hashCode() : 0);
        hash = 17 * hash + (this.peakqueued != null ? this.peakqueued.hashCode() : 0);
        hash = 17 * hash + (this.tickstotalqueued != null ? this.tickstotalqueued.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ConnectionQueue{" + "countopenconnections=" + countopenconnections + ", countoverflows=" + countoverflows + ", countqueued=" + countqueued + ", countqueued15minutesaverage=" + countqueued15minutesaverage + ", countqueued1minuteaverage=" + countqueued1minuteaverage + ", countqueued5minutesaverage=" + countqueued5minutesaverage + ", counttotalconnections=" + counttotalconnections + ", counttotalqueued=" + counttotalqueued + ", maxqueued=" + maxqueued + ", peakqueued=" + peakqueued + ", tickstotalqueued=" + tickstotalqueued + '}';
    }
    
}
