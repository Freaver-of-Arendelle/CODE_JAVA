package model.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.*;

/**
 * @author Freaver
 * @Time 07/09/2021 09:20
 * @Description 问题类
 */
public class Problem implements Serializable, Comparable<Problem> {

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


    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Problem o) {
        if (this.id == null) {
            return -1;
        } else if (o.getId() == null) {
            return 1;
        } else {
            return this.id - o.getId();
        }
    }
}
