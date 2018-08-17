package com.maple.mvc.test;

import java.lang.reflect.Modifier;

/**
 * desc: ReflectBean
 *
 * @author hz.lei
 * @since 2018年08月16日 下午8:10
 */
public class ReflectBean {
    public class Dl{

    }

    public static void main(String[] args) {
        System.out.println(ReflectBean.class.getModifiers());
        boolean aPublic = Modifier.isPublic(ReflectBean.class.getModifiers());

        System.out.println(aPublic);
    }
}

