package pattern.behavioral.iterator;

/**
 * @author Freaver
 * @date 5/1/2021 22:21
 */
public interface StudentAggregate {

    void addStudent(Student student);

    void removeStudent(Student student);

    StudentIterator getStudentIterator();
}
