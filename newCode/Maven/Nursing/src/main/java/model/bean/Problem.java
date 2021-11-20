package model.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.*;

/**
 * @author Freaver
 * @Time 07/09/2021 09:20
 * @Description 问题类
 */
public class Problem implements Serializable {

    /**
     * 问题序号
     */
    @JSONField(name = "id")
    private Integer id;

    /**
     * 具体题目
     */
    @JSONField(name = "question")
    private String question;

    /**
     * 问题的答案
     */
    @JSONField(name = "answers")
    private String[] answers;

    @JSONField(name = "map")
    private HashMap<String, Integer> map = new HashMap<>();

//    @JSONField(name = "reflect")
//    private Set<Integer> reflect;


    /**
     * 问题的类型
     */
    @JSONField(name = "type")
    private String type;


    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public Problem(Integer id, String question, String[] answers, String type) {
//        reflect = new HashSet<>();
        this.id = id;
        this.question = question;
        this.type = type;

//        if (templateId != null) {
//            setReflect(templateId);
//        }

        if (answers == null || answers.length != 3 ) {
            this.answers = new String[3];
            map.put(null, 5);
            map.put(null, 3);
            map.put(null, 1);
        } else {
            this.answers = answers;
            map.put(answers[0], 5);
            map.put(answers[1], 3);
            map.put(answers[2], 1);
        }


    }


    public Map<String, Integer> getMap() {
        return map;
    }




    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", type='" + type + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(o instanceof Problem)) {
            return false;
        }
        Problem problem = (Problem) o;
        return getId().equals(problem.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
