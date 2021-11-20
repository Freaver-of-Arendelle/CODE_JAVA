package model.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author Freaver
 * @Time 07/09/2021 09:17
 * @Description 模板类
 */
public class Template implements Serializable, Comparable<Template> {
    /**
     * 模板编号
     */
    @JSONField(name = "id")
    private Integer id;

    /**
     * 题目
     */
    @JSONField(name = "title")
    private String title;

    /**
     * 包含问题
     */
    @JSONField(name = "problems")
    private Set<Problem> problems;


    /**
     * 类型
     */
    @JSONField(name = "type")
    private String type;


    public Template(Integer id, String title, Set<Problem> problems, String type) {
        this.id = id;
        this.title = title;
        this.problems = problems;
        this.type = type;

//        if (problems != null) {
//            for (Problem problem : problems) {
//                problem.setReflect(id);
//            }
//        }


    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Problem> getProblems() {
        return problems;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setProblems(Set<Problem> problems) {
        this.problems = problems;
    }


    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", problems" +
                "=" + problems +
                ", type='" + type + '\'' +
                '}';
    }

    /**
     * 由于运用了Set进行数据的存储，故需要重写equals和hashcode方法来限定判断条件
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Template)) {
            return false;
        }
        Template template = (Template) o;
        return getId().equals(template.getId());
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
    public int compareTo(Template o) {
        if (this.id == null) {
            return -1;
        } else if (o.getId() == null) {
            return 1;
        } else {
            return this.id - o.getId();
        }
    }
}
