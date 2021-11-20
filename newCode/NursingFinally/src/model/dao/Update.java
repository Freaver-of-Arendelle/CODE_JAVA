package model.dao;

import java.io.File;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @Time 07/10/2021 14:16
 * @Description 数据更新接口
 */
public interface Update<S> {
    /**
     * 修改数据
     * @param object 待更新数据
     * @param file   文件路径
     * @param filter 更新文件方式的过滤器
     * @return 更新是否成功
     */
    boolean modify(Object object, File file, Predicate filter);

    /**
     * 修改数据
     * @param object 待更新数据
     * @param filter 更新文件方式的过滤器
     * @return 更新是否成功
     */
    boolean modify(Object object, Predicate filter);
}
