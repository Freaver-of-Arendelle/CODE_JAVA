package pattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Freaver
 * @date 5/1/2021 22:22
 */
public class StudentAggregateImpl implements StudentAggregate{

    private List<Student> list = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        this.list.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        this.list.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudnetIteratorImpl(list);
    }
}
