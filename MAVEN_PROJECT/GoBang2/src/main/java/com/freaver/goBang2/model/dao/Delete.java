package com.freaver.goBang2.model.dao;

import java.util.function.Predicate;

/**
 * @author Freaver
 * @date 07/10/2021 14:18
 * @description 数据删除接口
 */
public interface Delete {

    /**
     * 删除数据
     * @param object 待删除对象
     * @param filter 删除方式过滤器
     * @return 删除是否成果
     */
    public boolean remove(Object object, Predicate filter);


    /**
     * 清空数据
     * @return 清空是否成功
     */
    public boolean clear();
}
