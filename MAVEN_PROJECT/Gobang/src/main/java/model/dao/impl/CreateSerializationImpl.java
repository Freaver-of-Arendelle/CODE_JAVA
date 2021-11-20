package model.dao.impl;

import model.dao.Create;
import model.dao.Retrieve;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreateSerializationImpl implements Create {

    private File file;

    @Override public boolean add(Object o, File file) {
        return f(o, file);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override public boolean add(Object o) {
        return f(o, file);
    }

    private boolean f(Object o, File file) {
        try {
            List<Object> list = new ArrayList<>();
            long length = file.length();
            if (length == 0 || !file.exists()) {
                list.add(o);
            } else if (o instanceof List) {
                list = (List<Object>)o;
            } else {
                Retrieve read = new RetrieveSerializationImpl();
                list = (List<Object>)read.get(file);
                list.add(o);
            }
            FileOutputStream fos = FileUtils.openOutputStream(file, false);
            ObjectOutput oop = new ObjectOutputStream(fos);
            oop.writeObject(list);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
