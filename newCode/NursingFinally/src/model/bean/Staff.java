package model.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author Freaver
 * @Time 07/09/2021 08:55
 * @Description 员工信息类
 */
public class Staff implements Serializable {
    /**
     *     用户名
     */
    private String username;


    /**
     * 员工姓名
     */


    private String name;

    /**
     *     员工生日
     */
    private Date birthday;

    /**
     *    员工专长
     */
    private String specialty;

    /**
     * 员工职称
     */
    private String jobTitle;

    /**
     * 员工电话
     */
    private String tel;

    public Staff(String username, String name, Date birthday, String specialty, String jobTitle, String tel) {
        this.username = username;
        this.name = name;
        if (birthday == null) {
            this.birthday = new Date();
        } else {
            this.birthday = birthday;
        }
        this.specialty = specialty;
        this.jobTitle = jobTitle;
        this.tel = tel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "userName='" + username + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", specialty='" + specialty + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", tel='" + tel + '\'' +
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
        if (!(o instanceof Staff)) {
            return false;
        }
        Staff staff = (Staff) o;
        return Objects.equals(getUsername(), staff.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }
}
