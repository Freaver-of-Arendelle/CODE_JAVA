package model.dao.impl;

import model.dao.Retrieve;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RetrieveSerializationImpl implements Retrieve {
    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    @Override public Object get(File file) {
        return f(file);
    }

    @Override public Object get() {
        return f(file);
    }

    private Object f(File file) {
        FileInputStream fis = null;
        try {
            fis = FileUtils.openInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            return o;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
