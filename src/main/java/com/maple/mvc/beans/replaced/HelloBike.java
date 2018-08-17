package com.maple.mvc.beans.replaced;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * desc: 可以在运行时用新的方法替换旧的方法
 *
 * @author hz.lei
 * @since 2018年08月16日 下午11:58
 */
public class HelloBike implements MethodReplacer {
    /**
     * replace
     *
     * @param obj
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
//        method.invoke(obj, args);
        System.out.println("使用哈罗单车来替换OfO单车!!!");
        return "123";
    }
}
