package com.freaver.goBang2.model.dao;

import java.util.function.Predicate;

/**
 * @author Freaver
 * @date 07/10/2021 14:16
 * @description 数据更新接口
 */
public interface Update<T> {

    /**
     * 修改数据
     * @param object 待更新数据
     * @param filter 更新文件方式的过滤器
     * @return 更新是否成功
     */
    boolean modify(Object object, Predicate filter);

}
