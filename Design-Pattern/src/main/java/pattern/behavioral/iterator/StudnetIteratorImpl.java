package pattern.behavioral.iterator;

import java.util.List;

/**
 * @author Freaver
 * @date 5/1/2021 22:19
 */
public class StudnetIteratorImpl implements StudentIterator{

    private List<Student> list;
    private int position  = 0;

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        return list.get(position++);
    }

    public StudnetIteratorImpl(List<Student> list) {
        this.list = list;
    }
}
