package model.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author Freaver
 * @Time 07/09/2021 09:31
 * @description 评测类 用于对病患进行评测
 */
public class Estimator implements Serializable {

    /**
     * 病患姓名
     */
    private String name = "";

    /**
     *  病患性别
     */
    private String gender = "";

    /**
     *  模板姓名
     */
    private String templateName = "";

    /**
     *  模板类型
     */
    private String templateType = "";

    /**
     *  评估时间
     */
    private Date date;

    /**
     *  评估者
     */
    private String appraiser = "";

    /**
     *  建议
     */
    private String suggestion;

    public Estimator(String name, String gender, String templateName, String templateType, Date date, String appraiser, String suggestion) {
        this.name = name;
        this.gender = gender;
        this.templateName = templateName;
        this.templateType = templateType;
        this.date = date;
        this.appraiser = appraiser;
        this.suggestion = suggestion;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAppraiser() {
        return appraiser;
    }

    public void setAppraiser(String appraiser) {
        this.appraiser = appraiser;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Estimator)) {
            return false;
        }
        Estimator estimator = (Estimator) o;
        return Objects.equals(getName(), estimator.getName()) && Objects.equals(getGender(), estimator.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGender());
    }
}
