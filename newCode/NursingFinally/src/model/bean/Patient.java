package model.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author Freaver
 * @Time 07/09/2021 08:58
 * @Description 病患信息类
 */
public class Patient implements Serializable {


    /**
     * 病患姓名
     */
    private String name;

    /**
     * 病患生日
     */
    private Date birthday;

    /**
     * 病患性别
     */
    private String gender;

    /**
     * 病患身份证号
     */
    private String id;

    /**
     * 病患联系电话
     */
    private String tel;

    /**
     * 紧急联系人
     */
    private String emergencyContact;

    /**
     * 紧急联系人电话
     */
    private String emergencyTel;

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'' +
                ", tel='" + tel + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", emergencyTel='" + emergencyTel + '\'' +
                '}';
    }

    public Patient(String name, Date birthday, String gender, String id, String tel, String emergencyContact, String emergencyTel) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.id = id;
        this.tel = tel;
        this.emergencyContact = emergencyContact;
        this.emergencyTel = emergencyTel;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyTel() {
        return emergencyTel;
    }

    public void setEmergencyTel(String emergencyTel) {
        this.emergencyTel = emergencyTel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Patient)) {
            return false;
        }
        Patient patient = (Patient) o;
        return Objects.equals(getId(), patient.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
