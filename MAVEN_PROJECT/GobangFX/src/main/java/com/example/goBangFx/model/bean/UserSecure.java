package com.example.goBangFx.model.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Freaver
 * @date 07/13/2021 22:19
 * @description UserSecure实体类，用来存放被加密后的User信息
 */
public class UserSecure implements Serializable {

    @JSONField(name = "username", ordinal = 1)
    private String username;

    @JSONField(name = "key", ordinal = 2)
    private byte[] key;

    @JSONField(name = "encrypt", ordinal = 3)
    private String encrypt;

    @JSONField(name = "isAdministrator", ordinal = 4)
    private Boolean isAdministrator;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getKey() {
        return key;
    }

    public void setKey(byte[] key) {
        this.key = key;
    }

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    public Boolean getIsAdministrator() {
        return isAdministrator;
    }

    public void setIsAdministrator(Boolean administrator) {
        this.isAdministrator = administrator;
    }

    public UserSecure(String username, byte[] key, String encrypt, Boolean isAdministrator) {
        this.username = username;
        this.key = key;
        this.encrypt = encrypt;
        this.isAdministrator = isAdministrator;
    }

}
