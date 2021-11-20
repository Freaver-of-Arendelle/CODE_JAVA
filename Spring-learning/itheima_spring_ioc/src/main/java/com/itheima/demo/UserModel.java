package com.itheima.demo;

import com.itheima.dao.impl.UserDaoImpl;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: Freaver
 * @Date: 3/28/2021  22:32
 */
public class UserModel {
    private String name;
    private int age;
    private List<String> stringList;
    private Map<String, UserDaoImpl> map;
    private Properties properties;

    public UserModel(String name, int age, List<String> stringList, Map<String, UserDaoImpl> map,
        Properties properties) {
        this.name = name;
        this.age = age;
        this.stringList = stringList;
        this.map = map;
        this.properties = properties;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setMap(Map<String, UserDaoImpl> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override public String toString() {
        return "UserModel{" + "name='" + name + '\'' + ", age=" + age + ", stringList=" + stringList + ", map=" + map
            + ", properties=" + properties + '}';
    }
}
