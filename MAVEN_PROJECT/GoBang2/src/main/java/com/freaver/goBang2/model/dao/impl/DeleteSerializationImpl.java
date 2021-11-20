package com.freaver.goBang2.model.dao.impl;



import com.freaver.goBang2.model.dao.Delete;

import java.io.File;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @date 07/10/2021 14:53
 * @description 用于序列化文件的Delete实现类
 */
public class DeleteSerializationImpl implements Delete {


    private File file;


    /**
     * 设置文件路径
     *
     * @param file 文件路径
     */
    public void setFile(File file) {
        this.file = file;
    }


    private volatile static DeleteSerializationImpl singleton;

    private DeleteSerializationImpl() {
    }

    /**
     * 双重检查锁实现的单例模式
     */

    public static DeleteSerializationImpl getSingleton() {
        if (singleton == null) {
            synchronized (DeleteSerializationImpl.class) {
                if (singleton == null) {
                    singleton = new DeleteSerializationImpl();
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
     * @return 删除是否成功
     */
    @Override
    public boolean remove(Object object, Predicate filter) {
        UpdateSerializationImpl update = UpdateSerializationImpl.getSingleton();
        update.setFile(file);
        return update.modify(null, filter);
    }

    /**
     * 清空文件
     *
     * @return 清空是否成功
     */
    @Override
    public boolean clear() {
        return file.delete();
    }
}
