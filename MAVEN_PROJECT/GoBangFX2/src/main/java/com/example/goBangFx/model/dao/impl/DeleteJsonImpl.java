package com.example.goBangFx.model.dao.impl;


import com.example.goBangFx.model.dao.Delete;

import java.io.File;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @date 07/12/2021 13:57
 * @description 用于Json文件的Delete实现类
 */
public class DeleteJsonImpl implements Delete {

    private File file;


    /**
     * 设置文件路径
     *
     * @param file 文件路径
     */
    public void setFile(File file) {
        this.file = file;
    }



    private volatile static DeleteJsonImpl singleton;


    public DeleteJsonImpl() {
    }

    /**
     * 双重检查锁实现的单例模式
     */

    public static DeleteJsonImpl getSingleton() {
        if (singleton == null) {
            synchronized (DeleteJsonImpl.class) {
                if (singleton == null) {
                    singleton = new DeleteJsonImpl();
                }
            }
        }

        return singleton;
    }


    /**
     * 需要传递file的remove，用于设置file的路径
     *
     * @param object 待删除对象
     * @param file   文件路径
     * @param filter 用于指定删除方式的过滤器
     * @return 删除是否成功
     */
    @Override
    public boolean remove(Object object, File file, Predicate filter) {
        return init(object, filter, file);
    }


    /**
     * 无需传递文件版的remove，用在内部传递用
     *
     * @param object 待删除对象
     * @param filter 用于指定删除方式的过滤器
     * @return
     */
    @Override
    public boolean remove(Object object, Predicate filter) {
        return init(object, filter, file);
    }

    /**
     * 由于存在两个只有签名不同remove函数，为实现代码复用而生成的函数
     *
     * @param object 待删除对象
     * @param file   文件路径
     * @param filter 用于指定删除方式的过滤器
     * @return 删除是否成功
     */
    private boolean init(Object object, Predicate filter, File file) {
        UpdateJsonImpl update = UpdateJsonImpl.getSingleton();
        return update.modify(null, file, filter);
    }

    /**
     * 清空文件
     * @return 清空是否成功
     */
    @Override
    public boolean clear() {
        return file.delete();
    }
}
