package model.dao.impl;



import model.dao.Delete;

import java.io.*;
import java.util.function.Predicate;

public class DeleteSerializationImpl implements Delete {

    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    @Override public boolean remove(Object o, Predicate filter, File file) {
        return new UpdateSerializationImpl().modify(null, filter, file);
    }

    @Override public boolean remove(Object o, Predicate filter) {
        return new UpdateSerializationImpl().modify(null, filter, file);
    }



}
