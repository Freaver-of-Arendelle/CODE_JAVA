package model.dao.impl;

import model.dao.Delete;
import model.dao.Update;

import java.io.File;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @Time 07/10/2021 14:53
 * @Description 用于序列化文件的Delete实现类
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
     * @return 删除是否成功
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
        Update update2 = UpdateSerializationImpl.getSingleton();
        return update2.modify(null, file, filter);
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
