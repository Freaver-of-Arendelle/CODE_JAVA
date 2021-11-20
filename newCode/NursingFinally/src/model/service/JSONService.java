package model.service;

import model.dao.*;
import model.dao.impl.*;

import java.io.File;

/**
 * @author Freaver
 * @Time 07/13/2021 15:59
 * @Description JsonService抽象类，继承了Service接口
 */
public abstract class JSONService implements Service {

    private CreateJsonImpl create;
    private ReadJsonImpl read;
    private UpdateJsonImpl update;
    private DeleteJsonImpl delete;

    private static String path;


    /**
     * 以字符串方式设置文件路径
     *
     * @param path 文件路径的字符串形式
     */
    public static void setPath(String path) {
        JSONService.path = path;
    }

    public static String getPath() {
        return path;
    }

    protected JSONService() {
    }


    /**
     * 获取以序列化方式的Read类型的对象
     *
     * @return Read
     */
    @Override
    public Read getRead() {
        read = ReadJsonImpl.getSingleton();
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
        create = CreateJsonImpl.getSingleton();
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

        update = UpdateJsonImpl.getSingleton();
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
        delete = DeleteJsonImpl.getSingleton();
        delete.setFile(new File(path));
        return delete;
    }
}
