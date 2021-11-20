package com.example.goBangFx.model.bean;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String password;
    private Boolean isAdministrator;


    public User(String name, String password, Boolean isAdministrator) {
        this.name = name;
        this.password = password;
        this.isAdministrator = isAdministrator;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsAdministrator() {
        return isAdministrator;
    }

    public void setIsAdministrator(Boolean administrator) {
        isAdministrator = administrator;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
