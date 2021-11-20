package com.freaver.goBang2.model.dao.impl;



import com.freaver.goBang2.model.dao.Delete;

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
     * 无需传递文件版的remove，用在内部传递用
     *
     * @param object 待删除对象
     * @param filter 用于指定删除方式的过滤器
     * @return
     */
    @Override
    public boolean remove(Object object, Predicate filter) {
        UpdateJsonImpl update = UpdateJsonImpl.getSingleton();
        update.setFile(file);
        return update.modify(null, filter);
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
