package model.dao.impl;

import model.dao.Update;

import java.io.File;
import java.util.Set;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @Time 07/12/2021 13:58
 * @Description 用于Json文件的Update实现类
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
     * 由于存在两个只有签名不同modify函数，为实现代码复用而生成的函数
     *
     * @param object 待更改对象
     * @param file   文件路径
     * @param filter 用于指定更改方式的过滤器
     * @return 更改是否成功
     */
    private boolean init(Object object, Predicate filter, File file) {
        ReadJsonImpl read = ReadJsonImpl.getSingleton();
        Set set = read.get(file);
        set.removeIf(filter);
        if (object != null) {
            set.add(object);
        }
        CreateJsonImpl create = CreateJsonImpl.getSingleton();
        boolean b1 = create.add(set, file);
        return b1;
    }

    /**
     * @param object 待更新数据
     * @param file   文件路径
     * @param filter 更新文件方式的过滤器
     * @return 更新是否成功
     */
    @Override
    public boolean modify(Object object, File file, Predicate filter) {
        return init(object, filter, file);
    }

    /**
     * @param object 待更新数据
     * @param filter 更新文件方式的过滤器
     * @return 更新是否成功
     */
    @Override
    public boolean modify(Object object, Predicate filter) {
        return init(object, filter, file);
    }
}
