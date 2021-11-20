package model.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Freaver
 * @Time 07/09/2021 09:07
 * @Decription 用户类(包括普通用户和管理员)
 */
public class User implements Serializable {
    /**
     * 用户名
     */
    @JSONField(name = "username", ordinal = 1)
    private String userName;

    /**
     * 用户密码
     */
    @JSONField(name = "password", ordinal = 2)
    private String password;

    /**
     * 判断是否是管理员
     */
    @JSONField(name = "isAdministrator", ordinal = 3)
    private Boolean isAdministrator = false;

    public User(String userName, String password, Boolean isAdministrator) {
        this.userName = userName;
        this.password = password;
        this.isAdministrator = isAdministrator;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAdministrator() {
        return isAdministrator;
    }

    public void setIsAdministrator(Boolean administrator) {
        isAdministrator = administrator;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isAdministrator=" + isAdministrator +
                '}';
    }


    /**
     * 由于运用了Set进行数据的存储，故需要重写equals和hashcode方法来限定判断条件
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(getUserName(), user.getUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName());
    }
}
