package pattern.creational.prototype.deep_clone;


import java.io.Serializable;

/**
 * @author Freaver
 * @date 4/28/2021 18:47
 */
public class Citation implements Serializable {

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    protected Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void show() {
        System.out.println(student.getName() + "同学：在2020学年第一学期中表现优秀，被评为三好学生。特发此状！");
    }

}
