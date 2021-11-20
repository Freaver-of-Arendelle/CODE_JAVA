package model.dao;

import java.io.File;

public interface Create<T> {
    boolean add(T t, File file);

    boolean add(T t);
}
