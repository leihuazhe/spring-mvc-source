package com.maple.mvc.beans.lookup;

/**
 * desc: BikeProvider
 *
 * @author hz.lei
 * @since 2018年08月16日 下午11:30
 */
public abstract class BikeProvider {

    public abstract Bike getBike();

    public void hello() {
        this.getBike().riding();
    }
}
