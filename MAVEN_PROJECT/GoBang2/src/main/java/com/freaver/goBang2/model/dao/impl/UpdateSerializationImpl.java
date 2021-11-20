package com.freaver.goBang2.model.dao.impl;


import com.freaver.goBang2.model.dao.Update;

import java.io.File;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @date 07/10/2021 15:14
 * @description 用于序列化文件的Update实现类
 */
public class UpdateSerializationImpl implements Update {

    private File file;

    /**
     * 设置文件路径
     *
     * @param file 文件路径
     */
    public void setFile(File file) {
        this.file = file;
    }

    private UpdateSerializationImpl() {
    }

    private volatile static UpdateSerializationImpl singleton;

    /**
     * 双重检查锁实现的单例模式
     */
    public static UpdateSerializationImpl getSingleton() {
        if (singleton == null) {
            synchronized (UpdateSerializationImpl.class) {
                if (singleton == null) {
                    singleton = new UpdateSerializationImpl();
                }
            }

        }
        return singleton;
    }


    /**
     * @param object 待更新数据
     * @param filter 更新文件方式的过滤器
     * @return 更新是否成功
     */
    @Override public boolean modify(Object object, Predicate filter) {

        RetrieveSerializationImpl retrieve = RetrieveSerializationImpl.getSingleton();
        List<Object> list = (List<Object>)retrieve.get();
        boolean b = list.removeIf(filter);
        if (object != null) {
            list.add(object);
        }
        CreateSerializationImpl create = CreateSerializationImpl.getSingleton();
        create.setFile(file);
        boolean b1 = create.add(list);
        return b == b1;
    }

}
