package com.maple.mvc.entity;

/**
 * desc: TODO
 *
 * @author hz.lei
 * @since 2018年08月15日 下午4:03
 */
public class TestBean {
    private int id;
    private String name;
    private String age;

    public TestBean(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
