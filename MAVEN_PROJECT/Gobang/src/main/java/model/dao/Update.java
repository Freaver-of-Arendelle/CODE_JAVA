package model.dao;

import java.io.File;
import java.util.function.Predicate;

public interface Update {
    boolean modify(Object o, Predicate filter, File file);

    boolean modify(Object o, Predicate filter);

}
