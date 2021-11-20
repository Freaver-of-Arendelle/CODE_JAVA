package com.freaver.goBang2.model.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

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

    @JSONField(name =  "phone", ordinal = 4)
    private String phone;


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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserSecure(String username, byte[] key, String encrypt, String phone) {
        this.username = username;
        this.key = key;
        this.encrypt = encrypt;
        this.phone = phone;
    }

}
