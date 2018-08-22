package com.maple.mvc.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * desc: Handler
 *
 * @author hz.lei
 * @since 2018年08月22日 下午9:16
 */
public abstract class Handler {

    public HttpServletRequest request;
    public HttpServletResponse response;

    public void get(String[] args) throws Exception {
        throw new Exception("Not implemented");
    }

    public void post(String[] args) throws Exception {
        throw new Exception("Not implemented");
    }

    public void put(String[] args) throws Exception {
        throw new Exception("Not implemented");
    }

    public void delete(String[] args) throws Exception {
        throw new Exception("Not implemented");
    }

    public void writeJsonObject(Object object) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        out.println(Json.dump(object));
        out.flush();
        out.close();
    }

}
