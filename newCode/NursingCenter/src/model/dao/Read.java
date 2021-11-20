package model.dao;

import java.io.File;

/**
 * @author Freaver
 * @Time 07/10/2021 14:14
 * @Description 数据读取接口
 */
public interface Read <S>{
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
