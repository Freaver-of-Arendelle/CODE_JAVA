package com.freaver.goBang2.model.dao;

/**
 * @author Freaver
 * @date 07/10/2021 14:14
 * @description 数据读取接口
 */
public interface Retrieve<T>{

    /**
     * 获取数据
     * @return <T>
     */
    public T get();



}
