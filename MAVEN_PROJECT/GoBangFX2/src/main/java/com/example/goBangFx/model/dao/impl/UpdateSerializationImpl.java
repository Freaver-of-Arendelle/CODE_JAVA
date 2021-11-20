package com.example.goBangFx.model.dao.impl;

import com.example.goBangFx.model.dao.Create;
import com.example.goBangFx.model.dao.Retrieve;
import com.example.goBangFx.model.dao.Update;

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
     * @param file   文件路径
     * @param filter 更新文件方式的过滤器
     * @return 更新是否成功
     */
    @Override public boolean modify(Object object, File file, Predicate filter) {

        return init(object, filter, file);
    }

    /**
     * @param object 待更新数据
     * @param filter 更新文件方式的过滤器
     * @return 更新是否成功
     */
    @Override public boolean modify(Object object, Predicate filter) {

        return init(object, filter, file);
    }

    /**
     * 由于存在两个只有签名不同modify函数，为实现代码复用而生成的函数
     *
     * @param object 待更改对象
     * @param file   文件路径
     * @param filter 用于指定更改方式的过滤器
     * @return 更改是否成功
     */

    private boolean init(Object object, Predicate filter, File file) {
        Retrieve retrieve = RetrieveSerializationImpl.getSingleton();
        List<Object> list = (List<Object>)retrieve.get(file);
        boolean b = list.removeIf(filter);
        if (object != null) {
            list.add(object);
        }
        Create create = CreateSerializationImpl.getSingleton();
        boolean b1 = create.add(list, file);
        return b == b1;
    }
}
