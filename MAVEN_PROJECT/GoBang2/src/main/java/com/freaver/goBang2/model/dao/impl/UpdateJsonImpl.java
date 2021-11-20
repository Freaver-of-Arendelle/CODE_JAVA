package com.freaver.goBang2.model.dao.impl;



import com.freaver.goBang2.model.dao.Update;

import java.io.File;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @date 07/12/2021 13:58
 * @description 用于Json文件的Update实现类
 */
public class UpdateJsonImpl implements Update {

    private File file;

    /**
     * 设置文件路径
     *
     * @param file 文件路径
     */
    public void setFile(File file) {
        this.file = file;
    }



    private volatile static UpdateJsonImpl singleton;


    private UpdateJsonImpl() {
    }

    /**
     * 双重检查锁实现的单例模式
     */
    public static UpdateJsonImpl getSingleton() {
        if (singleton == null) {
            synchronized (UpdateJsonImpl.class) {
                if (singleton == null) {
                    singleton = new UpdateJsonImpl();
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
    @Override
    public boolean modify(Object object, Predicate filter) {
        RetrieveJsonImpl read = RetrieveJsonImpl.getSingleton();
        read.setFile(file);
        List list = read.get();
        list.removeIf(filter);
        if (object != null) {
            list.add(object);
        }
        CreateJsonImpl create = CreateJsonImpl.getSingleton();
        create.setFile(file);
        boolean b1 = create.add(list);
        return b1;
    }
}
