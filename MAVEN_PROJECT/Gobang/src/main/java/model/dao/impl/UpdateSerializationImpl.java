package model.dao.impl;


import model.dao.Create;
import model.dao.Retrieve;
import model.dao.Update;

import java.io.File;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @date 10/12/2021
 * @time 18:01
 */
public class UpdateSerializationImpl implements Update {
    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    @Override public boolean modify(Object object, Predicate filter, File file) {
        return f(object, filter, file);
    }

    @Override public boolean modify(Object object, Predicate filter) {
        return f(object, filter, file);
    }

    private boolean f(Object object, Predicate filter, File file) {
        if (object != null) {
            Retrieve read = new RetrieveSerializationImpl();
            List<Object> list = (List<Object>)read.get(file);
            boolean b1 = list.removeIf(filter);
            list.add(object);
            Create create = new CreateSerializationImpl();
            boolean b2 = create.add(list, file);
            return b1 == b2;
        }
        return false;
    }

}
