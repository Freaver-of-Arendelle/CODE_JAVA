package model.dao;

import java.io.File;
import java.util.function.Predicate;

public interface Delete {
    boolean remove(Object o, Predicate filter, File file);

    boolean remove(Object o, Predicate filter);
}
