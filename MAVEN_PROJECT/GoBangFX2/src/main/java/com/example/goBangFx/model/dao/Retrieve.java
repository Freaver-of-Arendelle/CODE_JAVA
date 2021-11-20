package com.example.goBangFx.model.dao;

import java.io.File;

/**
 * @author Freaver
 * @date 07/10/2021 14:14
 * @description 数据读取接口
 */
public interface Retrieve<S>{
    /**
     * 获取数据
     * @param file 文件路径
     * @return <T>
     */
    public S get(File file);

    /**
     * 获取数据
     * @return <T>
     */
    public S get();


}
