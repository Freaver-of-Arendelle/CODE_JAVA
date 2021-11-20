package model.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Freaver
 * @Time 07/09/2021 09:31
 * @description 评测类 用于对病患进行评测
 */
public class Estimator implements Serializable {

    /**
     * 病患姓名
     */
    private String name;

    /**
     *  病患性别
     */
    private String gender;

    /**
     *  模板姓名
     */
    private String templateName;

    /**
     *  模板类型
     */
    private String templateType;

    /**
     *  评估时间
     */
    private Date date;

    /**
     *  评估者
     */
    private String appraiser;

    /**
     *  建议
     */
    private String suggestion;
}
