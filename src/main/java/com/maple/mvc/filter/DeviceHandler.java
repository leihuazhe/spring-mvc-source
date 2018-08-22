package com.maple.mvc.filter;

import java.util.HashMap;
import java.util.Map;

/**
 * desc: DeviceHandler
 *
 * @author hz.lei
 * @since 2018年08月22日 下午9:16
 */
public class DeviceHandler extends Handler {

    @Override
    public void get(String[] args) throws Exception {
        Map ret = new HashMap();

        writeJsonObject(ret);
    }
}
