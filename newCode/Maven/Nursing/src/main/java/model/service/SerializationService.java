package model.service;

import model.dao.*;
import model.dao.impl.CreateSerializationImpl;
import model.dao.impl.DeleteSerializationImpl;
import model.dao.impl.ReadSerializationImpl;
import model.dao.impl.UpdateSerializationImpl;

import java.io.File;

/**
 * @author Freaver
 * @Time 07/13/2021 15:44
 * @Description SerializationService抽象类，继承了Service接口
 */
public abstract class SerializationService implements Service {

    protected SerializationService() {
    }

    private static String path;

    /**
     * 以字符串方式设置文件路径
     *
     * @param path 文件路径的字符串形式
     */
    public static void setPath(String path) {
        SerializationService.path = path;
    }

    public static String getPath() {
        return path;
    }

    private CreateSerializationImpl create;
    private ReadSerializationImpl read;
    private UpdateSerializationImpl update;
    private DeleteSerializationImpl delete;

    /**
     * 获取以序列化方式的Read类型的对象
     *
     * @return Read
     */
    @Override
    public Read getRead() {
        read = ReadSerializationImpl.getSingleton();
        read.setFile(new File(path));
        return read;
    }

    /**
     * 获取以序列化方式的Create类型的对象
     *
     * @return Create
     */
    @Override
    public Create getCreate() {
        create = CreateSerializationImpl.getSingleton();
        create.setFile(new File(path));
        return create;
    }

    /**
     * 获取以序列化方式的Update类型的对象
     *
     * @return Update
     */
    @Override
    public Update getUpdate() {
        update = UpdateSerializationImpl.getSingleton();
        update.setFile(new File(path));
        return update;
    }


    /**
     * 获取以序列化方式的Delete类型的对象
     *
     * @return Delete
     */
    @Override
    public Delete getDelete() {
        delete = DeleteSerializationImpl.getSingleton();
        delete.setFile(new File(path));
        return delete;
    }
}
