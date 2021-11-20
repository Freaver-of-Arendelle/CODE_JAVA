package model.dao;

import java.io.File;

public interface Retrieve<T> {
    T get(File file);

    T get();
}
