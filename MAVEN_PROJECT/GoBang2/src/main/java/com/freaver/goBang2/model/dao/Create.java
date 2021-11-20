package com.freaver.goBang2.model.dao;

/**
 * @author Freaver
 * @date 07/10/2021 14:13
 * @description 数据添加接口
 */
public interface Create<S> {
    /**
     * 增加数据
     * @param s    待添加的泛型对象
     * @param file 文件路径
     * @return 添加是否成功
     */

    /**
     * 增加数据
     * @param s 待添加的泛型对象
     * @return 添加是否成功
     */
    public boolean add(S s);


}
