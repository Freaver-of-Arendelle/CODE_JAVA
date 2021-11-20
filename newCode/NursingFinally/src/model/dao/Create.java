package model.dao;

import java.io.File;

/**
 * @author Freaver
 * @Time 07/10/2021 14:13
 * @Description 数据添加接口
 */
public interface Create<S> {
    /**
     * 增加数据
     * @param s    待添加的泛型对象
     * @param file 文件路径
     * @return 添加是否成功
     */
    public boolean add(S s, File file);

    /**
     * 增加数据
     * @param s 待添加的泛型对象
     * @return 添加是否成功
     */
    public boolean add(S s);

}
